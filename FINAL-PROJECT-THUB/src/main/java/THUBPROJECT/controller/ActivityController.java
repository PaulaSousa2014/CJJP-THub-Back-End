package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
		@GetMapping("/activitys")
		public List<Activity> listActivities() {
			return activityService.listActivities();
		}

		@GetMapping("/activitys/{id}")
		public Activity activityById(@PathVariable(name = "id") Long id) {
			Activity activityxID = new Activity();

			activityxID = activityService.activityById(id);

			return activityxID;
		}

		// Post Mappings
		@PostMapping("/activitys")
		public Activity saveActivity(@RequestBody Activity activity) {
			return activityService.saveActivity(activity);
		}

		// Put Mappings
		@PutMapping("/activitys/{id}")
		public Activity updateActivity(@PathVariable(name = "id") Long id, @RequestBody Activity activity) {
			Activity selectedActivity = new Activity(id, activity.getTitle(), activity.getDescription(), activity.getActivityType());
			Activity updatedActivity = new Activity();

			updatedActivity = activityService.updateActivity(selectedActivity);
			return updatedActivity;
		}

		// Delete Mappings
		@DeleteMapping("/activitys/{id}")
		public void deleteActivity(@PathVariable(name = "id") Long id) {
			activityService.deleteActivity(id);
		}

}
