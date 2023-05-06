package THUBPROJECT.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import THUBPROJECT.dao.UserRoleDAO;
import THUBPROJECT.dto.UserRole;
import THUBPROJECT.service.Interfaces.UserRoleServiceInterface;


@Service // Assign Service
public class UserRoleService implements UserRoleServiceInterface{

	// Load DAO
	@Autowired
	UserRoleDAO userRoleDAO;

	// CRUD functions
	public List<UserRole> listUserRoles() {
		return userRoleDAO.findAll();
	}

	public UserRole saveUserRole(UserRole userRole) {
		return userRoleDAO.save(userRole);
	}

	public UserRole userRoleById(Long id) {
		return userRoleDAO.findById(id).get();
	}

	public UserRole updateUserRole(UserRole userRole) {
		return userRoleDAO.save(userRole);
	}

	public void deleteUserRole(Long id) {
		userRoleDAO.deleteById(id);
	}

}
