package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class UserNotFoundException extends ApplicationException{
	private static final String CODE = "exception.user.notFound";
	  private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

	  public UserNotFoundException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public UserNotFoundException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
