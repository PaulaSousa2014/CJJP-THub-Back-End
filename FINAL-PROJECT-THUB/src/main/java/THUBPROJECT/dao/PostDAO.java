/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import THUBPROJECT.dto.Comment;
import THUBPROJECT.dto.Post;
import THUBPROJECT.dto.User;

public interface PostDAO extends JpaRepository<Post, Long> {
	
	List<Post> findPostsByCreator(User creator);
	
	@Query("SELECT COUNT(l) FROM Like l WHERE l.post_liked = :post")
    Long countLikesByPost(@Param("post") Post post);
	
	@Query("SELECT COUNT(c) FROM Comment c WHERE c.in_post = :post")
	Long countCommentsByPost(@Param("post") Post post);
	
	List<Comment> findCommentsByComments(Long postId);

}
