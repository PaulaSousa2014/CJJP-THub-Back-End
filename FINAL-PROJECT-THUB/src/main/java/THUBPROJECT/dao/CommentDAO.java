/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Comment;

public interface CommentDAO extends JpaRepository<Comment, Long> {

}
