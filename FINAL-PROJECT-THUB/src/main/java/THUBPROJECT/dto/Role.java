package THUBPROJECT.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	
	/*
	 CREATE TABLE IF NOT EXISTS roles (
		id INT NOT NULL AUTO_INCREMENT,
		name VARCHAR(255) NOT NULL,
		PRIMARY KEY (id)
	); */
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;

	// Constructors
	public Role() {}
	
	public Role(Long id, String name){
		this.id = id;
		this.name = name;
	}

	// Setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
}
