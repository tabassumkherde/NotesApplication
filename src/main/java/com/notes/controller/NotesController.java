/**
 * 
 */
package com.notes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notes.exception.NotesExceptionHandler;
import com.notes.model.Note;
import com.notes.service.NotesService;

/**
 * @author Tabassum
 *
 */

@RestController
@RequestMapping("/notes")
public class NotesController extends NotesExceptionHandler {

	@Autowired
	private NotesService notesService;

	/**
	 * Method to add note Validate Note Request object format/values in case of
	 * null/empty
	 * 
	 * @param user
	 * @param errors
	 * @return ResponseEntity
	 */
	@PostMapping("add")
	public ResponseEntity<String> addNote(@Valid @RequestBody Note note, Errors errors) {
		String response = notesService.addNote(note);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
