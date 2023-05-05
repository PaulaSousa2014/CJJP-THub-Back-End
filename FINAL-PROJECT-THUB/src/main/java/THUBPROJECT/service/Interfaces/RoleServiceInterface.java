package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Role;

public interface RoleServiceInterface {
	
	// CRUD functions
	public List<Role> listRoles();

	public Role saveRole(Role role);

	public Role roleById(Long id);

	public Role updateRole(Role role);

	public void deleteRole(Long id);

}
