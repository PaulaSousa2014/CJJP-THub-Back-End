package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Social;

public interface SocialServiceInterface {
	
	// CRUD functions
	public List<Social> listSocials();

	public Social saveSocial(Social social);

	public Social socialById(Long id);

	public Social updateSocial(Social social);

	public void deleteSocial(Long id);

}
