/**
 * 
 */
package com.notes.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Tabassum
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {
		
	@Column(name = "created_date", updatable = false)
	@Temporal(TIMESTAMP)
	protected Date creationDate;
	
	
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	protected Date lastModifiedDate;

}
