package com.notes.service;

import java.util.List;

import com.notes.model.Note;

/**
 * 
 * @author Tabassum
 *
 */
public interface NotesService {

	String addNote(Note note);
	
	List<Note> getAllNotesByUserId(Integer userId);

	Note findByUserIdAndNoteId(Integer userId, Integer noteId);

	String updateNote(Integer userId, Note note);

	String deleteNote(Integer userId, Integer noteId);

	void deleteNotesByUserId(Integer userId);
}