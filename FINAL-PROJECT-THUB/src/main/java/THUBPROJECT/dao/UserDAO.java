package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import THUBPROJECT.dto.User;

public interface UserDAO extends JpaRepository<User, Long> {}
