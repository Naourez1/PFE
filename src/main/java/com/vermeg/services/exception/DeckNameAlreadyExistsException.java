package com.vermeg.services.exception;
import com.vermeg.services.exception.ApplicationException;
import org.springframework.http.HttpStatus;
public class DeckNameAlreadyExistsException extends ApplicationException{
	private static final String CODE = "exception.deck.nameExists";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public DeckNameAlreadyExistsException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public DeckNameAlreadyExistsException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
