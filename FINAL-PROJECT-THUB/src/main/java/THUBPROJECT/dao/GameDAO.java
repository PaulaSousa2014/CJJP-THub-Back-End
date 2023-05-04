package THUBPROJECT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import THUBPROJECT.dto.Game;

public interface GameDAO extends JpaRepository<Game, Long> {

}
