package com.vermeg.services.exception;
import com.vermeg.services.exception.ApplicationException;
import org.springframework.http.HttpStatus;
public class IssueIterationIsNotCurrentlyActiveException extends ApplicationException{
	 private static final String CODE = "exception.issue.iterationIsNotCurrentlyActive";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public IssueIterationIsNotCurrentlyActiveException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public IssueIterationIsNotCurrentlyActiveException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
