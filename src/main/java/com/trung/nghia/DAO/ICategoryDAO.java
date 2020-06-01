package com.trung.nghia.DAO;

import java.util.List;

import com.trung.nghia.model.Category;

public interface ICategoryDAO extends GenericeDAO<Category> {
	   List<Category> findAll() ;
	   Category findOne(Long id);
	   Category findOneByCode(String code);
}
