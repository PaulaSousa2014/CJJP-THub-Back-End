package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.PrivMessage;

public interface PrivMessageServiceInterface {
	
	// CRUD functions
	public List<PrivMessage> listprivMessages();

	public PrivMessage savePrivMessage(PrivMessage privMessage);

	public PrivMessage privMessageById(Long id);

	public PrivMessage updatePrivMessage(PrivMessage privMessage);

	public void deletePrivMessage(Long id);

}
