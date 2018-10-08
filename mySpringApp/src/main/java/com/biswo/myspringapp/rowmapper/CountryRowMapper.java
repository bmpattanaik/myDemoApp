package com.biswo.myspringapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.biswo.myspringapp.model.Country;

public class CountryRowMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int arg1) throws SQLException {

		long id = rs.getLong("ID");
		long phoneCode = rs.getLong("PHONECODE");
		String name = rs.getString("NAME");
		String sortName = rs.getString("SORTNAME");
		Country country = new Country(id, phoneCode, name, sortName);
		return country;
	}

}
