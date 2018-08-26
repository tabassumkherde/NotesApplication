/**
 * 
 */
package com.notes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * @author Tabassum
 *
 */
@Data
@Entity
@Table(name = "user_details")
public class User extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	private Long userId;

	@NotNull
	@Email
	@Size(max = 100)
	@Column(name = "user_mail", unique = true)
	private String userMail;

	@NotNull
	@Size(max = 8)
	@Column(name = "user_pass")
	private String userPass;	

	/*In case when we need to add Notes, when adding user
	 * @JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Notes> noteDetails;*/
}
