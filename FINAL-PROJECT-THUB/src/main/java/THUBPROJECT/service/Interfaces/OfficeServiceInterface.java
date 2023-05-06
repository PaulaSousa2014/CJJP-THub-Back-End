package THUBPROJECT.service.Interfaces;

import java.util.List;

import THUBPROJECT.dto.Office;

public interface OfficeServiceInterface {
	
	// CRUD functions
	public List<Office> listOffices();

	public Office saveOffice(Office office);

	public Office officeById(Long id);

	public Office updateOffice(Office office);

	public void deleteOffice(Long id);

}
