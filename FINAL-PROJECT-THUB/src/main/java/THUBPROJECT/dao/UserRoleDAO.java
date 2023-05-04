package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import THUBPROJECT.dto.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {}
