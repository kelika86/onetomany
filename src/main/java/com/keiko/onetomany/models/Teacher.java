package com.keiko.onetomany.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

//always use javax when importing

@Entity
@Table(name="teachers")
public class Teacher { //model name is singular and controllers are plural and added the other stuff in there like ID (copy/paste)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //added
	private String firstName; //keep in mind for validations: size etc. 
	private String lastName;
	private String subject;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="teacher", fetch = FetchType.LAZY) //eacch student will tell me who the teacher is and "teacher" is the attribute on the other model
    private List<Student> students; //Source-->Getters/Setters-->SelectAll-->(After 'setSubject(String)'
	
	public Teacher() { //create empty constructor
		
	}
	
	public Teacher(String firstName, String lastName, String subject) {//create another constructor: Source-->Generate Constructor Using Fields-->Select All-->"After 'Teacher' " and delete super()
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
	}

	//Source-->Generate Getters/Setters-->Select All after "private String subject";
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
