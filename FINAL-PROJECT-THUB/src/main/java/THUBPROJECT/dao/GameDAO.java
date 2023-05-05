package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Game;
import THUBPROJECT.dto.Party;

public interface GameDAO extends JpaRepository<Game, Long> {
	


}
