package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Party;

public interface PartyServiceInterface {
	
	// CRUD functions
	public List<Party> listParties();
	
	public List<Party> listPartiesByGameId(Long gameId);
	
	public List<Party> listPartiesByActivityId(Long activityId);
	
	public List<Party> listPartiesBySocialId(Long socialId);
	
	public List<Party> listPartiesByGameTitleContaining(String title);

	public Party saveParty(Party party);

	public Party partyById(Long id);

	public Party updateParty(Party party);

	public void deleteParty(Long id);

}
