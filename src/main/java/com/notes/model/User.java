/**
 * 
 */
package com.notes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tabassum
 *
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@JsonPropertyOrder({"userMail", "userPass"})
public class User extends Auditable<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	@JsonIgnore
	private Integer userId;

	@NotNull
	@Email
	@Size(max = 100)
	@Column(name = "user_mail", unique = true)
	@JsonProperty("Mail Id")
	private String userMail;

	@NotNull
	@Size(max = 8)
	@Column(name = "user_pass")	
	@JsonProperty("Password")
	private String userPass;	
	
}
