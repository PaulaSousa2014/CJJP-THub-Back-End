package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.PartyDAO;
import THUBPROJECT.dto.Party;
import THUBPROJECT.service.Interfaces.PartyServiceInterface;

@Service
public class PartyService implements PartyServiceInterface {

	// Load DAO
	@Autowired
	PartyDAO partyDAO;

	// CRUD functions
	public List<Party> listParties() {
		return partyDAO.findAll();
	}

	public List<Party> listPartiesByGameId(Long gameId) {
		return partyDAO.findPartiesByGameId(gameId);
	}

	public List<Party> listPartiesByActivityId(Long activityId) {
		return partyDAO.findPartiesByActivityId(activityId);
	}

	public List<Party> listPartiesBySocialId(Long socialId) {
		return partyDAO.findPartiesBySocialId(socialId);
	}

	public List<Party> listPartiesByGameTitleContaining(String title) {
		return partyDAO.findPartiesByGameTitleContaining(title);
	}
	

	public List<Party> findPartiesBySocialThemeContaining(String theme) {
		
		return partyDAO.findPartiesBySocialThemeContaining(theme);
	}
	
	
	public List<Party> findPartiesByActivityTypeContaining(String activity_type) {
	
		return partyDAO.findPartiesByActivityTypeContaining(activity_type);
	}

	public Party saveParty(Party party) {
		return partyDAO.save(party);
	}

	public Party partyById(Long id) {
		return partyDAO.findById(id).get();
	}

	public Party updateParty(Party party) {
		return partyDAO.save(party);
	}

	public void deleteParty(Long id) {
		partyDAO.deleteById(id);
	}





}
