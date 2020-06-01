package com.trung.nghia.paging;

import com.trung.nghia.sort.Sorter;

public class PageRequest implements Pageble {
	private Integer Page ;
	private Integer maxPageItem ;
	private Sorter sorter ;
	



	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		Page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}

	@Override
	public Integer Page() {
		
		return this.Page;
	}

	@Override
	public Integer Offset() {
		if(this.Page !=null && this.maxPageItem !=null)
		{
			return  (this.Page - 1) *  this.maxPageItem ;
		}
        return null ;

	}

	@Override
	public Integer Limit() {
		
		return this.maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		if(this.sorter !=null)
		{
			return this.sorter ;
		}
		return null;
	}

}
