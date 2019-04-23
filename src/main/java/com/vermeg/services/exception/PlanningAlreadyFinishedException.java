package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class PlanningAlreadyFinishedException extends ApplicationException {
	private static final String CODE = "exception.planning.alreadyFinished";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public PlanningAlreadyFinishedException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public PlanningAlreadyFinishedException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
