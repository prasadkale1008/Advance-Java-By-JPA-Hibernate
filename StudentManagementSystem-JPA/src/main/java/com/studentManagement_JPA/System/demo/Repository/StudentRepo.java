package com.studentManagement_JPA.System.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentManagement_JPA.System.demo.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
