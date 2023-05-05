package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Message;

public interface MessageServiceInterface {
	
	// CRUD functions
	public List<Message> listMessages();

	public List<Message> listMessagesByPartyId(Long partyId);

	public Message saveMessage(Message message);

	public Message messageById(Long id);

	public Message updateMessage(Message message);

	public void deleteMessage(Long id);

}
