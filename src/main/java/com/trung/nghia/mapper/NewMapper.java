package com.trung.nghia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trung.nghia.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapper(ResultSet resultSet) {

		try {
			NewModel news = new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortdese(resultSet.getString("shortdese"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryid(resultSet.getLong("categoryid"));
			news.setCreatedDate(resultSet.getTimestamp("createdDate"));
			news.setCreatedBy(resultSet.getString("createdBy"));
			if(resultSet.getTimestamp("modifieddate")!=null)
			{
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby")!=null)
			{
				news.setModifIedby(resultSet.getString("modifiedby"));
			}
			return news ;
		} catch (SQLException e) {
			return null ;
		}
	
	
	}

}
