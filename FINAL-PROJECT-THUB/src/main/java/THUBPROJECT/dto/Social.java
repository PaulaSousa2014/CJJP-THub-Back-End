package THUBPROJECT.dto;

import jakarta.persistence.Column;
import jakarta.persistence.*;

@Entity
@Table(name = "socials")
public class Social {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;

	@Column(name="theme")
	private String theme; 

	/*the relationship parties is still missing*/

	
	// Constructors
	public Social() {
	}

	public Social(Long id, String title, String description, String theme) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.theme = theme;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}


}