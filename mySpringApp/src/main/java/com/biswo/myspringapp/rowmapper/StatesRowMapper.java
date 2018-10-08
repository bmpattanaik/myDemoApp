package com.biswo.myspringapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.biswo.myspringapp.model.State;

public class StatesRowMapper implements RowMapper<State>
{

	@Override
	public State mapRow(ResultSet rs, int arg1) throws SQLException {
		long id = rs.getLong("ID");
		long countryID = rs.getLong("COUNTRY_ID");
		String name = rs.getString("NAME");
		State state = new State(id,name,countryID);
		return state;
	}

}
