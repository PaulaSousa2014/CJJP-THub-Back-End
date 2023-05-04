package THUBPROJECT.dto;

import jakarta.persistence.Column;
import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;

	@Column(name="playtime")
	private int playtime;

	/*the relationship parties is still missing*/

	
	// Constructors
	public Game() {
	}

	public Game(Long id, String title, String description, int playtime) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.playtime = playtime;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getPlaytime() {
		return playtime;
	}


	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}



}