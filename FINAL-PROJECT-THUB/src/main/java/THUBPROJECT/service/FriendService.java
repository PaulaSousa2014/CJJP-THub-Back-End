package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import THUBPROJECT.dao.FriendDAO;
import THUBPROJECT.dto.Friend;
import THUBPROJECT.service.Interfaces.FriendServiceInterface;

@Service // Assign Service
public class FriendService implements FriendServiceInterface{

	// Load DAO
	@Autowired
	FriendDAO friendDAO;

	// CRUD functions
	public List<Friend> listFriends() {
		return friendDAO.findAll();
	}

	public Friend saveFriend(Friend friend) {
		return friendDAO.save(friend);
	}

	public Friend friendById(Long id) {
		return friendDAO.findById(id).get();
	}

	public Friend updateFriend(Friend friend) {
		return friendDAO.save(friend);
	}

	public void deleteFriend(Long id) {
		friendDAO.deleteById(id);
	}

}