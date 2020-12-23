package com.infy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.exception.StudentException;
import com.infy.model.Student;
import com.infy.services.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	@ApiOperation(value="Get Student details by his Id")
	@GetMapping(value="/getbyid",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getById(@RequestParam(value="studentId",required=true)String studentId)throws StudentException{
		Student std=studentService.getStudentById(studentId);
		return new ResponseEntity<Student>(std,HttpStatus.OK);
	}

}
