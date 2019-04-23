package com.vermeg.services.exception;
import org.springframework.http.HttpStatus;
public class ApplicationException extends RuntimeException {

	private final String code;
	  private final HttpStatus httpStatus;

	  public ApplicationException(String message, String code, HttpStatus httpStatus) {
	    super(message);
	    this.code = code;
	    this.httpStatus = httpStatus;
	  }

	  public ApplicationException(String message, String code, HttpStatus httpStatus, Throwable cause) {
	    super(message, cause);
	    this.code = code;
	    this.httpStatus = httpStatus;
	  }

	public String getCode() {
		return code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
