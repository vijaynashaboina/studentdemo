package com.infy.services;

import java.util.Optional;

import com.infy.exception.StudentException;
import com.infy.model.Student;

public interface StudentService {

	public Student getStudentById(String studentId) throws StudentException;
}
