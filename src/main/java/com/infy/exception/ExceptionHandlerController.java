package com.infy.exception;

import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.infy.util.ApplicationConstants;
import com.infy.util.MessageUtils;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@Autowired
	public static MessageSource messageSource;
	
	@Autowired
	public ExceptionHandlerController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	@ExceptionHandler(value=StudentException.class)
	public ResponseEntity<UserErrorResponse> handleStudentExcdeption(StudentException se){
		UserErrorResponse userErrorResponse=getUserResponse(se);
		return new ResponseEntity<>(userErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=StudentValidationException.class)
	public ResponseEntity<UserErrorResponse> handleStudentValidationException(StudentValidationException sve){
		UserErrorResponse userErrorResponse=getUserResponse(sve);
		return new ResponseEntity<>(userErrorResponse,HttpStatus.BAD_REQUEST);
	}

	
	public static UserErrorResponse getUserResponse(StudentException se) {
		UserErrorResponse userErrorResponse=new UserErrorResponse();
		String temp=null;
		temp=MessageUtils.getMessages(messageSource, se.getMessageCode(), se.getArgs());
		if(temp==null) {
			userErrorResponse.setErrorCode(ApplicationConstants.ERROR);
			userErrorResponse.setErrorMessage(ApplicationConstants.SOMETHING_WENT_WRONG);
			return userErrorResponse;
		}
		StringTokenizer str=new StringTokenizer(temp, ApplicationConstants.MESSAGE_DELIMINATOR);
		userErrorResponse.setErrorCode(str.nextToken());
		userErrorResponse.setErrorMessage(str.nextToken());
		return userErrorResponse;
	}
}
