package com.evack.els.model;

import org.springframework.stereotype.Component;

@Component
public class Relation {
	private Integer stuID;
	private Integer courseID;
	
	public Integer getStuID() {
		return stuID;
	}
	
	public void setStuID(Integer stuID) {
		this.stuID = stuID;
	}
	
	public Integer getCourseID() {
		return courseID;
	}
	
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
}
