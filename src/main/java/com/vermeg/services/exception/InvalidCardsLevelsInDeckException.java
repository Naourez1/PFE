package com.vermeg.services.exception;
import com.vermeg.services.exception.ApplicationException;
import org.springframework.http.HttpStatus;
public class InvalidCardsLevelsInDeckException extends ApplicationException{
	 private static final String CODE = "exception.deck.invalidCardsLevels";
	  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

	  public InvalidCardsLevelsInDeckException(String message) {
	    super(message, CODE, STATUS);
	  }

	  public InvalidCardsLevelsInDeckException(String message, Throwable cause) {
	    super(message, CODE, STATUS, cause);
	  }
}
