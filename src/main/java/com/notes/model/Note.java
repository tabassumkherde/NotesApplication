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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Tabassum
 *
 */

@Data
@NoArgsConstructor
@Entity
@Table(name="Notes")
@JsonPropertyOrder({"title", "noteMsg"})
@JsonIgnoreProperties(value = {"noteId"}, allowGetters = true)
public class Note extends Auditable<String> implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="note_Id")
	@JsonIgnore
	private Integer noteId;
	
	@NotEmpty(message = "Provide title") @NotBlank(message = "Provide title")
	@Size(max = 15)
	@JsonProperty("Note Title")
	@Column(name="title")

	private String title;
	
	@Size(max = 1000)
	@Column(name="note_msg")
	@JsonProperty("Note Message")
	private String noteMsg;	
	
	
	/*In case of we need to maintain many notes to one User relation through User Entity*/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userDetails;
}
