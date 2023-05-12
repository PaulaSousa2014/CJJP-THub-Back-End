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

import THUBPROJECT.dto.PartyMemberList;
import THUBPROJECT.service.PartyMemberListService;

@RestController // Rest controller
@RequestMapping("/api")
public class PartyMemberListController {

	// Implement service
	@Autowired
	PartyMemberListService partyMemberListService;

	// Get Mappings
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/party_members")
	public List<PartyMemberList> listPartyMemberLists() {
		return partyMemberListService.listPartyMemberLists();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/party_members/{id}")
	public PartyMemberList party_MemberById(@PathVariable(name = "id") Long id) {
		PartyMemberList party_MemberxID = new PartyMemberList();

		party_MemberxID = partyMemberListService.partyMemberListById(id);

		return party_MemberxID;
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/party_members/user/{userId}")
	public List<PartyMemberList> listPartiesByUserId(@PathVariable(name = "userId") Long userId) {
		return partyMemberListService.listPartiesByUserId(userId);
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/party_members/party/{partyId}")
	public List<PartyMemberList> listUsersByPartyId(@PathVariable(name = "partyId") Long partyId) {
		return partyMemberListService.listUsersByPartyId(partyId);
	}

	// Post Mappings
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/party_members")
	public PartyMemberList savePartyMemberList(@RequestBody PartyMemberList partyMemberList) {
		return partyMemberListService.savePartyMemberList(partyMemberList);
	}
	
	// Put Mappings
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/party_members/{party_members_id}")
	public PartyMemberList updatePartyMemberList(@PathVariable(name = "party_members_id") Long id, @RequestBody  PartyMemberList list) {
		
		PartyMemberList selectedList = new PartyMemberList(id, list.getUser(), list.getParty());
		PartyMemberList updatedList = new PartyMemberList();
		
		updatedList = partyMemberListService.updatePartyMemberList(selectedList);
		

		return updatedList;
	}

	// Delete Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/party_members/{id}")
	public void deletePartyMemberList(@PathVariable(name = "id") Long id) {
		partyMemberListService.deletePartyMemberList(id);
	}
}
