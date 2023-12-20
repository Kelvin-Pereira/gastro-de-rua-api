package com.dog.web.boot.config.security;

import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.TokenType;
import com.dog.usecase.auth.services.token.TokenRevokeAllUserService;
import com.dog.usecase.auth.services.token.TokenService;
import com.dog.usecase.auth.services.user.FindUserByEmailUserService;
import com.dog.usecase.utils.functions.BiConsumerIOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenRefreshService implements BiConsumerIOException<HttpServletRequest, HttpServletResponse> {

    private final TokenService tokenService;
    private final JwtExtract jwtExtract;
    private final TokenRevokeAllUserService tokenRevokeAllUserService;
    private final FindUserByEmailUserService findUserByEmailUserService;

    @Override
    public void accept(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        final String authHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;
        final String email;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        email = jwtExtract.extractUsernameRefreshToken(jwt);
        if (email != null) {
            // TODO tratar lancamento de error email
            User user = findUserByEmailUserService.apply(email).orElseThrow();
            if (jwtExtract.isTokenRefreshValid(jwt, user)) {
                String accessToken = jwtExtract.generateToken(user);
                tokenRevokeAllUserService.accept(user);
                tokenService.save(new AccessToken(accessToken, user));
                var authResponse = TokenResponseType.builder()
                        .accessToken(accessToken)
                        .refreshToken(jwt)
                        .build();

                ObjectMapper objectMapper = new ObjectMapper();
                String jsonResponse = objectMapper.writeValueAsString(authResponse);
                httpServletResponse.setContentType("application/json");
                httpServletResponse.getWriter().write(jsonResponse);
            }
        }
    }

    private record AccessToken(String jwt, User user) implements Token {
        @Override
        public Long id() {
            return null;
        }

        @Override
        public TokenType tokenType() {
            return TokenType.BEARER;
        }

        @Override
        public boolean isRevoked() {
            return false;
        }

        @Override
        public boolean isExpired() {
            return false;
        }

        @Override
        public Long idUser() {
            return user.id();
        }
    }
}
