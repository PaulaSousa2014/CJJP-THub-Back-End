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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.Like;
import THUBPROJECT.service.LikeService;
import THUBPROJECT.service.PostService;
import THUBPROJECT.service.UserService;

@RestController // Rest controller
@RequestMapping("/api")
public class LikeController {

	// Implement service
	@Autowired
	LikeService likeService;
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;

	// Get Mappings
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/likes")
	public List<Like> listLikes() {
		return likeService.listLikes();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/likes/{id}")
	public Like likeById(@PathVariable(name = "id") Long id) {
		Like likexID = new Like();

		likexID = likeService.likeById(id);

		return likexID;
	}

	// Post Mappings
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/likes")
	public Like saveLike(@RequestBody Like like) {
		return likeService.saveLike(like);
	}

	// Post Mappings add like by post_id & user_id
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/likes/{post_id}/{user_id}")
	public Like newLike(@PathVariable(name = "post_id") Long post_id, @PathVariable(name = "user_id") Long user_id) {

		Like likes = new Like();
		likes.setUser_liked(userService.userById(user_id));
		likes.setPost_liked(postService.postById(post_id));

		return likeService.updateLike(likes);

	}

	// Delete Mappings
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/likes/{id}")
	public void deleteLike(@PathVariable(name = "id") Long id) {
		likeService.deleteLike(id);
	}

}
