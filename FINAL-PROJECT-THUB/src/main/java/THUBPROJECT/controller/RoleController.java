package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.Role;
import THUBPROJECT.service.RoleService;

@RestController // Rest controller
@RequestMapping("/api")
public class RoleController {

	// Implement service
	@Autowired
	RoleService roleService;

	// Get Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/roles")
	public List<Role> listUsers() {
		return roleService.listRoles();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/roles/{id}")
	public Role userById(@PathVariable(name = "id") Long id) {
		Role rolerxID = new Role();
		rolerxID = roleService.roleById(id);
		return rolerxID;
	}

	// Post Mappings
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/roles")
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}



}

