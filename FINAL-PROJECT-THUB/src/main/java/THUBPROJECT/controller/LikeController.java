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

import THUBPROJECT.dto.Like;
import THUBPROJECT.service.LikeService;

@RestController // Rest controller
@RequestMapping("/api")
public class LikeController {

	// Implement service
	@Autowired
	LikeService likeService;

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

	// Put Mappings
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/likes/{id}")
	public Like updateLike(@PathVariable(name = "id") Long id, @RequestBody Like like) {
		Like selectedLike = new Like(id, like.getUser_liked(), like.getPost_liked());
		Like updatedLike = new Like();

		updatedLike = likeService.updateLike(selectedLike);
		return updatedLike;
	}

	// Delete Mappings
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/likes/{id}")
	public void deleteLike(@PathVariable(name = "id") Long id) {
		likeService.deleteLike(id);
	}

}
