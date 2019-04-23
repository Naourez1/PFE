package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class PasswordDoesNotSatisfyConditions extends ApplicationException {
	private static final String CODE = "exception.password.doesNotSatisfyConditions";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public PasswordDoesNotSatisfyConditions(String message) {
	    super(message, CODE, STATUS);
	  }

	  public PasswordDoesNotSatisfyConditions(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
