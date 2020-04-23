//package com.evack.els.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.evack.els.model.Course;
//import com.evack.els.service.CourseService;
//
//@Controller
//public class CourseController {
//	@Autowired
//	CourseService courseService;
//	
//	Course course;
//	List<Course> courses;
//	
//	@RequestMapping("/admin/course")
//	public String Course(Model model) {
//		model.addAttribute("courses", courseService.courseList());
//		return "admin/course";
//	}
//	
//	@RequestMapping("/admin/course/delete")
//	public String courseDelete(String courseName) {
//		courseService.delCourse(courseName);
//		return "redirect:admin/course";
//	}
//	
//	@RequestMapping("/admin/course/addcourse")
//	public String addCourse(ModelMap map) {
//		map.addAttribute("course", new Course());
//		return "admin/course/addcourse";
//	}
//	
//	@RequestMapping("/admin/course/updatecourse")
//	public String updateCourse(ModelMap map) {
//		map.addAttribute("course", new Course());
//		return "admin/course/updatecourse";
//	}
//	
//	@RequestMapping("/admin/course/saveadd")
//	public String saveAdd(@ModelAttribute Course course) {
//		courseService.insertCourse(course);
//		return "redirect:admin/course";
//	}
//	
//	@RequestMapping("/admin/course/saveupdate")
//	public String saveUpdate(@ModelAttribute Course course) {
//		courseService.updateCourse(course);
//		return "redirect:admin/course";
//	}
//}
