package com.trung.nghia.DAO;

import com.trung.nghia.model.UserModel;

public interface IUserDAO  extends GenericeDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName , String password ,Integer status) ;
	

}
