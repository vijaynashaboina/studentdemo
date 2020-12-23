package com.infy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.exception.StudentException;
import com.infy.exception.StudentValidationException;
import com.infy.model.Student;
import com.infy.repository.StudentRepository;
import com.infy.util.ApplicationConstants;

@Service
public class StudentServiceImpl implements StudentService{
	
	public String tableInfo="student";
	@Autowired
	public StudentRepository studentRepository;

	@Override
	public Student getStudentById(String studentId) throws StudentException {
		Student student=studentRepository.findByStudentId(studentId);
		if(student==null) {
			throw new StudentValidationException(ApplicationConstants.RECORD_NOT_FOUND,studentId,tableInfo);
		}else {
			return student;
		}
		
	}

	
	

}
