/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.Office;
import THUBPROJECT.service.OfficeService;

@RestController // Rest controller
@RequestMapping("/api")
public class OfficeController {

	// Implement service
	@Autowired
	OfficeService officeService;

	// Get Mappings
	@GetMapping("/offices")
	public List<Office> listOffices() {
		return officeService.listOffices();
	}

	@GetMapping("/offices/{id}")
	public Office officeById(@PathVariable(name = "id") Long id) {
		Office officexID = new Office();

		officexID = officeService.officeById(id);

		return officexID;
	}

	// Post Mappings
	@PostMapping("/offices")
	public Office saveOffice(@RequestBody Office office) {
		return officeService.saveOffice(office);
	}

	// Put Mappings
	@PutMapping("/offices/{id}")
	public Office updateOffice(@PathVariable(name = "id") Long id, @RequestBody Office office) {
		Office selectedOffice = new Office(id, office.getName(), office.getLocation());
		Office updatedOffice = new Office();

		updatedOffice = officeService.updateOffice(selectedOffice);
		return updatedOffice;
	}

	// Delete Mappings
	@DeleteMapping("/offices/{id}")
	public void deleteOffice(@PathVariable(name = "id") Long id) {
		officeService.deleteOffice(id);
	}

}
