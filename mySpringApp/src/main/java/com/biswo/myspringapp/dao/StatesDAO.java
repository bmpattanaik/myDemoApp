package com.biswo.myspringapp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.biswo.myspringapp.model.Country;
import com.biswo.myspringapp.model.State;
import com.biswo.myspringapp.rowmapper.CountryRowMapper;
import com.biswo.myspringapp.rowmapper.StatesRowMapper;

public class StatesDAO {

	private JdbcTemplate jdbcTemplate;

	public StatesDAO(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<State> fetchStateFromCourty(long counrtyId){
		
		String SQL = "SELECT * FROM STATES where country_id=?";
		List<State> states = jdbcTemplate.query(SQL,new Object[] { counrtyId }, new StatesRowMapper());
		return states;
	}

}
