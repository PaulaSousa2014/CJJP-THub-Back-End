/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.PostDAO;
import THUBPROJECT.dto.Comment;
import THUBPROJECT.dto.Post;
import THUBPROJECT.dto.User;
import THUBPROJECT.service.Interfaces.PostServiceInterface;

@Service // Assign Service
public class PostService implements PostServiceInterface{

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

	public List<Post> getPostsByCreator(User creator) {
		return postDAO.findPostsByCreator(creator);
	}
	
	public Long getLikesByPostId(Long id) {
		return postDAO.countLikesByPostId(id);
	}
	
	public Long getCommentCountByPostId(Long id) {
		return postDAO.countCommentsByPostId(id);
	}
	
	public List<Comment> getCommentsByPostId(Long id) {
		return postDAO.findCommentsByPostId(id);
	}
	
}
