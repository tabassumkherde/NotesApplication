/**
 * 
 */
package com.notes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author Tabassum
 *
 */
@Data
@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"creationDate", "lastModifiedDate"}, 
allowGetters = true)
public class User extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	private Integer userId;

	@NotNull
	@Email
	@Size(max = 100)
	@Column(name = "user_mail", unique = true)
	private String userMail;

	@NotNull
	@Size(max = 8)
	@Column(name = "user_pass")
	private String userPass;	

	/*In case when we need to add Note, when adding user*/
	@JsonIgnore
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private List<Note> notes = new ArrayList<>();
	
	public void addNote(Note note) {
		notes.add(note);
		note.setUserDetails(this);
		note.setUserId(this.userId);
    }
 
    public void removeNote(Note note) {
    	notes.remove(note);
    	note.setUserDetails(null);
    	note.setUserId(null);
    }
}
