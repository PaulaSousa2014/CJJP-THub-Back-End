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

		// Get Mappings
		@PreAuthorize("hasRole('USER')")
		@GetMapping("/activities")
		public List<Activity> listActivities() {
			return activityService.listActivities();
		}

		@PreAuthorize("hasRole('USER')")
		@GetMapping("/activities/{id}")
		public Activity activityById(@PathVariable(name = "id") Long id) {
			Activity activityxID = new Activity();

			activityxID = activityService.activityById(id);

			return activityxID;
		}

		// Post Mappings
		@PreAuthorize("hasRole('USER')")
		@PostMapping("/activities")
		public Activity saveActivity(@RequestBody Activity activity) {
			return activityService.saveActivity(activity);
		}

		// Put Mappings
		@PreAuthorize("hasRole('USER')")
		@PutMapping("/activities/{id}")
		public Activity updateActivity(@PathVariable(name = "id") Long id, @RequestBody Activity activity) {
			Activity selectedActivity = new Activity(id, activity.getTitle(), activity.getDescription(), activity.getActivity_type());
			Activity updatedActivity = new Activity();

			updatedActivity = activityService.updateActivity(selectedActivity);
			return updatedActivity;
		}

		// Delete Mappings
		@PreAuthorize("hasRole('USER')")
		@DeleteMapping("/activities/{id}")
		public void deleteActivity(@PathVariable(name = "id") Long id) {
			activityService.deleteActivity(id);
		}

}
