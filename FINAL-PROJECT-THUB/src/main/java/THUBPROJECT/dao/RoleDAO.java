package THUBPROJECT.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.ERole;
import THUBPROJECT.dto.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
