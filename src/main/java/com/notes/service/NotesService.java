package com.notes.service;

import javax.validation.Valid;

import com.notes.model.Note;

/**
 * 
 * @author Tabassum
 * Interface for notes crud operations.
 */
public interface NotesService {

	String addNote(Note note, Integer userId);

	Object getAllNotesByUser(Integer userId);

	String deleteNote(Integer userId, Integer noteId);

	String updateNote(Note note, Integer userId);	
}