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
	public User updateAllUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
		User selectedUser = new User(id, user.getUsername(), user.getPassword(), user.getEmail(),
				user.getNameSurn(), user.getProfile_img(), user.getSteam_username(), user.getJob(), user.getOffice(), user.getRoles());
		User updatedUser = new User();

		updatedUser = userService.updateUser(selectedUser);
		return updatedUser;
	}
	
	//Patch user info
	@PreAuthorize("hasRole('USER')")
	@PatchMapping("/users/{id}")
	public User partialUpdateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
	    User selectedUser = userService.userById(id);
	    
	    // Actualiza solo los campos no nulos proporcionados en el objeto User recibido
	    if (user.getUsername() != null) {
	        selectedUser.setUsername(user.getUsername());
	    }
	    if (user.getPassword() != null) {
	        selectedUser.setPassword(encoder.encode(user.getPassword()));
	    }
	    if (user.getEmail() != null) {
	        selectedUser.setEmail(user.getEmail());
	    }
	    if (user.getNameSurn() != null) {
	        selectedUser.setNameSurn(user.getNameSurn());
	    }
	    if (user.getProfile_img() != null) {
	        selectedUser.setProfile_img(user.getProfile_img());
	    }
	    if (user.getSteam_username() != null) {
	        selectedUser.setSteam_username(user.getSteam_username());
	    }
	    if (user.getJob() != null) {
	        selectedUser.setJob(user.getJob());
	    }
	    if (user.getOffice() != null) {
	        selectedUser.setOffice(user.getOffice());
	    }
	    if (user.getRoles() != null) {
	        selectedUser.setRoles(user.getRoles());
	    }
	    
	    User updatedUser = userService.updateUser(selectedUser);
	    return updatedUser;
	}

	
	

	// Delete Mappings
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userService.deleteUser(id);
	}

}
