package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import THUBPROJECT.dto.Friend;

public interface FriendDAO extends JpaRepository<Friend, Long> {}