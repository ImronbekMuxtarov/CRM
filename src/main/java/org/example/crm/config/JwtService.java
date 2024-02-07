package org.example.crm.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private Long jwtExpiration;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private Long refreshExpiration;

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date getExpDate(String  token){
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        return claimsResolver.apply(
                extractAllClaims(token)
        );
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSignInkey(){
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secretKey)
        );
    }
}
