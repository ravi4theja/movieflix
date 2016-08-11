package io.egen.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)

public class CommentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 810315090296523654L;

	public CommentNotFoundException(String message) {
		super(message);
	}

	public CommentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
