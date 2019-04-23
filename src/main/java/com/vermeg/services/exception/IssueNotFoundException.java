package com.vermeg.services.exception;
import com.vermeg.services.exception.ApplicationException;
import org.springframework.http.HttpStatus;
public class IssueNotFoundException extends ApplicationException  {
	private static final String CODE = "exception.issue.notFound";
	  private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

	  public IssueNotFoundException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public IssueNotFoundException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
