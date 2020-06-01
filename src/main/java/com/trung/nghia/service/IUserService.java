package com.trung.nghia.service;

import com.trung.nghia.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName , String password ,Integer status) ;
}
