package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
import com.vermeg.services.exception.ApplicationException;
public class SystemFeatureNotFoundException extends ApplicationException {
	 private static final String CODE = "exception.systemFeature.notFound";
	  private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

	  public SystemFeatureNotFoundException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public SystemFeatureNotFoundException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
