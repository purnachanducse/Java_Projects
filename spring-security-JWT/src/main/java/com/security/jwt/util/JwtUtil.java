package com.security.jwt.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

@Service
public class JwtUtil {

	private String SECRET_KEY = "secret";

	public String extarctUsername(String token) {
		String extarctClaim = extarctClaim(token, Claims::getSubject);
		System.out.println("extarctClaim: " + extarctClaim);
		return extarctClaim;
	}

	public <T> T extarctClaim(String token, Function<Claims, T> claimsResolver) {
		// TODO Auto-generated method stub
		final Claims claims = extarctAllClaims(token);
		T apply = claimsResolver.apply(claims);
		System.out.println("apply: " + apply);
		return apply;
	}

	private Claims extarctAllClaims(String token) {
		// TODO Auto-generated method stub
		Claims claims = new DefaultClaims();
		claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		System.out.println("claims: " + claims);
		return claims;
	}

	private Date extarctExpiration(String token) {
		return extarctClaim(token, Claims::getExpiration);
	}

	private Boolean isTokenExpired(String token) {
		return extarctExpiration(token).before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String username) {
		// TODO Auto-generated method stub

		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = userDetails.getUsername();
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
