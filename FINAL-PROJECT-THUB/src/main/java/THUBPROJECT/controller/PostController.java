/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.Post;
import THUBPROJECT.dto.User;
import THUBPROJECT.service.PostService;

@RestController // Rest controller
@RequestMapping("/api")
public class PostController {

	// Implement service
	@Autowired
	PostService postService;

	// Get Mappings
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/posts")
	public List<Post> listPosts() {
		return postService.listPosts();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/posts/{id}")
	public Post postById(@PathVariable(name = "id") Long id) {
		Post postxID = new Post();

		postxID = postService.postById(id);

		return postxID;
	}
	
	// Get like count by post id
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/posts/{id}/likes/ammount")
	public Long getLikeAmmountByPost(@PathVariable(name = "id") Post id) {
		return postService.getLikesByPost(id);
	}
	
	//Get all post by Creator
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/posts/creator/{id}")
	public List<Post> findPostsByCreator(@PathVariable(name = "id") User id)  {
		return postService.findPostsByCreator(id);
	}

	// Post Mappings
	@PostMapping("/posts")
	@PreAuthorize("hasRole('USER')")
	public Post savePost(@RequestBody Post post) {
		return postService.savePost(post);
	}

	// Put Mappings
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/posts/{id}")
	public Post updatePost(@PathVariable(name = "id") Long id, @RequestBody Post post) {
		Post selectedPost = new Post(id, post.getTitle(), post.getContent(), post.getCreator());
		Post updatedPost = new Post();

		updatedPost = postService.updatePost(selectedPost);
		return updatedPost;
	}

	// Delete Mappings
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/posts/{id}")
	public void deletePost(@PathVariable(name = "id") Long id) {
		postService.deletePost(id);
	}

}
