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

import THUBPROJECT.dto.Party;
import THUBPROJECT.service.PartyService;

@RestController // Rest controller
@RequestMapping("/api")
public class PartyController {

	// Implement service
	@Autowired
	PartyService partyService;

	// Get Mappings
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/parties")
	public List<Party> listParties() {
		return partyService.listParties();
	}
	
	

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/parties/{id}")
	public Party partyById(@PathVariable(name = "id") Long id) {
		Party partyxID = new Party();

		partyxID = partyService.partyById(id);

		return partyxID;
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/parties/game/{gameId}")
	public List<Party> listPartiesByGameId(@PathVariable(name = "gameId") Long gameId) {
		return partyService.listPartiesByGameId(gameId);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/parties/activity/{activityId}")
	public List<Party> listPartiesByActivityId(@PathVariable(name = "activityId")Long activityId){
		return partyService.listPartiesByActivityId(activityId);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/parties/social/{socialId}")
	public List<Party> listPartiesBySocialId(@PathVariable(name = "socialId")Long socialId){
		return partyService.listPartiesBySocialId(socialId);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/parties/game/title/{gameTitle}")
	public List<Party> listPartiesByGameTitleContaining(@PathVariable(name = "gameTitle")String gameTitle){
		return partyService.listPartiesByGameTitleContaining(gameTitle);
	}

	// Post Mappings
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/parties")
	public Party saveParty(@RequestBody Party party) {
		return partyService.saveParty(party);
	}

	// Put Mappings
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/parties/{id}")
	public Party updateParty(@PathVariable(name = "id") Long id, @RequestBody Party party) {
		Party selectedParty = new Party(id, party.getTitle(), party.getDescription(), party.getGame(),
				party.getCreator(), party.getActivity(), party.getSocial());
		Party updatedParty = new Party();

		updatedParty = partyService.updateParty(selectedParty);
		return updatedParty;
	}

	// Delete Mappings
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/parties/{id}")
	public void deleteParty(@PathVariable(name = "id") Long id) {
		partyService.deleteParty(id);
	}
}
