package com.evack.els.model;

import org.springframework.stereotype.Component;

@Component
public class Course {
	private Integer courseID;
	private String courseName;
	private String courseDescription;
	private String duration;
	private String courseTime;
	private String courseDay;
	
	public Integer getCourseID() {
		return courseID;
	}
	
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseDescription() {
		return courseDescription;
	}
	
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getCourseTime() {
		return courseTime;
	}
	
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	
	public String getCourseDay() {
		return courseDay;
	}
	
	public void setCourseDay(String courseDay) {
		this.courseDay = courseDay;
	}
}
