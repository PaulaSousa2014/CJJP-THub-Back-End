package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.Activity;
import THUBPROJECT.service.ActivityService;

@RestController // Rest controller
@RequestMapping("/api")
public class ActivityController {

	// Implement service
		@Autowired
		ActivityService activityService;

		// Get all activities
		@PreAuthorize("hasRole('USER')")
		@GetMapping("/activities")
		public List<Activity> listActivities() {
			return activityService.listActivities();
		}

		//Get activities by ID
		@PreAuthorize("hasRole('USER')")
		@GetMapping("/activities/{id}")
		public Activity activityById(@PathVariable(name = "id") Long id) {
			Activity activityxID = new Activity();

			activityxID = activityService.activityById(id);

			return activityxID;
		}

		// Post activity
		@PreAuthorize("hasRole('USER')")
		@PostMapping("/activities")
		public Activity saveActivity(@RequestBody Activity activity) {
			return activityService.saveActivity(activity);
		}

		// Put activities by id 
		@PreAuthorize("hasRole('USER')")
		@PutMapping("/activities/{id}")
		public Activity updateActivity(@PathVariable(name = "id") Long id, @RequestBody Activity activity) {
			Activity selectedActivity = new Activity(id, activity.getTitle(), activity.getDescription(), activity.getType());
			Activity updatedActivity = new Activity();

			updatedActivity = activityService.updateActivity(selectedActivity);
			return updatedActivity;
		}

		// Delete Activities by id 
		@PreAuthorize("hasRole('USER')")
		@DeleteMapping("/activities/{id}")
		public void deleteActivity(@PathVariable(name = "id") Long id) {
			activityService.deleteActivity(id);
		}

}
