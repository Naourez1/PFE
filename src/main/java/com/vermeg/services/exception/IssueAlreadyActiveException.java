package com.vermeg.services.exception;
import com.vermeg.services.exception.ApplicationException;
import org.springframework.http.HttpStatus;
public class IssueAlreadyActiveException extends ApplicationException{
	 private static final String CODE = "exception.issue.alreadyActive";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public IssueAlreadyActiveException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public IssueAlreadyActiveException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
