package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import THUBPROJECT.dto.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {}
