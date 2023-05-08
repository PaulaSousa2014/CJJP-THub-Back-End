package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.User;
import THUBPROJECT.service.UserService;

@RestController // Rest controller
@RequestMapping("/api")
public class UserController {

	// Implement service
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder encoder;

	// Get Mappings
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/users")
	public List<User> listUsers() {
		return userService.listUsers();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/users/{id}")
	public User userById(@PathVariable(name = "id") Long id) {
		User userxID = new User();

		userxID = userService.userById(id);

		return userxID;
	}

	// Post Mappings
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	// Put Mappings
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
		User selectedUser = new User(id, user.getName(), user.getUsername(), encoder.encode(user.getPassword()), user.getEmail(),
				user.getSteam_username(), user.getJob(), user.getOffice(), user.getRoles());
		User updatedUser = new User();

		updatedUser = userService.updateUser(selectedUser);
		return updatedUser;
	}
	


	// Delete Mappings
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userService.deleteUser(id);
	}

}
