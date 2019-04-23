package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class EmailAlreadyExistsException extends ApplicationException {
	 private static final String CODE = "exception.user.emailExists";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public EmailAlreadyExistsException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public EmailAlreadyExistsException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
