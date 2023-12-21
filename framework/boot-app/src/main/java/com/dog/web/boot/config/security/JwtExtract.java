package com.dog.web.boot.config.security;


import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.services.token.ClaimsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtExtract {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    private final ClaimsService claimsService;

    public String extractUsername(String jwt) {
        Claims claims = extractAllClaims(jwt);
        Object userClaimsObj = claims.get("user");

        if (userClaimsObj instanceof Map<?, ?> userClaims) {
            return userClaims.get("email").toString();
        }
        throw new IllegalArgumentException("Claims 'user' is not a valid Map");
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(User user) {
        Map<String, Object> claims = claimsService.apply(user);
        return generateToken(claims);
    }

    public String generateToken(Map<String, Object> extraClaims) {
        return buildToken(extraClaims, jwtExpiration);
    }

    public String generateRefreshToken(User user) {
        Map<String, Object> clamsRefreshToken = new HashMap<>();
        clamsRefreshToken.put("email", user.email());
        return buildToken(clamsRefreshToken, refreshExpiration);
    }

    public String extractUsernameRefreshToken(String jwt) {
        Claims claims = extractAllClaims(jwt);
        Object userClaimsObj = claims.get("email");
        if (userClaimsObj instanceof String) {
            return userClaimsObj.toString();
        }
        throw new IllegalArgumentException("Claims 'email' is not a valid");
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

    public boolean isTokenValid(String jwt, User userDetails) {
        final String username = extractUsername(jwt);
        return (username.equals(userDetails.email())) && isTokenExpired(jwt);
    }

    public boolean isTokenRefreshValid(String jwt, User userDetails) {
        final String username = extractUsernameRefreshToken(jwt);
        return (username.equals(userDetails.email())) && isTokenExpired(jwt);
    }

    private boolean isTokenExpired(String token) {
        return !extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
