package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@GetMapping("/roles")
	public List<Role> listUsers() {
		return roleService.listRoles();
	}

	@GetMapping("/roles/{id}")
	public Role userById(@PathVariable(name = "id") Long id) {
		Role rolerxID = new Role();
		rolerxID = roleService.roleById(id);
		return rolerxID;
	}

	// Post Mappings
	@PostMapping("/roles")
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

	// Put Mappings
	@PutMapping("/roles/{id}")
	public Role updateRole(@PathVariable(name = "id") Long id, @RequestBody Role user) {
		Role selectedRole = new Role(id, user.getName());
		Role updatedRole = new Role();
		updatedRole = roleService.updateRole(selectedRole);
		return updatedRole;
	}

	// Delete Mappings
	@DeleteMapping("/roles/{id}")
	public void deleteRole(@PathVariable(name = "id") Long id) {
		roleService.deleteRole(id);
	}

}

