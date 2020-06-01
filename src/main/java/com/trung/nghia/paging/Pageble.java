package com.trung.nghia.paging;

import com.trung.nghia.sort.Sorter;

public interface Pageble {
       Integer Page();
       Integer Offset() ;
       Integer Limit() ;
       Sorter  getSorter(); 
       
}
