package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.PartyDAO;
import THUBPROJECT.dto.Party;

@Service
public class PartyService {

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
