package THUBPROJECT.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private ERole name;

	// Constructors
	public Role() {
	}

	public Role(Long id, ERole name) {
		this.id = id;
		this.name = name;
	}

	// Getters
	public Role(ERole name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public ERole getName() {
		return name;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(ERole name) {
		this.name = name;
	}

}
