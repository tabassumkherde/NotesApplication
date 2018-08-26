/**
 * 
 */
package com.notes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.notes.model.Note;
import com.notes.model.User;

/**
 * @author Tabassum Repository/dao class for Notes operations
 */
@Transactional
@Repository
public class NotesRepositoryImpl implements NotesRepository {
//extends JpaRepository<Note, Integer> {

	// Optional<Note> findByUserIdAndNoteId(Integer userId, Integer noteId);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Method to get all notes for selected user id
	 * 
	 * @return List<Note>
	 */
	@Override
	public List<Note> getAllNotesByUserId(Integer userId) {
		String hql = "FROM Notes WHERE user_id=? ORDER BY note_Id";
		return (List<Note>) entityManager.createQuery(hql).setParameter(1, userId).getResultList();
	}

	/**
	 * Method to get Note by user ID and note id.
	 * 
	 * @return Note
	 */
	@Override
	public Note findByUserIdAndNoteId(Integer userId, Integer noteId) {
		String hql = "FROM Notes WHERE user_id=? AND note_Id=? ";
		return (Note) entityManager.createQuery(hql).setParameter(1, userId).setParameter(2, noteId).getResultList();
	}

	/**
	 * Add note, if user is valid for that note.
	 * 
	 * @return String
	 */
	@Override
	public void addNote(Note note) {
		entityManager.persist(note);
	}

	/**
	 * Update Note for note id & by verifying correct user id.
	 * 
	 * @return String
	 */
	@Override
	public String updateNote(Integer userId, Note note) {
		Note dbNote = findByUserIdAndNoteId(userId, note.getNoteId());
		return (dbNote != null) ? setNote(note, dbNote) : "Please provide correct user id and note id.";
	}

	/**
	 * Delete Note by verifying user id.
	 * 
	 * @return String
	 */
	@Override
	public String deleteNote(Integer userId, Integer noteId) {
		Note dbNote = findByUserIdAndNoteId(userId, noteId);
		return (dbNote != null) ? removeNote(noteId, dbNote) : "Please provide correct user id and note id.";
	}
	
	@Override
	public void deleteNotesByUserId(Integer userId) {
		User user = entityManager.find(User.class, userId);
		user.getNotes().remove(0);			
	}
	
	@Override
	public List<Note> getNotesByUserId(Integer userId) {
		User user = entityManager.find(User.class, userId);
		return (List<Note>) user.getNotes();			
	}

	/**
	 * Set Note object
	 * 
	 * @param note
	 * @param dbNote
	 * @return String
	 */
	private String setNote(Note note, Note dbNote) {
		dbNote.setNoteMsg(note.getNoteMsg());
		dbNote.setTitle(note.getTitle());
		entityManager.flush();
		return "Updated record for note id : " + note.getNoteId() + ".";
	}

	/**
	 * remove Note.
	 * 
	 * @param noteId
	 * @param dbNote
	 * @return String
	 */
	private String removeNote(Integer noteId, Note dbNote) {
		entityManager.remove(dbNote);
		return "Deleted note id : " + noteId + "successfully.";
	}
}
