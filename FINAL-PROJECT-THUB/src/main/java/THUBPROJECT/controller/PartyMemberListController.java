package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.PartyMemberList;
import THUBPROJECT.dto.User;
import THUBPROJECT.service.PartyMemberListService;
import THUBPROJECT.service.PartyService;
import THUBPROJECT.service.UserService;
import jakarta.resource.ResourceException;

@RestController // Rest controller
@RequestMapping("/api")
public class PartyMemberListController {

	// Implement service
	@Autowired
	PartyMemberListService partyMemberListService;
	@Autowired
	UserService userService;
	@Autowired
	PartyService partyService;

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
	
	// Get party_member_id by user_id & party_id
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/party_members/id/{partyId}/{userId}")
	public Long findPartyMemberId(@PathVariable(name = "userId") Long userId, @PathVariable(name = "partyId") Long partyId) {
	    Long partyMemberId = partyMemberListService.findPartyMemberIdByUserIdAndPartyId(userId, partyId);
	    return partyMemberId;
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
	
	// Post Mappings Join a party by party_id & user_id
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/party_members/{party_id}/{user_id}")
	public PartyMemberList savePartyMemberListNew(@PathVariable(name = "party_id") Long party_id, @PathVariable(name = "user_id") Long user_id) {
		
		PartyMemberList partyList = new PartyMemberList();
		partyList.setUser(userService.userById(user_id));
		partyList.setParty(partyService.partyById(party_id));
		
		return partyMemberListService.updatePartyMemberList(partyList);
		
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
	@DeleteMapping("/party_members/{party_id}")
	public void deletePartyMemberList(@PathVariable(name = "party_id") Long id) {
		
		partyMemberListService.deletePartyMemberList(id);
	}
	
	
}
