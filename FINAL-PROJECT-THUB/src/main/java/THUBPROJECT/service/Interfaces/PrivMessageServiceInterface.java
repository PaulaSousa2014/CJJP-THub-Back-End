package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.PrivMessage;
import THUBPROJECT.dto.User;

public interface PrivMessageServiceInterface {
	
	// CRUD functions
	public List<PrivMessage> listprivMessages();
	
	public List<PrivMessage> findPrivMessageBySender(User sender);
	
	public List<PrivMessage> findPrivMessageByReceiver(User receiver);

	public PrivMessage savePrivMessage(PrivMessage privMessage);

	public PrivMessage privMessageById(Long id);

	public PrivMessage updatePrivMessage(PrivMessage privMessage);

	public void deletePrivMessage(Long id);

}
