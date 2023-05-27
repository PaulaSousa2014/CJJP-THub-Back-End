package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.Social;
import THUBPROJECT.service.SocialService;

@RestController // Rest controller
@RequestMapping("/api")
public class SocialController {

	// Implement service
	@Autowired
	SocialService socialService;

	// Get Mappings
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/socials")
	public List<Social> listSocials() {
		return socialService.listSocials();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/socials/{id}")
	public Social socialById(@PathVariable(name = "id") Long id) {
		Social socialxID = new Social();

		socialxID = socialService.socialById(id);

		return socialxID;
	}

	// Post Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/socials")
	public Social saveSocial(@RequestBody Social social) {
		return socialService.saveSocial(social);
	}

	// Put Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/socials/{id}")
	public Social updateSocial(@PathVariable(name = "id") Long id, @RequestBody Social social) {
		Social selectedSocial = new Social(id, social.getTitle(), social.getDescription(), social.getTheme());
		Social updatedSocial = new Social();

		updatedSocial = socialService.updateSocial(selectedSocial);
		return updatedSocial;
	}

	// Delete Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/socials/{id}")
	public void deleteSocial(@PathVariable(name = "id") Long id) {
		socialService.deleteSocial(id);
	}

}
