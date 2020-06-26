package com.bht.humanresource.security.jwt;

import com.bht.humanresource.service.UserDetailsServiceImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private static final String JWT_SECRET = "KEYWORD";

    @Value("${bezkoder.app.jwtExpirationMs}")
    private static final int JWT_EXPIRATION_TIME = 360000;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsServiceImpl userPrincipal = (UserDetailsServiceImpl) authentication.getPrincipal();

        return Jwts.builder()
                // userPrincipal.getName();
                .setSubject((userPrincipal.getClass().getName()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
    }
}