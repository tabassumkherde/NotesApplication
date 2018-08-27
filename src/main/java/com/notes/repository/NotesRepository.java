package com.notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.notes.model.Note;

public interface NotesRepository extends CrudRepository<Note, Integer>{

	@Query("select note from Note note where note.userDetails.userId = :userId")
	List<Note> findNotesByUserId(@Param("userId") Integer userId);	
}