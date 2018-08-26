package com.notes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
/**
 * 
 * @author Tabassum
 *
 */
@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name="Notes")
public class Notes extends Auditable<String> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="note_Id")
	private Integer noteId;
	
	@NotNull
	@Size(max = 15)
	@Column(name="title")
	private String title;
	
	@Size(max = 1000)
	@Column(name="note_msg")
	private String noteMsg;	
	
	@Column(name="user_id")
	private Integer userId;
	
	/*In case of we need to maintain many notes to one User relation through User Entity
	 * @ManyToOne
	@JoinColumn(name="user_id")
	private User userDetails;*/
}
