package com.trung.nghia.DAO.impl;

import java.util.List;

import com.trung.nghia.DAO.ICategoryDAO;
import com.trung.nghia.mapper.CateMapper;
import com.trung.nghia.mapper.NewMapper;
import com.trung.nghia.model.Category;
import com.trung.nghia.model.NewModel;

public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {

     @Override
	public List<Category> findAll() {
    	 String sql = "SELECT * FROM category";
		return query(sql, new CateMapper());
	}

	@Override
	public Category findOne(Long id) {
		String sql = "SELECT * FROM category WHERE  id = ?";
		List<Category> categories = query(sql, new CateMapper(), id);
		return categories.isEmpty() ? null : categories.get(0);
	}

	@Override
	public Category findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE  code = ?";
		List<Category> categories = query(sql, new CateMapper(), code);
		return categories.isEmpty() ? null : categories.get(0);
	}


}
