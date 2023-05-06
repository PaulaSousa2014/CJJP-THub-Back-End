package THUBPROJECT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Game;

public interface GameDAO extends JpaRepository<Game, Long> {

	List<Game> findGamesByTitleContaining(String title);

}
