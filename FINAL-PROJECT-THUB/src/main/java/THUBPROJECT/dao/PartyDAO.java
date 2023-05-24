package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Party;

public interface PartyDAO extends JpaRepository<Party, Long> {

	List<Party> findPartiesByGameId(Long gameId);

	List<Party> findPartiesByActivityId(Long activityId);

	List<Party> findPartiesBySocialId(Long socialId);

	List<Party> findPartiesByGameTitleContaining(String title);
	
	List<Party> findPartiesBySocialThemeContaining(String theme);
	
	List<Party> findPartiesByActivityTypeContaining(String activity_type);
	
	List<Party> findPartiesByCreatorId(Long creatorId);

}
