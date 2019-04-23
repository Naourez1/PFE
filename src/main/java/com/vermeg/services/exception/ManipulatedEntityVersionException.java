package com.vermeg.services.exception;
import com.vermeg.services.exception.ApplicationException;
import org.springframework.http.HttpStatus;
public class ManipulatedEntityVersionException extends ApplicationException{
	private static final String CODE = "exception.optimisticLock.manipulatedVersion";
	  private static final HttpStatus STATUS = HttpStatus.PRECONDITION_FAILED;

	  public ManipulatedEntityVersionException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public ManipulatedEntityVersionException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
