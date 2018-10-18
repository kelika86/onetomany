package com.keiko.onetomany.repositories;//remember it's interface file not class!

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keiko.onetomany.models.Student;


@Repository
public interface StudentRepo extends CrudRepository <Student, Long>{ //Student from model--CrudRepository allows to save to database so need to create a repo
	List<Student> findAll();
}
