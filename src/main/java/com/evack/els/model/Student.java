package com.evack.els.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private Integer stuID;
	private String stuName;
	private String training;
	
	public Integer getStuID() {
		return stuID;
	}
	
	public void setStuID(Integer stuID) {
		this.stuID = stuID;
	}
	
	public String getStuName() {
		return stuName;
	}
	
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public String getTraining() {
		return training;
	}
	
	public void setTraining(String training) {
		this.training = training;
	}
}
