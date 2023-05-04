/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.Post;
import THUBPROJECT.service.PostService;

@RestController // Rest controller
@RequestMapping("/api")
public class PostController {

	// Implement service
	@Autowired
	PostService postService;

	// Get Mappings
	@GetMapping("/posts")
	public List<Post> listPosts() {
		return postService.listPosts();
	}

	@GetMapping("/posts/{id}")
	public Post postById(@PathVariable(name = "id") Long id) {
		Post postxID = new Post();

		postxID = postService.postById(id);

		return postxID;
	}

	// Post Mappings
	@PostMapping("/posts")
	public Post savePost(@RequestBody Post post) {
		return postService.savePost(post);
	}

	// Put Mappings
	@PutMapping("/posts/{id}")
	public Post updatePost(@PathVariable(name = "id") Long id, @RequestBody Post post) {
		Post selectedPost = new Post(id, post.getTitle(), post.getContent(), post.getCreator());
		Post updatedPost = new Post();

		updatedPost = postService.updatePost(selectedPost);
		return updatedPost;
	}

	// Delete Mappings
	@DeleteMapping("/posts/{id}")
	public void deletePost(@PathVariable(name = "id") Long id) {
		postService.deletePost(id);
	}

}
