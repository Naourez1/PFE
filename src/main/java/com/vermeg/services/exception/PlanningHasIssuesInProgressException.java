package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class PlanningHasIssuesInProgressException extends ApplicationException{

	  private static final String CODE = "exception.planning.hasIssuesInProgress";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public PlanningHasIssuesInProgressException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public PlanningHasIssuesInProgressException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
