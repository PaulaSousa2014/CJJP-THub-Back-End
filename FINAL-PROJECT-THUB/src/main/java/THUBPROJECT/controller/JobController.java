/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.Job;
import THUBPROJECT.service.JobService;

@RestController // Rest controller
@RequestMapping("/api")
public class JobController {

	// Implement service
	@Autowired
	JobService jobService;

	// Get Mappings
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/jobs")
	public List<Job> listJobs() {
		return jobService.listJobs();
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/jobs/{id}")
	public Job jobById(@PathVariable(name = "id") Long id) {
		Job jobxID = new Job();

		jobxID = jobService.jobById(id);

		return jobxID;
	}

	// Post Mappings
	@PostMapping("/jobs")
	public Job saveJob(@RequestBody Job job) {
		return jobService.saveJob(job);
	}

	// Put Mappings
	@PutMapping("/jobs/{id}")
	public Job updateJob(@PathVariable(name = "id") Long id, @RequestBody Job job) {
		Job selectedJob = new Job(id, job.getTitle(), job.getDescription());
		Job updatedJob = new Job();

		updatedJob = jobService.updateJob(selectedJob);
		return updatedJob;
	}

	// Delete Mappings
	@DeleteMapping("/jobs/{id}")
	public void deleteJob(@PathVariable(name = "id") Long id) {
		jobService.deleteJob(id);
	}

}
