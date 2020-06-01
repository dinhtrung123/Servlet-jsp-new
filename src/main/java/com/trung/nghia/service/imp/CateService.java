package com.trung.nghia.service.imp;

import com.trung.nghia.DAO.ICategoryDAO;
import com.trung.nghia.DAO.impl.CategoryDAO;
import com.trung.nghia.model.Category;
import com.trung.nghia.service.ICategoryService;

import java.util.List;

public class CateService implements ICategoryService {
	

	private  ICategoryDAO categorydao ;
	
  public CateService() {
	   categorydao =  new CategoryDAO() ;
	}

 @Override
	public List<Category> findAll() {
		return categorydao.findAll();
	}
   

}
