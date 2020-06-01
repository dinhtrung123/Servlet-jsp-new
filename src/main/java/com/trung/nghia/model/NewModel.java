package com.trung.nghia.model;

public class NewModel extends AbstractModel<NewModel>{
	private String title ;
	private String thumbnail ;
	private String  shortdese ;
	private String content ;
	private Long  categoryid ;
	private  String categoryCode ;
	private  String type ;

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortdese() {
		return shortdese;
	}
	public void setShortdese(String shortdese) {
		this.shortdese = shortdese;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	
   
	
}
