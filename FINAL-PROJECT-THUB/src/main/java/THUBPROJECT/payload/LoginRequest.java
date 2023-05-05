/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.payload;

import jakarta.validation.constraints.NotBlank;

// Login request form
public class LoginRequest {
	// Attributes
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	// Getters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	// Setters
	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
