package com.vermeg.services.exception;
import com.vermeg.services.exception.ApplicationException;
import org.springframework.http.HttpStatus;
public class DeckUsedInPlanningsException extends ApplicationException {
	 private static final String CODE = "exception.deck.usedInPlannings";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public DeckUsedInPlanningsException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public DeckUsedInPlanningsException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
