package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.Game;
import THUBPROJECT.service.GameService;

@RestController // Rest controller
@RequestMapping("/api")
public class GameController {

	// Implement service
		@Autowired
		GameService gameService;

		// Get Mappings
		@PreAuthorize("hasRole('USER')")
		@GetMapping("/games")
		public List<Game> listGames() {
			return gameService.listGames();
		}

		@PreAuthorize("hasRole('USER')")
		@GetMapping("/games/{id}")
		public Game gameById(@PathVariable(name = "id") Long id) {
			Game gamexID = new Game();

			gamexID = gameService.gameById(id);

			return gamexID;
		}

		// Post Mappings
		@PreAuthorize("hasRole('USER')")
		@PostMapping("/games")
		public Game saveGame(@RequestBody Game game) {
			return gameService.saveGame(game);
		}

		// Put Mappings
		@PreAuthorize("hasRole('USER')")
		@PutMapping("/games/{id}")
		public Game updateGame(@PathVariable(name = "id") Long id, @RequestBody Game game) {
			Game selectedGame = new Game(id, game.getTitle(), game.getDescription(), game.getPlaytime());
			Game updatedGame = new Game();

			updatedGame = gameService.updateGame(selectedGame);
			return updatedGame;
		}

		// Delete Mappings
		@PreAuthorize("hasRole('USER')")
		@DeleteMapping("/games/{id}")
		public void deleteGame(@PathVariable(name = "id") Long id) {
			gameService.deleteGame(id);
		}

}
