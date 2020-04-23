package com.evack.els.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;


import com.evack.els.model.Course;

@Mapper
public interface CourseMapper {
	
	@Results({
		@Result(property = "courseID", column = "courseID"),
		@Result(property = "courseName", column = "courseName")
	})
	@Select("select * from course")
	public List<Course> getAllCourse();
	
	@Select("select * from course where courseName=#{courseName}")
	public Course getCourseByName(String courseName);
	
	@Select("select * from course where courseID=#{courseID}")
	public Course getCourseByID(Integer courseID);
	
	@Delete("delete from course where courseID=#{courseID}")
	public int delCourseByID(Integer courseID);
	
	@Update("update course set courseName=#{courseName},courseDescription=#{courseDescription},duration=#{duration},courseTime=#{courseTime},courseDay=#{courseDay} where courseName=#{courseName}")
	public int updateCourse(Course course);
	
	@Options(useGeneratedKeys = true,keyProperty = "courseID")
	@Insert("insert into course(courseName,courseDescription,duration,courseTime,courseDay) value (#{courseName},#{courseDescription},#{duration},#{courseTime},#{courseDay})")
	public int insertCourse(Course course);
}
