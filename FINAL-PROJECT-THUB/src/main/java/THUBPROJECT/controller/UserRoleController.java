package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.UserRole;
import THUBPROJECT.service.UserRoleService;

@RestController // Rest controller
@RequestMapping("/api")
public class UserRoleController {

	// Implement service
	@Autowired
	UserRoleService userRoleService;

	// Get Mappings
	@GetMapping("/userRoles")
	public List<UserRole> listUserRoles() {
		return userRoleService.listUserRoles();
	}

	@GetMapping("/userRoles/{id}")
	public UserRole userById(@PathVariable(name = "id") Long id) {
		UserRole userRolexID = new UserRole();
		userRolexID = userRoleService.userRoleById(id);
		return userRolexID;
	}

	// Post Mappings
	@PostMapping("/userRoles")
	public UserRole saveRole(@RequestBody UserRole userRole) {
		return userRoleService.saveUserRole(userRole);
	}

	// Put Mappings
	@PutMapping("/userRoles/{id}")
	public UserRole updateRole(@PathVariable(name = "id") Long id, @RequestBody UserRole userRole) {
		UserRole selectedUserRole = new UserRole(id, userRole.getUser(), userRole.getRole());
		UserRole updatedUserRole = new UserRole();
		updatedUserRole = userRoleService.updateUserRole(selectedUserRole);
		return updatedUserRole;
	}

	// Delete Mappings
	@DeleteMapping("/userRoles/{id}")
	public void deleteUserRole(@PathVariable(name = "id") Long id) {
		userRoleService.deleteUserRole(id);
	}
}


