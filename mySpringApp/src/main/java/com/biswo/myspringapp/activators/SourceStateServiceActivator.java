package com.biswo.myspringapp.activators;

import java.util.List;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.biswo.myspringapp.dao.StatesDAO;
import com.biswo.myspringapp.model.Country;
import com.biswo.myspringapp.model.State;

public class SourceStateServiceActivator {

	StatesDAO statesDAO;

	public Message<List<State>> getAllStates(Message<Country> message) {

		Country country = message.getPayload();
		if (country.getId() != 0l) {
			List<State> states = statesDAO.fetchStateFromCourty(country.getId());
			if (!states.isEmpty() && states.size() > 0) {
				return MessageBuilder.withPayload(states).setHeader("COUNTRY",country).build();
			}
		}

		return null;
	}

	public void setStatesDAO(StatesDAO statesDAO) {
		this.statesDAO = statesDAO;
	}

}
