package com.evack.els.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.evack.els.model.*;
import com.evack.els.service.CourseService;
import com.evack.els.service.RelationService;
import com.evack.els.service.StudentService;
import com.evack.els.service.Implement.ImpleLoginService;

@Controller
public class MainController {

    @Autowired
    ImpleLoginService impleLoginService;
    @Autowired
    CourseService courseService;
    @Autowired
	StudentService stuService;
    @Autowired
	RelationService relationService;
    User user;
    Integer userlevel = 0;
	Student stu;
	Course course;
	List<Student> students;
	List<Relation> relation;
	List<Integer> lCourseIDs;
    @RequestMapping("/login")
    public ModelAndView login(){
    	ModelAndView login = new ModelAndView("login");
    	return login;
    }

    @RequestMapping(value="/loginResult",method=RequestMethod.POST)
//  @ResponseBody
    public String loginResult(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        user=impleLoginService.loginResult(username,password);
        userlevel = user.getUserLevel();
        if(!password.equals(user.getPassword()))
            return "redirect:/loginerror";
        else if(userlevel == 0)
            return "redirect:/admin";
        else
        	return "redirect:/user";
    }
    
    @RequestMapping("/loginerror")
    public String loginError() {
    	return "loginerror";
    }
    
    @RequestMapping("/admin")
    public String Admin() {
    	return "admin";
    }
    
    @RequestMapping("/user")
    public String User() {
    	return "user";
    }
    
	@RequestMapping("/course")
	public String Course(Model model) {
		model.addAttribute("courses", courseService.courseList());
		return "course";
	}
	
	@RequestMapping("/delete")
	public String courseDelete(Integer courseID) {
		courseService.delCourse(courseID);
		return "redirect:/course";
	}
	
	@RequestMapping("/addcourse")
	public String addCourse(ModelMap map) {
		map.addAttribute("course", new Course());
		return "addcourse";
	}
	
	@RequestMapping("/updatecourse")
	public String updateCourse(ModelMap map) {
		map.addAttribute("course", new Course());
		return "updatecourse";
	}
	
	@RequestMapping("/saveadd")
	public String saveAdd(@ModelAttribute Course course) {
		courseService.insertCourse(course);
		return "redirect:/course";
	}
	
	@RequestMapping("/saveupdate")
	public String saveUpdate(@ModelAttribute Course course) {
		courseService.updateCourse(course);
		return "redirect:/course";
	}
    
	@RequestMapping("/student")
	public String Student(Model model) {
		model.addAttribute("students", stuService.studentList());
		return "student";
	}
	
	@RequestMapping(value="/reportGenerator",method=RequestMethod.POST)
	public String reportGenerator(HttpServletRequest request, Model model) {
		String stuName = request.getParameter("stuName");
		String training = null;
		stu = stuService.getStudentByName(stuName);
		Integer stuID = 0;
		stuID = stu.getStuID();
		String report;
		if (stuID == null || stuID == 0) {
			report = "We can't find the student";
		}
		else {
			training = stu.getTraining();
			lCourseIDs = relationService.getCourseByStu(stuID);
			int length = lCourseIDs.size();
			int slength = 0;
			Integer[] courseIDs = new Integer[length];
			lCourseIDs.toArray(courseIDs);
			String[] courseNames = new String[length];
			String[] courseShedules = new String[length];
			for (int i = 0; i < length; i++) {
				course = courseService.getCourseByID(courseIDs[i]);
				courseNames[i] = course.getCourseName();
				courseShedules[i] = course.getCourseTime() + ", " + course.getCourseDay();
				slength = courseNames[i].length();
				if(slength < 30) {
					for(int j = 0;  j < 2 * (30 - slength); j++) {
						courseNames[i] += " ";
					}
				}
			}
			
			report = "StudentName: " + stuName + ",    Training:  " + training + "\n\n" + "Course                                            " + "Shedule\n";
			for(int i = 0; i < length; i++) {
				if(i != length - 1)
					report += courseNames[i] + courseShedules[i] + "\n";
				else
					report += courseNames[i] + courseShedules[i];
			}
		}
		model.addAttribute("report", report);
		return ("reportGenerator");
//		return report;
	}
}
