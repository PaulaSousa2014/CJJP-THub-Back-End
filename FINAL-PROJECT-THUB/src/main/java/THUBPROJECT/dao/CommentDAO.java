/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import THUBPROJECT.dto.Comment;

public interface CommentDAO extends JpaRepository<Comment, Long> {
	
	@Query("SELECT c FROM Comment c WHERE c.in_post.id = :postId ORDER BY c.time_submitted DESC")
	List<Comment> findByInPostId(Long postId);

}
