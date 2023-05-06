package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.User;

public interface UserServiceInterface {
	
	// CRUD functions
	public List<User> listUsers();

	public User saveUser(User user);

	public User userById(Long id);

	public User updateUser(User user);

	public void deleteUser(Long id);

}
