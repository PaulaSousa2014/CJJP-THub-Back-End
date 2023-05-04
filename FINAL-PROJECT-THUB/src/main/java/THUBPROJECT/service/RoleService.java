package THUBPROJECT.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import THUBPROJECT.dao.RoleDAO;
import THUBPROJECT.dto.Role;

@Service // Assign Service
public class RoleService {

	// Load DAO
	@Autowired
	RoleDAO roleDAO;

	// CRUD functions
	public List<Role> listRoles() {
		return roleDAO.findAll();
	}

	public Role saveRole(Role role) {
		return roleDAO.save(role);
	}

	public Role roleById(Long id) {
		return roleDAO.findById(id).get();
	}

	public Role updateRole(Role role) {
		return roleDAO.save(role);
	}

	public void deleteRole(Long id) {
		roleDAO.deleteById(id);
	}

}