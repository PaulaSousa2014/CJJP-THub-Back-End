package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
		@GetMapping("/socials")
		public List<Social> listSocials() {
			return socialService.listSocials();
		}

		@GetMapping("/socials/{id}")
		public Social socialById(@PathVariable(name = "id") Long id) {
			Social socialxID = new Social();

			socialxID = socialService.socialById(id);

			return socialxID;
		}

		// Post Mappings
		@PostMapping("/socials")
		public Social saveSocial(@RequestBody Social social) {
			return socialService.saveSocial(social);
		}

		// Put Mappings
		@PutMapping("/socials/{id}")
		public Social updateSocial(@PathVariable(name = "id") Long id, @RequestBody Social social) {
			Social selectedSocial = new Social(id, social.getTitle(), social.getDescription(), social.getTheme());
			Social updatedSocial = new Social();

			updatedSocial = socialService.updateSocial(selectedSocial);
			return updatedSocial;
		}

		// Delete Mappings
		@DeleteMapping("/socials/{id}")
		public void deleteSocial(@PathVariable(name = "id") Long id) {
			socialService.deleteSocial(id);
		}

}
