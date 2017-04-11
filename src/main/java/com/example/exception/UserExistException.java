package com.example.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.CONFLICT, reason="User Name already exist")
public class UserExistException  extends RuntimeException{
		public UserExistException(){
			super("User name exist");
		
	} 
}
