package com.biswo.myspringapp.activators;

import java.util.Random;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.biswo.myspringapp.dao.CountriesDAO;
import com.biswo.myspringapp.model.Country;

public class CountryInboundAdapter {
	Random r = new Random();
	int min=1;
	int max=239;
	/*@Autowired
	CountriesCacheService countriesCacheService;*/

/*	public Message<Country> processData() {

		Set<Long> keySet = LongStream.rangeClosed(1, 240).boxed().collect(Collectors.toSet());
		List<Country> courtyList = countriesCacheService.getAllCountry(keySet);

		if (courtyList != null && !courtyList.isEmpty()) {
			Country country = courtyList.get(0);
			countriesCacheService.removeCourty(country);
			return MessageBuilder.withPayload(country).setHeader("COUNTRY_ID", country.getId()).build();
		}
		return null;
	}*/

	/*public void setCountriesCacheService(CountriesCacheService countriesCacheService) {
		this.countriesCacheService = countriesCacheService;
	}*/

	private CountriesDAO countriesDAO;
	
	public Message<Country> processData() {

		long randomId=r.nextInt((max - min) + 1) + min;
		
		Country country=countriesDAO.getContryDetails(randomId);
		
		if (country != null && country.getId()!=0) {
			return MessageBuilder.withPayload(country).setHeader("COUNTRY_ID", country.getId()).build();
		}
		return null;
	}

	public void setCountriesDAO(CountriesDAO countriesDAO) {
		this.countriesDAO = countriesDAO;
	}
	
	
}
