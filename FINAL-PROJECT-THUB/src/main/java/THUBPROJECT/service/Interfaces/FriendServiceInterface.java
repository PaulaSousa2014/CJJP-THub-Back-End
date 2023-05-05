package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Friend;

public interface FriendServiceInterface {
	
	// CRUD functions
	public List<Friend> listFriends();

	public Friend saveFriend(Friend friend);

	public Friend friendById(Long id);

	public Friend updateFriend(Friend friend);

	public void deleteFriend(Long id);

}
