package com.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notes.model.Note;

public interface NotesRepository extends JpaRepository<Note, Integer>{
	
}