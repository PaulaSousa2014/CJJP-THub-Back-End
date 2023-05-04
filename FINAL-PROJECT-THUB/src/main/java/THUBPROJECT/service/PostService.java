/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.PostDAO;
import THUBPROJECT.dto.Post;

@Service // Assign Service
public class PostService {

	// Load DAO
	@Autowired
	PostDAO postDAO;

	// CRUD functions
	public List<Post> listPosts() {
		return postDAO.findAll();
	}

	public Post savePost(Post post) {
		return postDAO.save(post);
	}

	public Post postById(Long id) {
		return postDAO.findById(id).get();
	}

	public Post updatePost(Post post) {
		return postDAO.save(post);
	}

	public void deletePost(Long id) {
		postDAO.deleteById(id);
	}

}
