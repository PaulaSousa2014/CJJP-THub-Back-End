package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.PartyMemberList;

public interface PartyMemberListDAO  extends JpaRepository<PartyMemberList, Long> {

	public List<PartyMemberList> findPartiesByUserId(Long userId);

	public List<PartyMemberList> findUsersByPartyId(Long partyId);

}
