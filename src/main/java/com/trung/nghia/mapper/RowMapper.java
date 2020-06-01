package com.trung.nghia.mapper;

import java.sql.ResultSet;

public interface RowMapper<T>  {
	T mapper(ResultSet resultSet);
	

}
