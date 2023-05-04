package THUBPROJECT.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="parties")
public class Party {
	
	/*CREATE TABLE IF NOT EXISTS parties (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255) DEFAULT NULL,
    creator INT NOT NULL,
    activity INT DEFAULT NULL, 
    social INT DEFAULT NULL, 
    game INT DEFAULT NULL,
	PRIMARY KEY (id),
    CONSTRAINT FK_parties_game FOREIGN KEY (game) REFERENCES games(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_parties_creator FOREIGN KEY (creator) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_parties_activity FOREIGN KEY (activity) REFERENCES activities(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_parties_social FOREIGN KEY (social) REFERENCES socials(id) ON UPDATE CASCADE ON DELETE CASCADE

);*/
	
	// Attributes
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String title;

		private String description;

		private Game game;

		private User creator;
		
		private Activity activity;
		
		private Social social;
		
		
		
		// Constructors
		
		public Party(Long id, String title, String description, Game game, User creator, Activity activity,
				Social social) {

			this.id = id;
			this.title = title;
			this.description = description;
			this.game = game;
			this.creator = creator;
			this.activity = activity;
			this.social = social;
		}



		public Party() {

		}


		//Getters

		public Long getId() {
			return id;
		}



		public String getTitle() {
			return title;
		}



		public String getDescription() {
			return description;
		}



		public Game getGame() {
			return game;
		}



		public User getCreator() {
			return creator;
		}



		public Activity getActivity() {
			return activity;
		}



		public Social getSocial() {
			return social;
		}


		//Setters

		public void setId(Long id) {
			this.id = id;
		}



		public void setTitle(String title) {
			this.title = title;
		}



		public void setDescription(String description) {
			this.description = description;
		}



		public void setGame(Game game) {
			this.game = game;
		}



		public void setCreator(User creator) {
			this.creator = creator;
		}



		public void setActivity(Activity activity) {
			this.activity = activity;
		}



		public void setSocial(Social social) {
			this.social = social;
		}
		
		








}
