package com.trung.nghia.service;

import java.util.List;


import com.trung.nghia.model.Category;
import com.trung.nghia.model.NewModel;
import com.trung.nghia.paging.Pageble;

public interface INewService {
	  List<NewModel>  findByCategory(Long categoryid); 
      NewModel save(NewModel newModel);
      NewModel UpData(NewModel updateNew);
     void Delete(long[] ids ) ;
     List<NewModel> findAll(Pageble pageble) ;
     int getTotalItem() ;
    NewModel findOne(Long id) ;

}
