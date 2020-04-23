package com.evack.els.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evack.els.mapper.StudentMapper;
import com.evack.els.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentMapper studentMapper;
	
	public List<Student> studentList(){
		return studentMapper.getAllStudent();
	}
	
	public Student getStudentByName(String stuName) {
		return studentMapper.getStudentByName(stuName);
	}
}
