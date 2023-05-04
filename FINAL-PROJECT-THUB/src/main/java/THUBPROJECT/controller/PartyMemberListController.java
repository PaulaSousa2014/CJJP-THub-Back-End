package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/party_members")
	public List<PartyMemberList> listPartyMemberLists() {
		return partyMemberListService.listPartyMemberLists();
	}

	@GetMapping("/party_members/{id}")
	public PartyMemberList party_MemberById(@PathVariable(name = "id") Long id) {
		PartyMemberList party_MemberxID = new PartyMemberList();

		party_MemberxID = partyMemberListService.partyMemberListById(id);

		return party_MemberxID;
	}

	@GetMapping("/party_members/user/{userId}")
	public List<PartyMemberList> listPartiesByUserId(@PathVariable(name = "userId") Long userId) {
		return partyMemberListService.listPartiesByUserId(userId);
	}

	@GetMapping("/party_members/party/{partyId}")
	public List<PartyMemberList> listUsersByPartyId(@PathVariable(name = "partyId") Long partyId) {
		return partyMemberListService.listUsersByPartyId(partyId);
	}

	// Post Mappings
	@PostMapping("/party_members")
	public PartyMemberList savePartyMemberList(@RequestBody PartyMemberList partyMemberList) {
		return partyMemberListService.savePartyMemberList(partyMemberList);
	}

	// Delete Mappings
	@DeleteMapping("/party_members/{id}")
	public void deletePartyMemberList(@PathVariable(name = "id") Long id) {
		partyMemberListService.deletePartyMemberList(id);
	}
}
