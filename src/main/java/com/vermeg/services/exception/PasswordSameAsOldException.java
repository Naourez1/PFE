package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class PasswordSameAsOldException extends ApplicationException{
	private static final String CODE = "exception.password.sameAsOld";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public PasswordSameAsOldException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public PasswordSameAsOldException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
