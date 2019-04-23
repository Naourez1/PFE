package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class RoleNotFoundException extends ApplicationException{
	 private static final String CODE = "exception.role.notFound";
	  private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

	  public RoleNotFoundException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public RoleNotFoundException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
