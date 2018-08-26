package com.notes.repository;

import java.util.List;

import com.notes.model.Note;

public interface NotesRepository {

	Note findByUserIdAndNoteId(Integer userId, Integer noteId);

	void addNote(Note note);

	String deleteNote(Integer userId, Integer noteId);

	List<Note> getAllNotesByUserId(Integer userId);

	String updateNote(Integer userId, Note note);

	void deleteNotesByUserId(Integer userId);

	List<Note> getNotesByUserId(Integer userId);
}