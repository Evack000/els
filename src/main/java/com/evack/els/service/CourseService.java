package com.evack.els.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evack.els.mapper.CourseMapper;
import com.evack.els.model.Course;

@Service
public class CourseService {
	@Autowired
	CourseMapper courseMapper;
	
	public List<Course> courseList(){
		return courseMapper.getAllCourse();
	}
	
	public int insertCourse(Course course) {
		return courseMapper.insertCourse(course);
	}
	
	public int delCourse(Integer courseID) {
		return courseMapper.delCourseByID(courseID);
	}
	
	public int updateCourse(Course course) {
		return courseMapper.updateCourse(course);
	}
	
	public Course getCourseByName(String courseName) {
		return courseMapper.getCourseByName(courseName);
	}
	
	public Course getCourseByID(Integer courseID) {
		return courseMapper.getCourseByID(courseID);
	}
}
