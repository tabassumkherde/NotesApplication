package com.notes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Tabassum
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Notes")
@JsonIgnoreProperties(value = {"creationDate", "lastModifiedDate"}, 
allowGetters = true)
public class Note extends Auditable<String> implements Serializable {
	
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
	
	/*@Column(name="user_id")
	private Integer userId;
	*/
	/*In case of we need to maintain many notes to one User relation through User Entity*/
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userDetails;
}
