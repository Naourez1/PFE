package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class OldPasswordNotValidException extends ApplicationException {
	 private static final String CODE = "exception.password.oldNotValid";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public OldPasswordNotValidException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public OldPasswordNotValidException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
