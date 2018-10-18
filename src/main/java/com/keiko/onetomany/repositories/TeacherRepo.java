package com.keiko.onetomany.repositories; //remember it's an interface file not class!

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keiko.onetomany.models.Teacher;

@Repository
public interface TeacherRepo extends CrudRepository <Teacher, Long> { //Teacher from models
	List<Teacher> findAll();
}
