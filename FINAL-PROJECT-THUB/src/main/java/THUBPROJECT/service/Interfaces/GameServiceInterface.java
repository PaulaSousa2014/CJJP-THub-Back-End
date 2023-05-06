package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Game;

public interface GameServiceInterface {
	
	// CRUD functions
	public List<Game> listGames();
	
	public List<Game> listGamesByTitleContaining(String title);

	public Game saveGame(Game game);

	public Game gameById(Long id);

	public Game updateGame(Game game);

	public void deleteGame(Long id);

}
