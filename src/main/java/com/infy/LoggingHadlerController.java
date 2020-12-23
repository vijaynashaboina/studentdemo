package com.infy;




import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingHadlerController {
	
	private static final Logger logger=LoggerFactory.getLogger(LoggingHadlerController.class);
	@AfterReturning(value="execution(* com.infy.controller.*.*(..))",returning="result")
	public void afterReturing(JoinPoint joinpoint,Object result) {
		ObjectMapper mapper=new ObjectMapper();
		String jsonstr="";
		try {
			if(result!=null) {
				jsonstr=mapper.writeValueAsString(((ResponseEntity)result).getBody());
			}else {
				//jsonstr=mapper.wr
				jsonstr=mapper.writeValueAsString("Response is Empty!...");
			}
		}catch (JsonProcessingException je) {
			logger.error(" ",je);
		}
		logger.debug("Afetr Execution of {}::"+joinpoint.getSignature());
		logger.debug(jsonstr);
	}
	
	@AfterThrowing(value="execution(* com.infy.controller.*.*(..)) ||"
			+ "execution(* com.infy.services.*.*(..)) ||"
			+ "execution(* com.infy.repository.*.*(..))",throwing="error")
	public void afterThrowing(JoinPoint joinpoint,Throwable error) {
		logger.error("Method signature::"+joinpoint.getSignature());
		logger.error("Exception::"+ExceptionUtils.getRootCauseMessage(error),error);
	}
	
	@AfterReturning(value="execution(* com.infy.services.*.*(..))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		ObjectMapper mapper=new ObjectMapper();
		String jsonstr="";
		try {
			jsonstr=mapper.writeValueAsString((Object)result);
		}catch (JsonProcessingException e) {
			logger.error(" ",e);
		}
		logger.debug("Method Signature in services::"+joinPoint.getSignature());
		logger.debug(jsonstr);
	}

	@Before(value="execution(* com.infy.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.debug("Before execution of {} "+joinPoint.getSignature());
	}
	
	@After(value="execution(* com.infy.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.debug("After execution of {} "+joinPoint.getSignature());
	}

}
