package com.trung.nghia.DAO.impl;

import java.util.List;

import com.trung.nghia.DAO.IUserDAO;
import com.trung.nghia.mapper.UserMapper;
import com.trung.nghia.model.UserModel;


public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder( "SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid ");
		sql.append(" WHERE  u.name =? AND u.password = ? AND u.status = ?");
		List<UserModel> user = query(sql.toString(),new UserMapper(), userName ,password ,status);
		return user.isEmpty() ? null : user.get(0);
	}
   
	
	
}
