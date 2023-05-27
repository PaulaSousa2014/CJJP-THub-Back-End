package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.PartyMemberListDAO;
import THUBPROJECT.dto.PartyMemberList;
import THUBPROJECT.service.Interfaces.PartyMemberListServiceInterface;

@Service
public class PartyMemberListService implements PartyMemberListServiceInterface{
	
	// Load DAO
		@Autowired
		PartyMemberListDAO partyMemberListDAO;

		// CRUD functions
		
		public List<PartyMemberList> listPartyMemberLists() {
			return partyMemberListDAO.findAll();
		}

		//Get parties by userId
		public List<PartyMemberList> listPartiesByUserId(Long userId) {
			return partyMemberListDAO.findPartiesByUserId(userId);
		}

		public List<PartyMemberList> listUsersByPartyId(Long partyId) {
			return partyMemberListDAO.findUsersByPartyId(partyId);
		}

		public PartyMemberList savePartyMemberList(PartyMemberList party_member) {
			return partyMemberListDAO.save(party_member);
		}
		
		public PartyMemberList updatePartyMemberList(PartyMemberList party_member) {

			return partyMemberListDAO.save(party_member);
		}

		public PartyMemberList partyMemberListById(Long id) {
			return partyMemberListDAO.findById(id).get();
		}

		public void deletePartyMemberList(Long id) {
			partyMemberListDAO.deleteById(id);
		}
		
		
			
		
		public Long findPartyMemberIdByUserIdAndPartyId(Long userId, Long partyId) {
		    PartyMemberList partyMember = partyMemberListDAO.findPartyMembersByUserIdAndPartyId(userId, partyId);
		    if (partyMember != null) {
		        return partyMember.getId();
		    } else {
		        return null;
		    }
		}

		



		public PartyMemberList findPartyMembersByUserIdAndPartyId(Long userId, Long partyId) {
	
		    
		    PartyMemberList partyMembersList = partyMemberListDAO.findPartyMembersByUserIdAndPartyId(userId, partyId);
		    
		    if (partyMembersList != null) {

		    	return partyMembersList;
		    } else {

		    	return null;
		    }
		}



		



}
