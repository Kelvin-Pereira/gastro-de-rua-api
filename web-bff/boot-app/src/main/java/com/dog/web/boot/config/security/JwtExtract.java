package com.dog.web.boot.config.security;

import com.dog.core.auth.domain.entity.Address;
import com.dog.core.auth.domain.entity.User;
import com.dog.web.auth.UcFindUserByEmailUser;
import com.dog.web.boot.config.exception.EmailException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtExtract {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    private final UcFindUserByEmailUser ucFindUserByEmailUser;

    public String extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        Object userClaimsObj = claims.get("user");

        if (userClaimsObj instanceof Map) {
            Map<String, Object> userClaims = (Map<String, Object>) userClaimsObj;
            return userClaims.get("email").toString();
        }

        throw new IllegalArgumentException("Claims 'user' is not a valid Map");
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = createClaim(userDetails);
        return generateToken(claims);
    }

    private Map<String, Object> createClaim(UserDetails userDetails) {
        User user = ucFindUserByEmailUser.apply(userDetails.getUsername()).orElseThrow(EmailException::emailNaoEncontrado);
        Map<String, Object> claims = new HashMap<>();

        Map<String, Object> claimsUser = new HashMap<>();
        claimsUser.put("name", user.name());
        claimsUser.put("email", user.email());
        claimsUser.put("birthDate", user.birthDate().toString());
        claimsUser.put("urlPhoto", user.phone());
        claims.put("user", claimsUser);
        claims.put("email", user.email());

        Address address = user.getAddressPrincipal();
        if (address != null) {
            Map<String, Object> claimsAddress = new HashMap<>();
            claimsAddress.put("postalCode", address.postalCode());
            claimsAddress.put("street", address.street());
            claimsAddress.put("number", address.number());
            claimsAddress.put("complement", address.complement());
            claimsAddress.put("neighborhood", address.neighborhood());
            claimsAddress.put("city", address.city());
            claimsAddress.put("state", address.state());
            claims.put("address", claimsAddress);
        }

        claims.put("role", userDetails.getAuthorities().stream().map(Object::toString).collect(Collectors.joining(",")));

        return claims;
    }

    public String generateToken(Map<String, Object> extraClaims) {
        return buildToken(extraClaims, jwtExpiration);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return buildToken(createClaim(userDetails), refreshExpiration);
    }

    private String buildToken(Map<String, Object> extraClaims, long expiration) {
        Claims claims = Jwts.claims(extraClaims);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
