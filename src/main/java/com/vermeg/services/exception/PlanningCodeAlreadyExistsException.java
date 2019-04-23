package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class PlanningCodeAlreadyExistsException extends ApplicationException {
	  private static final String CODE = "exception.planning.codeExists";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public PlanningCodeAlreadyExistsException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public PlanningCodeAlreadyExistsException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
