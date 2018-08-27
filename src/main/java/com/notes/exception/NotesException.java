package com.notes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * 
 * @author Tabassum
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotesException extends RuntimeException {

	public NotesException(String exception) {
		super(exception);
	}

}
