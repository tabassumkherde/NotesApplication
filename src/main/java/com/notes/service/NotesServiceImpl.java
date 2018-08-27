package com.notes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notes.model.Note;
import com.notes.model.User;
import com.notes.repository.NotesRepository;
import com.notes.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author Tabassum
 *
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
		return user.isPresent() ? saveUser(user.get(), note) : " Provide valid user id";

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
}
