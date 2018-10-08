package com.biswo.myspringapp.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.biswo.myspringapp.dao.CountriesDAO;
import com.biswo.myspringapp.model.Country;

@Component
@CacheConfig(cacheNames = { "COUNTRIES" })
public class CountriesCacheService {
	@Autowired
	CountriesDAO countriesDAO;

	@Cacheable(unless = "#result == null", cacheManager = "cacheManager")
	public Country getTheSpecificContry(long countryId) {
		setCacheMiss(true);
		return countriesDAO.getContryDetails(countryId);
	}

	@Cacheable(unless = "#result == null", cacheManager = "cacheManager", key = "#id")
	public List<Country> getAllCountry(Set<Long> keys) {
		setCacheMiss(true);
        List<Country> results = new ArrayList<Country>(keys.size());
        results.addAll( countriesDAO.fetchAllCoutries(keys));
       return results;
	}

	
	@Cacheable(value = "country", key = "#id", sync = true)
	  public Country removeCourty(Country country) {
		setCacheMiss(true);
		return country;
	  }
	
	private boolean cacheMiss;

	public synchronized boolean isCacheMiss() {

		boolean cacheMiss = this.cacheMiss;

		setCacheMiss(false);

		return cacheMiss;
	}

	public synchronized void setCacheMiss(boolean cacheMiss) {
		this.cacheMiss = cacheMiss;
	}

}
