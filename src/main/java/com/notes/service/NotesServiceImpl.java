package com.notes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notes.model.Note;
import com.notes.model.User;
import com.notes.repository.NotesRepository;
import com.notes.repository.UserRepository;
import com.notes.util.ApplicationConstants;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author Tabassum Service Implementation class for note crud operations.
 */
@Service
@Log4j2
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository noteRepository;

	@Autowired
	private UserRepository userRepository;

	/**
	 * Adding note by validating user id
	 * 
	 * @param note
	 * @param userId
	 * @return
	 */
	@Override
	public String addNote(Note note, Integer userId) {
		log.info("Inside add note service");
		Optional<User> user = userRepository.findById(userId);
		return user.isPresent() ? saveUser(user.get(), note) : ApplicationConstants.VALIDATION_USER_ID;

	}

	/**
	 * Get all notes associated by user id. check for valid user.
	 * 
	 * @param userId
	 * @return object
	 */
	@Override
	public Object getAllNotesByUser(Integer userId) {
		log.info("Inside get all notes by user id service");
		Optional<User> user = userRepository.findById(userId);
		return user.isPresent() ? noteRepository.findNotesByUserId(userId) : ApplicationConstants.VALIDATION_USER_ID;
	}

	/**
	 * Delete Note by verfying valid/correct user
	 * 
	 * @param userId
	 * @param noteId
	 * @return String
	 */
	@Override
	public String deleteNote(Integer userId, Integer noteId) {
		Optional<User> user = userRepository.findById(userId);
		return user.isPresent() ? deleteNote(noteId) : ApplicationConstants.VALIDATION_USER_ID;

	}
	
	/**
	 * To delete note by user id
	 */
	@Override
	public String updateNote(Note note, Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(note.getNoteId() == null){
			return ApplicationConstants.VALIDATION_NOTE_ID;
		}
		Optional<Note> dbNote = noteRepository.findById(note.getNoteId());
		return user.isPresent() && dbNote.isPresent() ? updateNote(user.get(), note) : ApplicationConstants.VALIDATION_UPDATE_NOTE_DATA;
		
	}
	
	/**
	 * Method to update Note
	 * 
	 * @param user
	 * @param note
	 * @return
	 */
	private String updateNote(User user, Note note) {
		note.setUserDetails(user);
		noteRepository.save(note);
		log.info("Successfully updated new Note.");
		return "Successfully updated new Note.";
	}

	/**
	 * Method to save Note
	 * 
	 * @param user
	 * @param note
	 * @return
	 */
	private String saveUser(User user, Note note) {
		note.setUserDetails(user);
		noteRepository.save(note);
		log.info("Successfully added new Note.");
		return "Successfully added new Note.";
	}

	/**
	 * Delete Note
	 * 
	 * @param noteId
	 * @return
	 */
	private String deleteNote(Integer noteId) {
		noteRepository.deleteById(noteId);
		return "Deleted note with noteId: " + noteId;
	}
	
}
