package com.trung.nghia.service.imp;

import java.sql.Timestamp;
import java.util.List;

import com.trung.nghia.DAO.ICategoryDAO;
import com.trung.nghia.DAO.INewDAO;
import com.trung.nghia.DAO.impl.CategoryDAO;
import com.trung.nghia.DAO.impl.NewDAO;
import com.trung.nghia.model.Category;
import com.trung.nghia.model.NewModel;
import com.trung.nghia.paging.Pageble;
import com.trung.nghia.service.INewService;

import javax.inject.Inject;

public  class NewService implements INewService{

	private INewDAO Inew ;

	private ICategoryDAO iCategoryDAO ;

	public NewService() {
	 Inew  =  new  NewDAO();
	 iCategoryDAO=  new CategoryDAO();
	}

	@Override
	public List<NewModel> findByCategory(Long categoryid) {
		
	 return Inew.findbyCategory(categoryid) ;
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		 Category category =  iCategoryDAO.findOneByCode(newModel.getCategoryCode());
		 newModel.setCategoryid(category.getId());
		Long newid =  Inew.save(newModel);
		return Inew.findOne(newid);
	}

	@Override
	public NewModel UpData(NewModel updateNew) {
        NewModel newModel =  Inew.findOne(updateNew.getId());
        updateNew.setCreatedDate(newModel.getCreatedDate());
        updateNew.setCreatedBy(newModel.getCreatedBy());
        updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        Category category = iCategoryDAO.findOneByCode(updateNew.getCategoryCode());
        updateNew.setCategoryid(category.getId());
        Inew.update(updateNew);
		return Inew.findOne(updateNew.getId());
	}

	@Override
	public void Delete(long[] ids) {
		for (long id : ids) {
			Inew.delete(id);
		}
		
	}

	

	@Override
	public int getTotalItem() {

		return Inew.getTotalItem();
	}

	@Override
	public NewModel findOne(Long id) {
		NewModel newModel =  Inew.findOne(id);
		Category category =  iCategoryDAO.findOne(newModel.getCategoryid());
		newModel.setCategoryCode(category.getCode());
		return newModel;
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {

		return Inew.findAll(pageble);
	}

	


}
