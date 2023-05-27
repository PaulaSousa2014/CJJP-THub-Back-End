package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.PartyMemberList;

public interface PartyMemberListServiceInterface {
	
	// CRUD functions
	public List<PartyMemberList> listPartyMemberLists();

	public List<PartyMemberList> listPartiesByUserId(Long userId);

	public List<PartyMemberList> listUsersByPartyId(Long partyId);
	
	public PartyMemberList findPartyMembersByUserIdAndPartyId(Long userId, Long partyId);
	
	public Long findPartyMemberIdByUserIdAndPartyId(Long userId, Long partyId);

	public PartyMemberList savePartyMemberList(PartyMemberList party_member);
	
	public PartyMemberList updatePartyMemberList(PartyMemberList party_member);

	public PartyMemberList partyMemberListById(Long id);

	public void deletePartyMemberList(Long id);

}
