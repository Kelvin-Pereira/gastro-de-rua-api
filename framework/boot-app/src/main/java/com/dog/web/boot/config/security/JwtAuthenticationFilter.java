package com.dog.web.boot.config.security;

import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.PermissionEnum;
import com.dog.usecase.auth.services.token.TokenService;
import com.dog.usecase.auth.services.user.FindUserByEmailUserService;
import com.dog.web.boot.config.exception.EmailException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtExtract jwtExtract;
  private final TokenService tokenService;
    private final FindUserByEmailUserService findUserByEmailUserService;

  // TODO verificar se está vindo token
  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain
  ) throws ServletException, IOException {
    if (request.getServletPath().contains("/api/v1/login")) {
      filterChain.doFilter(request, response);
      return;
    }
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }
    jwt = authHeader.substring(7);
    userEmail = jwtExtract.extractUsername(jwt);
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        User userDetails = findUserByEmailUserService.apply(userEmail).orElseThrow(EmailException::emailNaoEncontrado);
      var isTokenValid = tokenService.findByToken(jwt)
          .map(t -> !t.isExpired() && !t.isRevoked())
          .orElse(false);
      if (jwtExtract.isTokenValid(jwt, userDetails) && Boolean.TRUE.equals(isTokenValid)) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            userDetails,
            null,
                getAuthorities(userDetails.role().permissions())
        );
        authToken.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }
    filterChain.doFilter(request, response);
  }

    private List<SimpleGrantedAuthority> getAuthorities(Set<PermissionEnum> permission) {
        return permission
                .stream()
                .map(permissionEnum -> new SimpleGrantedAuthority(permissionEnum.name()))
                .toList();
    }

}
