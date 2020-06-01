package com.trung.nghia.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trung.nghia.model.Category;

public class CateMapper implements RowMapper<Category> {

	@Override
	public  Category mapper(ResultSet resultSet) {
		Category category = new Category();
		try {
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			return null;
		}

	}
	
}
