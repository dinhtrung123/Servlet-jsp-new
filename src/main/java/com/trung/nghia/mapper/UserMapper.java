package com.trung.nghia.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trung.nghia.model.RoleModel;
import com.trung.nghia.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapper(ResultSet resultSet) {
		  UserModel userModel =  new UserModel();
		try {
			userModel.setUserName(resultSet.getString("name"));
			userModel.setPassword(resultSet.getString("password"));
			userModel.setFullName(resultSet.getString("fullname"));
			userModel.setStatus(resultSet.getInt("status"));
			userModel.setRoleid(resultSet.getLong("roleid"));
			RoleModel roleModel =  new RoleModel() ;
			try {
				roleModel.setCode(resultSet.getString("code"));
				roleModel.setName(resultSet.getString("name"));
				userModel.setRole(roleModel);
			}catch (Exception e){
				System.out.println(e.getMessage());
			}

			return userModel ;
		} catch (SQLException e) {
			
			return null;
		}
	
	}
	


}
