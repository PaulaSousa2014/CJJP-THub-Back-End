package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.Friend;
import THUBPROJECT.service.FriendService;

@RestController // Rest controller
@RequestMapping("/api")
public class FriendController {

	// Implement service
	@Autowired
	FriendService friendService;

	// Get all friends 
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/friends")
	public List<Friend> listUsers() {
		return friendService.listFriends();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/friends/{id}")
	public Friend userById(@PathVariable(name = "id") Long id) {
		Friend friendxID = new Friend();
		friendxID = friendService.friendById(id);
		return friendxID;
	}

	// Post Mappings
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/friends")
	public Friend saveUser(@RequestBody Friend friend) {
		return friendService.saveFriend(friend);
	}

	// Put friend by ID
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/friends/{id}")
	public Friend updateUser(@PathVariable(name = "id") Long id, @RequestBody Friend friend) {
		Friend selectedFriend = new Friend(id, friend.isStatus(), friend.getUserSender(), friend.getUserReciever());
		Friend updatedFriend = new Friend();

		updatedFriend = friendService.updateFriend(selectedFriend);
		return updatedFriend;
	}

	// Delete friend by ID
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/friends/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		friendService.deleteFriend(id);
	}

}
