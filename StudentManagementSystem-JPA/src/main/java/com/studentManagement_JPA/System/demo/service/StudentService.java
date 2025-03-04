package com.studentManagement_JPA.System.demo.service;

import java.util.List;

import com.studentManagement_JPA.System.demo.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student saveStudent(Student Student);

	Student getStudentById(Long id);

	Student updateStudent(Student Student);

	void deleteStudentById(Long id);

}
