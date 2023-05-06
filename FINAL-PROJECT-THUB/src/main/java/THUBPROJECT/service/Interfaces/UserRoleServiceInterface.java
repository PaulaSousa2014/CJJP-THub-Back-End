package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.UserRole;

public interface UserRoleServiceInterface {
	
	// CRUD functions
	public List<UserRole> listUserRoles();

	public UserRole saveUserRole(UserRole userRole);

	public UserRole userRoleById(Long id);

	public UserRole updateUserRole(UserRole userRole);

	public void deleteUserRole(Long id);

}
