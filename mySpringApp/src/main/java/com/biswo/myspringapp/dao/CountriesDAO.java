package com.biswo.myspringapp.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.biswo.myspringapp.model.Country;
import com.biswo.myspringapp.rowmapper.CountryRowMapper;

public class CountriesDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	public CountriesDAO(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public List<Country> fetchAllCoutries() {
		String SQL = "SELECT * FROM COUNTRIES ";
		List<Country> countries = jdbcTemplate.query(SQL, new CountryRowMapper());
		return countries;

	}

	public List<Country> fetchAllCoutries(Set<Long> keySet) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("keys", keySet);

		String SQL = "SELECT * FROM COUNTRIES where ID in (:keys) ";
		List<Country> countries = namedParameterJdbcTemplate.query(SQL,parameters, new CountryRowMapper());
		return countries;

	}

	public Country getContryDetails(long countryId) {
		String SQL = "SELECT * FROM COUNTRIES where ID=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] { countryId }, new CountryRowMapper());

	}
}
