package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.GameDAO;
import THUBPROJECT.dto.Game;
import THUBPROJECT.dto.Party;

@Service // Assign Service
public class GameService {

	// Load DAO
	@Autowired
	GameDAO gameDAO;

	// CRUD functions
	public List<Game> listGames() {
		return gameDAO.findAll();
	}
	


	public Game saveGame(Game game) {
		return gameDAO.save(game);
	}

	public Game gameById(Long id) {
		return gameDAO.findById(id).get();
	}

	public Game updateGame(Game game) {
		return gameDAO.save(game);
	}

	public void deleteGame(Long id) {
		gameDAO.deleteById(id);
	}

}