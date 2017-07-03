package com.jarris;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtSupport {

	// JWT0001=Create Token Failed
	private static final String JWT0001 = "JWT0001";
	// JWT0002=Parse Token Failed
	private static final String JWT0002 = "JWT0002";
	
	private static final String CHARSET_NAME = "UTF-8";
	private Key key = null;
	public String createJwt(String subject, String content,int randomSecretKey) {
		String compact = "";
		try {
			long currentTimeMillis = System.currentTimeMillis();
			compact = Jwts.builder().setSubject(subject).signWith(SignatureAlgorithm.HS512, String.valueOf(randomSecretKey).getBytes(CHARSET_NAME))
					.setIssuedAt(new Date(currentTimeMillis))
					.setIssuer(content)
					.compact();

		} catch (Exception e) {
			System.out.println(JWT0001 + e.getMessage());
		}
		return compact + "|" + randomSecretKey;
	}

	public Jws<Claims> parseJwt(String jwt,String randomSecretKey) {
		Jws<Claims> parseClaimsJws = null;
		try {
			parseClaimsJws = Jwts.parser().setSigningKey(
					randomSecretKey.getBytes(CHARSET_NAME)).parseClaimsJws(jwt);
			
		} catch (Exception e) {
			System.out.println(JWT0002 + e.getMessage());
		}
		return parseClaimsJws;
	}
}
