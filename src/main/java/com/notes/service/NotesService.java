package com.notes.service;

import java.util.List;
import java.util.Optional;

import com.notes.model.Note;
import com.notes.model.User;

/**
 * 
 * @author Tabassum
 *
 */
public interface NotesService {

	String addNote(User user);
	
	List<Note> getAllNotesByUserId(Integer userId);

	Note findByUserIdAndNoteId(Integer userId, Integer noteId);

	String updateNote(Integer userId, Note note);

	String deleteNote(Integer userId, Integer noteId);

	void deleteNotesByUserId(Integer userId);
}