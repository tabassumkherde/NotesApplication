/**
 * 
 */
package com.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notes.model.User;

/**
 * @author Tabassum
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}