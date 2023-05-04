package THUBPROJECT.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import THUBPROJECT.dao.PrivMessageDAO;
import THUBPROJECT.dto.PrivMessage;

@Service // Assign Service
public class PrivMessageService {

	// Load DAO
	@Autowired
	PrivMessageDAO privMessageDAO;

	// CRUD functions
	public List<PrivMessage> listprivMessages() {
		return privMessageDAO.findAll();
	}

	public PrivMessage savePrivMessage(PrivMessage privMessage) {
		return privMessageDAO.save(privMessage);
	}

	public PrivMessage privMessageById(Long id) {
		return privMessageDAO.findById(id).get();
	}

	public PrivMessage updatePrivMessage(PrivMessage privMessage) {
		return privMessageDAO.save(privMessage);
	}

	public void deletePrivMessage(Long id) {
		privMessageDAO.deleteById(id);
	}

}