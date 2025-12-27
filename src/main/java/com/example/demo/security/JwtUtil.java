package com.example.demo.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final String SECRET =
            "sdjhgbwubwwbgwiub8QFQ8qg87G1bfewifbiuwg7iu8wefqhjk";

    private final SecretKey key;
    private int expirationMs = 10 * 60 * 1000;


    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor(SECRET.getBytes());
    }


    public JwtUtil(String secret, int expirationMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = expirationMs;
    }



    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(Long userId, String email, Role role) {
        return generateToken(userId, email, role.name());
    }

    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }




    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }



    public ResponseEntity<Boolean> validateToken(String token) {
        try {
            extractEmail(token);
            return ResponseEntity.ok(!isTokenExpired(token));
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }
     public Jws<Claims> validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    public ResponseEntity<Boolean> validateToken(String token, String email) {
        try {
            String tokenEmail = extractEmail(token);
            boolean valid = tokenEmail.equals(email) && !isTokenExpired(token);
            return ResponseEntity.ok(valid);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration = extractAllClaims(token).getExpiration();
        return expiration.before(new Date());
    }
}
