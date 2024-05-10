package com.riwi.beautySalon.infraestructure.helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.riwi.beautySalon.domain.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTService {

    // Crear una variable para guardar mi llave privada (SIGNATURE)
    private static final String SECRET_KEY = "RWxzYXBvcGVycm8zMDAwQ0xBVkVzdXBlcnNlY3JldGFwYXJhZWxzYXBvcGVycm9UZWFt";

    // Método que se va a encargar de retornar la llave de forma encriptada
    public SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Método para construir nuestro token
    private String getToken(Map<String, Object> claims, User user) {
        return Jwts
                .builder()
                .claims(claims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(this.getKey())
                .compact();
    }

    // Método para retornar el token con los claims configurados
    public String getToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("role", user.getRole());

        return this.getToken(claims, user);
    }
}
