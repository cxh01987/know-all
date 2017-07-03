package com.jarris;

import java.security.SecureRandom;

import org.codehaus.jackson.map.ObjectMapper;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;

import com.jarris.bean.EmpEvLogInResponse;


public class iclarityCreateToken implements MessageProcessor  {

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {

		MuleMessage message = event.getMessage();   
		JwtSupport jwtSupport = new JwtSupport();
		try {
			String payLoadString = message.getPayloadAsString();
			ObjectMapper mapper = new ObjectMapper();
			int randomSecretKey = new SecureRandom().nextInt();
			EmpEvLogInResponse recordRs = mapper.readValue(payLoadString, EmpEvLogInResponse.class);
			String idS = String.valueOf(recordRs.getEmployee().getId());
			System.out.println("ID:"+idS);
			String token = jwtSupport.createJwt(recordRs.getEmployee().getlName(),idS,randomSecretKey);
			message.setPayload(token);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		event.setMessage(message);
		return event;
	}
}
