package com.dom.apiRest.apiRestFull.security;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dom.apiRest.apiRestFull.models.UsuarioLoginModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	@Value("${jwt.secret}")
	private String secret;
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimResolver.apply(claims);
	}
	
	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	public String getusernameFromToken (String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public String GenerateToken(UsuarioLoginModel usuario) {
		Map<String, Object> claims = new HashMap<>();
		return generateJwtToken(claims, usuario.getEmail());
	}
	
	public String generateJwtToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ 5 * 60 *60 * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
