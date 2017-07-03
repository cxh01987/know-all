package com.jarris;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;


public class iclarityParseToken implements MessageProcessor  {

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {

		MuleMessage message = event.getMessage();
		JwtSupport jwtSupport = new JwtSupport();
		try {
			String token = message.getInboundProperty("token").toString();
			Jws<Claims> parseJwt = jwtSupport.parseJwt(token.substring(0, token.indexOf("|")),
					token.substring(token.indexOf("|") + 1, token.length()));
			Object idS = parseJwt.getBody().getIssuer();
			System.out.println("token3:" + idS);
			message.setOutboundProperty("token", String.valueOf(idS));
		} catch (Exception e) {
			e.printStackTrace();
		}
		event.setMessage(message);
		return event;
	}
}
