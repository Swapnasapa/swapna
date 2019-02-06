package com.training.bean;


public class CategoryBean {
    private String catecode;
	private String catename;
	private String coursetitle;
	private String coursecode;
	
	public CategoryBean(){}
	
	 	
	public CategoryBean(String catecode, String catename, String coursetitle, String coursecode) {
	
		super();
	    this.catecode = catecode;
		this.catename = catename;
		this.coursetitle = coursetitle;
		this.coursecode = coursecode;
	}
	
	public String getCatecode() {
		return catecode;
	}


	public void setCatecode(String catecode) {
		this.catecode = catecode;
	}


	public String getCatename() {
		return catename;
	}


	public void setCatename(String catename) {
		this.catename = catename;
	}


	public String getCoursetitle() {
		return coursetitle;
	}


	public void setCoursetitle(String coursetitle) {
		this.coursetitle = coursetitle;
	}


	public String getCoursecode() {
		return coursecode;
	}


	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
  
}
