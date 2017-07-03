/**
 * MuleSoft Examples
 * Copyright 2014 MuleSoft, Inc.
 *
 * This product includes software developed at
 * MuleSoft, Inc. (http://www.mulesoft.com/).
 */

package org.mule.examples;

import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;

public class InputDataValidator implements Filter {

	@Override
	public boolean accept(MuleMessage message) {
		Map<String, Object> payloadMap = (Map<String, Object>) message.getPayload();
		
		if (!payloadMap.containsKey("email")) 
			throw new NullPointerException("email is missing");	
		else if(!payloadMap.containsKey("id"))
			throw new IllegalArgumentException("item price per unit is negative");
		
		return true;
	}

}
