package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/userRoles")
	public List<UserRole> listUserRoles() {
		return userRoleService.listUserRoles();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/userRoles/{id}")
	public UserRole userById(@PathVariable(name = "id") Long id) {
		UserRole userRolexID = new UserRole();
		userRolexID = userRoleService.userRoleById(id);
		return userRolexID;
	}

	// Post Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/userRoles")
	public UserRole saveRole(@RequestBody UserRole userRole) {
		return userRoleService.saveUserRole(userRole);
	}

	// Put Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/userRoles/{id}")
	public UserRole updateRole(@PathVariable(name = "id") Long id, @RequestBody UserRole userRole) {
		UserRole selectedUserRole = new UserRole(id, userRole.getUser(), userRole.getRole());
		UserRole updatedUserRole = new UserRole();
		updatedUserRole = userRoleService.updateUserRole(selectedUserRole);
		return updatedUserRole;
	}

	// Delete Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/userRoles/{id}")
	public void deleteUserRole(@PathVariable(name = "id") Long id) {
		userRoleService.deleteUserRole(id);
	}
}


