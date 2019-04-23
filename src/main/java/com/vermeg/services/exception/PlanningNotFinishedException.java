package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class PlanningNotFinishedException  extends ApplicationException{
	private static final String CODE = "exception.planning.notFinished";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public PlanningNotFinishedException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public PlanningNotFinishedException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
