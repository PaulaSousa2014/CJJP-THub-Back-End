package THUBPROJECT.dto;

import jakarta.persistence.Column;
import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;

	@Column(name="activity_type")
	private int activityType;
	
	/*the relationship parties is still missing*/



	public Activity() {}
	public Activity(Long id, String title, String description, int activityType) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.activityType = activityType;
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
	 * @return the activityType
	 */
	public int getActivityType() {
		return activityType;
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
	 * @param activityType the activityType to set
	 */
	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}





}