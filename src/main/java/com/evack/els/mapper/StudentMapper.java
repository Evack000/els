package com.evack.els.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.evack.els.model.Student;

@Mapper
public interface StudentMapper {
	@Select("select * from student")
	public List<Student> getAllStudent();
	
	@Select("select * from student where stuName=#{stuName}")
	public Student getStudentByName(String stuName);
}
