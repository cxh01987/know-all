package com.jarris;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;

public class errorHanding implements MessageProcessor{

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		 throw new IllegalArgumentException("参数长度不是7位");   
	}

}
