package com.notes.service;

import com.notes.model.Note;

/**
 * 
 * @author Tabassum
 *
 */
public interface NotesService {

	String addNote(Note note, Integer userId);
	
	/*List<Note> getAllNotesByUserId(Integer userId);

	Note findByUserIdAndNoteId(Integer userId, Integer noteId);

	String updateNote(Integer userId, Note note);

	String deleteNote(Integer userId, Integer noteId);

	void deleteNotesByUserId(Integer userId);*/
}