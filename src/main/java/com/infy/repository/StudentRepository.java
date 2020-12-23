package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	public Student findByStudentId(String studentId);
}
