package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import THUBPROJECT.dto.PrivMessage;
import THUBPROJECT.dto.User;

public interface PrivMessageDAO extends JpaRepository<PrivMessage, Long> {
	
	List<PrivMessage> findPrivMessageBySender(User sender);
	
	List<PrivMessage> findPrivMessageByReceiver(User receiver);
	
	@Query("SELECT m FROM PrivMessage m WHERE m.sender.id = :senderId AND m.receiver.id = :receiverId")
	List<PrivMessage> findPrivMessageBySenderAndReceiver(Long senderId, Long receiverId);
}