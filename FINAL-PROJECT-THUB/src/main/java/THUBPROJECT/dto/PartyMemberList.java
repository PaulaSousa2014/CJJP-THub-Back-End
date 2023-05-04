package THUBPROJECT.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="party_memberlists")
public class PartyMemberList {
	
	
	/*CREATE TABLE IF NOT EXISTS party_memberlists (
    id INT NOT NULL AUTO_INCREMENT,
    user INT NOT NULL,
    party INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_party_members_user FOREIGN KEY (user) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FK_party_members_party FOREIGN KEY (party) REFERENCES parties(id) ON UPDATE CASCADE ON DELETE CASCADE
);*/
	
	// Attributes
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private User user;

		private Party party;
		
		

		//Constructors
		
		public PartyMemberList() {
		}

		public PartyMemberList(Long id, User user, Party party) {
			this.id = id;
			this.user = user;
			this.party = party;
		}

		// Getters
		public Long getId() {
			return id;
		}

		public User getUser() {
			return user;
		}

		public Party getParty() {
			return party;
		}

		// Setters
		public void setId(Long id) {
			this.id = id;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public void setParty(Party party) {
			this.party = party;
		}


}
