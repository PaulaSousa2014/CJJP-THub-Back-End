package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.SocialDAO;
import THUBPROJECT.dto.Social;
import THUBPROJECT.service.Interfaces.SocialServiceInterface;

@Service // Assign Service
public class SocialService implements SocialServiceInterface{

	// Load DAO
	@Autowired
	SocialDAO socialDAO;

	// CRUD functions
	public List<Social> listSocials() {
		return socialDAO.findAll();
	}

	public Social saveSocial(Social social) {
		return socialDAO.save(social);
	}

	public Social socialById(Long id) {
		return socialDAO.findById(id).get();
	}

	public Social updateSocial(Social social) {
		return socialDAO.save(social);
	}

	public void deleteSocial(Long id) {
		socialDAO.deleteById(id);
	}

}