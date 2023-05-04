package THUBPROJECT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THUBPROJECT.dao.OfficeDAO;
import THUBPROJECT.dto.Office;

@Service // Assign Service
public class OfficeService {

	// Load DAO
	@Autowired
	OfficeDAO officeDAO;

	// CRUD functions
	public List<Office> listOffices() {
		return officeDAO.findAll();
	}

	public Office saveOffice(Office office) {
		return officeDAO.save(office);
	}

	public Office officeById(Long id) {
		return officeDAO.findById(id).get();
	}

	public Office updateOffice(Office office) {
		return officeDAO.save(office);
	}

	public void deleteOffice(Long id) {
		officeDAO.deleteById(id);
	}

}
