package com.notes.service;

import java.util.List;

import com.notes.model.Note;

/**
 * 
 * @author Tabassum
 *
 */
public interface NotesService {

	String addNote(Note note, Integer userId);

	Object getAllNotesByUser(Integer userId);	
}