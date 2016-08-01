package io.egen.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)

public class RatingNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1935540184707558119L;

	public RatingNotFoundException(String message) {
		super(message);
	}

	public RatingNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

