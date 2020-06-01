package com.trung.nghia.service.imp;

import com.trung.nghia.DAO.IUserDAO;
import com.trung.nghia.DAO.impl.UserDAO;
import com.trung.nghia.model.UserModel;
import com.trung.nghia.service.IUserService;

import javax.inject.Inject;

public class UserSevice implements IUserService {
	private IUserDAO UserSevice ;
	
 
	public UserSevice() {
	   UserSevice =  new UserDAO() ;
	}


	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
	
		return UserSevice.findByUserNameAndPasswordAndStatus(userName, password, status);
		
	}
	
	

}
