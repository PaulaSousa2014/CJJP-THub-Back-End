/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import THUBPROJECT.dto.Post;
import THUBPROJECT.dto.User;

public interface PostDAO extends JpaRepository<Post, Long> {
	
	List<Post> findPostsByCreator(User creator);

}
