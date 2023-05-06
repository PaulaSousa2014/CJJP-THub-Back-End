package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import THUBPROJECT.dao.MessageDAO;
import THUBPROJECT.dto.Message;
import THUBPROJECT.service.Interfaces.MessageServiceInterface;

@Service
public class MessageService implements MessageServiceInterface{
	
	// Load DAO	
	@Autowired 
	MessageDAO messageDAO;
	

	// CRUD functions
	public List<Message> listMessages() {
		return messageDAO.findAll();
	}

	public List<Message> listMessagesByPartyId(Long partyId) {
		return messageDAO.findMessagesByPartyId(partyId);
	}

	public Message saveMessage(Message message) {
		return messageDAO.save(message);
	}

	public Message messageById(Long id) {
		return messageDAO.findById(id).get();
	}

	public Message updateMessage(Message message) {
		return messageDAO.save(message);
	}

	public void deleteMessage(Long id) {
		messageDAO.deleteById(id);
	}

}
