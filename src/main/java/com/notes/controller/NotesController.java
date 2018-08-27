/**
 * 
 */
package com.notes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notes.exception.NotesException;
import com.notes.exception.NotesExceptionHandler;
import com.notes.model.Note;
import com.notes.service.NotesServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

/**
 * @author Tabassum
 *
 */

@RestController
@RequestMapping("/notes")
@Api("Notes Crud App")
@Log4j2
public class NotesController extends NotesExceptionHandler {

	@Autowired
	private NotesServiceImpl notesService;

	/**
	 * Method to add note Validate Note Request object format/values in case of
	 * null/empty
	 * 
	 * @param user
	 * @param errors
	 * @return ResponseEntity
	 */
	@ApiOperation(value = "Add New Note")
	@PostMapping("/add/{userId}/note")
	public ResponseEntity<String> addNote(@PathVariable(value = "userId") Integer userId, @Valid @RequestBody Note note,
			Errors errors) {
		log.info("Inside Add Note");
		if (userId == null)
			throw new NotesException("Provide user Id");
		validateRequest(errors);
		String response = notesService.addNote(note, userId);
		log.info("Response : " + response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Method to get all Notes details
	 * 
	 * @return ResponseEntity
	 */
	@ApiOperation(value = "View list of Notes by User Id")
	@GetMapping("/{userId}")
	public ResponseEntity<Object> getAllNotesByUser(@PathVariable(value = "userId") Integer userId) {
		if (userId == null)
			throw new NotesException("Provide user Id");

		return new ResponseEntity<>(notesService.getAllNotesByUser(userId), HttpStatus.OK);
	}

	/**
	 * Validate Request
	 * 
	 * @param errors
	 */
	private void validateRequest(Errors errors) {
		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(errorMsg -> {
				log.debug("Error Message : " + errorMsg);
				throw new NotesException(errorMsg.getDefaultMessage());
			});
		}
	}
}
