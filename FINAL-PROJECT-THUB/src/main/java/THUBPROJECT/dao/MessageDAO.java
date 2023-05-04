package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import THUBPROJECT.dto.Message;

public interface MessageDAO extends JpaRepository<Message, Long>{

	List<Message> findMessagesByPartyId(Long partyId);

}
