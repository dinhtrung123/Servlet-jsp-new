package com.trung.nghia.DAO;

import com.trung.nghia.model.NewModel;
import com.trung.nghia.paging.Pageble;

import java.util.List;

public interface INewDAO extends GenericeDAO<NewModel> {

   List<NewModel> findbyCategory(long Category);
   Long save(NewModel newModel) ; 
   NewModel findOne(Long id) ;
   void update(NewModel updateNew);
   void delete(long ids) ;
   List<NewModel> findAll(Pageble pageble) ;
   int getTotalItem() ;

   
   
}
