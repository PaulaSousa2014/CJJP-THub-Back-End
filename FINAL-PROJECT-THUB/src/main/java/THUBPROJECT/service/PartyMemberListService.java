package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.PartyMemberListDAO;
import THUBPROJECT.dto.PartyMemberList;

@Service
public class PartyMemberListService {
	
	// Load DAO
		@Autowired
		PartyMemberListDAO partyMemberListDAO;

		// CRUD functions
		public List<PartyMemberList> listPartyMemberLists() {
			return partyMemberListDAO.findAll();
		}

		public List<PartyMemberList> listPartiesByUserId(Long userId) {
			return partyMemberListDAO.findPartiesByUserId(userId);
		}

		public List<PartyMemberList> listUsersByPartyId(Long partyId) {
			return partyMemberListDAO.findUsersByPartyId(partyId);
		}

		public PartyMemberList savePartyMemberList(PartyMemberList party_member) {
			return partyMemberListDAO.save(party_member);
		}

		public PartyMemberList partyMemberListById(Long id) {
			return partyMemberListDAO.findById(id).get();
		}

		public void deletePartyMemberList(Long id) {
			partyMemberListDAO.deleteById(id);
		}

}
