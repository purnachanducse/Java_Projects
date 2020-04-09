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

@Service
public class JwtUtil {

	private String SECRET_KEY = "secret";

	public String extarctUsername(String token) {
		return extarctClaim(token, Claims::getSubject);
	}

	private <R> R extarctClaim(String token, Function<Claims, R> claimsResolver) {
		// TODO Auto-generated method stub
		final Claims claims = extarctAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extarctAllClaims(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
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
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = userDetails.getUsername();
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
