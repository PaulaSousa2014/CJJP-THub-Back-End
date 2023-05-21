package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Post;
import THUBPROJECT.dto.User;

public interface PostServiceInterface {
	
	
	// CRUD functions
	public List<Post> listPosts();
	
	public List<Post> getPostsByCreator(User creator);

	public Post savePost(Post post);

	public Post postById(Long id);

	public Post updatePost(Post post);

	public void deletePost(Long id);

}
