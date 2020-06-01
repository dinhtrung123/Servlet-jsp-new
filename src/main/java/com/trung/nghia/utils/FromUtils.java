package com.trung.nghia.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FromUtils {
      
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> clazz ,HttpServletRequest request ) {
		T opject = null ;
		try {
			opject =  clazz.newInstance();
			BeanUtils.populate(opject, request.getParameterMap());
			
		} catch (InstantiationException | IllegalAccessException |InvocationTargetException e) {
	
			e.printStackTrace();
		} 
		
	return opject ;	
	}
}
