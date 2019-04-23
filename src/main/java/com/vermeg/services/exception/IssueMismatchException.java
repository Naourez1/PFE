package com.vermeg.services.exception;
import com.vermeg.services.exception.ApplicationException;
import org.springframework.http.HttpStatus;
public class IssueMismatchException extends ApplicationException {
	

		  private static final String CODE = "exception.issue.mismatch";
		  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

		  public IssueMismatchException(String message) {
		    super(message, CODE, STATUS);
		  }

		  public IssueMismatchException(String message, Throwable cause) {
		    super(message, CODE, STATUS, cause);
		  }
}
