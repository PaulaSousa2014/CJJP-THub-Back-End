/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	@OneToMany(mappedBy = ("User"))
	private List<User> users;

	// Constructors
	public Job() {
	}

	public Job(Long id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
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

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
	public List<User> getUsers() {
		return users;
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

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
