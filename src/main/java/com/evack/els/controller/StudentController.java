//package com.evack.els.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.evack.els.model.Course;
//import com.evack.els.model.Relation;
//import com.evack.els.model.Student;
//import com.evack.els.service.*;
//
//@Controller
//@RequestMapping({"/admin", "/user"})
//public class StudentController {
//	@Autowired
//	CourseService courseService;
//	StudentService stuService;
//	RelationService relationService;
//	
//	Student stu;
//	Course course;
//	List<Student> students;
//	List<Relation> relation;
//	
//	@RequestMapping("/student")
//	public String Student(Model model) {
//		model.addAttribute("students", stuService.studentList());
//		return "student";
//	}
//	@RequestMapping("/student/reportGenerator")
//	public String getStuReport(@RequestParam("stuName") String stuName) {
//		String training = null;
//		stu = stuService.getStudentByName(stuName);
//		Integer stuID = stu.getStuID();
//		String report;
//		if (stuID == 0) {
//			report = "We can't find the student";
//		}
//		else {
//			training = stu.getTraining();
//			relation = relationService.getCourseByStu(stuID);
//			int length = relation.size();
//			int[] courseIDs = new int[length];
//			for (int i = 0; i < length; i++)
//				courseIDs[i] = Integer.parseInt(relation.get(i).toString());
//			String[] courseNames = new String[length];
//			String[] courseShedules = new String[length];
//			for (int i = 0; i < length; i++) {
//				course = courseService.getCourseByID(courseIDs[i]);
//				courseNames[i] = course.getCourseName();
//				courseShedules[i] = course.getCourseTime() + ", " + course.getCourseDay();
//			}
//			report = "StudentName: " + stuName + "    Training:  " + training + "\n" + "Course           \t" + "Shedule\n";
//			for(int i = 0; i < length; i++) {
//				if(i != length - 1)
//					report += courseNames[i] + "\b" + courseShedules[i] + "\n";
//				else
//					report += courseNames[i] + "\b" + courseShedules[i];
//			}
//		}
//		return report;
//	}
//}
