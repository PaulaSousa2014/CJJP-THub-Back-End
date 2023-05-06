package THUBPROJECT.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "activity_type")
	private String type;

	@OneToMany(mappedBy = ("activity"))
	private List<Party> parties;

	public Activity() {
	}

	public Activity(Long id, String title, String description, String activity_type) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.type = activity_type;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the activity_type
	 */
	public String getType() {
		return type;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party")
	public List<Party> getParties() {
		return parties;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param activity_type the activity_type to set
	 */
	public void setType(String activity_type) {
		this.type = activity_type;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

}