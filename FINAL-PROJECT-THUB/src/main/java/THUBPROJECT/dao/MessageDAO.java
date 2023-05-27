package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import THUBPROJECT.dto.Message;

public interface MessageDAO extends JpaRepository<Message, Long> {

	List<Message> findMessagesByPartyId(Long partyId);

	@Query("SELECT m FROM Message m WHERE m.party.id = :partyId ORDER BY m.timeSent DESC")
	List<Message> findMostRecentMessagesByPartyId(Long partyId);

}
