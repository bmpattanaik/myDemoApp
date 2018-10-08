package com.biswo.myspringapp.activators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

import com.biswo.myspringapp.model.State;

public class ServiceActivatorTwo {
	 private static final Logger LOGGER = LogManager.getLogger(ServiceActivatorTwo.class);
		
	public void processState(Message<State> message){
		State state=message.getPayload();
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(state!=null){
			LOGGER.debug(state);
			
		}*/
	}
}
