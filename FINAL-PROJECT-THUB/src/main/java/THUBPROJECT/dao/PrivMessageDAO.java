package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import THUBPROJECT.dto.PrivMessage;
import THUBPROJECT.dto.User;

public interface PrivMessageDAO extends JpaRepository<PrivMessage, Long> {
	
	List<PrivMessage> findPrivMessageBySender(User sender);
	
	List<PrivMessage> findPrivMessageByReceiver(User receiver);
}