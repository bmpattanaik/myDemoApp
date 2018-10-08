package com.biswo.myspringapp.activators;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.biswo.myspringapp.model.State;

public class ServiceActivatorOne {
	
	public Message<State> processState(Message<State> message){
		State state=message.getPayload();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(state!=null){
			return MessageBuilder.withPayload(state).build();
		}
		
		
		return null;
		
	}

}
