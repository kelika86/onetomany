package com.keiko.onetomany.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.keiko.onetomany.models.Student;
import com.keiko.onetomany.models.Teacher;
import com.keiko.onetomany.repositories.StudentRepo;
import com.keiko.onetomany.repositories.TeacherRepo;

@Service
public class ClassRoomService {
	private final StudentRepo sR;//tells the service you'll be using the repo
	private final TeacherRepo tR; //source-->generate constructor using fields-->select all
	public ClassRoomService(StudentRepo sR, TeacherRepo tR) {
		this.sR = sR;
		this.tR = tR;
	}
	//the above is called dependency injection
	
	public List<Teacher> getAllTeachers() {
		
		
		return tR.findAll();
	}

	public void createStudent(@Valid Student student) {
		// TODO Auto-generated method stub
		sR.save(student);
		
	}

	public List getAllStudents() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}
}
