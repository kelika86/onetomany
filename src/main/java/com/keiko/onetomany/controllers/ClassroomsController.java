package com.keiko.onetomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keiko.onetomany.models.Student;
import com.keiko.onetomany.models.Teacher;
import com.keiko.onetomany.services.ClassRoomService;

@Controller
public class ClassroomsController {
	private final ClassRoomService cS;//inject Service and then Source-->Generate Constructor using Fields

	public ClassroomsController(ClassRoomService cS) {
		this.cS = cS;
	}
	
	@RequestMapping("/students")
	public String index(Model model) {
		model.addAttribute("students", cS.getAllStudents());
		return "/students/index.jsp";
	} 
	
	//used workbench and use a thunder belt to execute the data into db
	
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute ("student") Student student, Model model) { //"student" name of jsp and Student is type of object--get all the teachers bc form is a teacher
		List<Teacher> teachers=cS.getAllTeachers(); //the red swiggly line says you don't have a method for getAllTeachers--hover over it and click create a method for me
		model.addAttribute("teachers", teachers);
		
		return "/students/new.jsp";
	}
	
	@PostMapping("/students") //from new.jsp
	public String create(@Valid @ModelAttribute("student") Student student, BindingResult result) {//catch the object from the form (modelAttribute="student" from form in new.jsp
		//System.out.println(student.getFirstName());
		//System.out.println(student.getLastName());
		//System.out.println(student.getAge());
		//System.out.println(student.getTeacher());
		if(result.hasErrors()) {
			return "/students/new.jsp";
		}else {
			cS.createStudent(student); //student from above and hover over createStudent since it's red line to create method for you
			return "redirect:/students";
		}
	}
}


