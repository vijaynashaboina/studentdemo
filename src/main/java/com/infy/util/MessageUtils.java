package com.infy.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class MessageUtils {
	
	public static String getMessages(MessageSource messageSource,String messageCode) {
		return getMessages(messageSource, messageCode,null);
	}
	
	public static String getMessages(MessageSource messageSource,String messageCode,Object[] args) {
		if(messageSource!=null) {
			return messageSource.getMessage(messageCode, args,Locale.getDefault());
		}else {
			return ApplicationConstants.EMPTY;
		}
	}

}
