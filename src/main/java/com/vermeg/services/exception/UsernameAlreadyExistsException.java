package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class UsernameAlreadyExistsException extends ApplicationException{

	  private static final String CODE = "exception.user.usernameExists";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public UsernameAlreadyExistsException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public UsernameAlreadyExistsException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
