package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.PrivMessage;
import THUBPROJECT.dto.User;
import THUBPROJECT.service.PrivMessageService;

@RestController // Rest controller
@RequestMapping("/api")
public class PrivMessageController {

	// Implement service
	@Autowired
	PrivMessageService privMessageService;

	// Get Mappings
	// Get all messages
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/privMessages")
	public List<PrivMessage> listPrivMessages() {
		return privMessageService.listprivMessages();
	}

	// Get message by Id
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/privMessages/{id}")
	public PrivMessage privMessageById(@PathVariable(name = "id") Long id) {
		PrivMessage privMessagesxID = new PrivMessage();
		privMessagesxID = privMessageService.privMessageById(id);
		return privMessagesxID;
	}

	// Get all messages by sender
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/privMessages/sender")
	public List<PrivMessage> findPrivMessageBySender(@RequestBody User sender) {

		return privMessageService.findPrivMessageBySender(sender);
	}

	// Get all messages from receiver
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/privMessages/receiver")
	public List<PrivMessage> findPrivMessageByReceiver(@RequestBody User receiver) {
		return privMessageService.findPrivMessageByReceiver(receiver);
	}

	// Get conversation between sender and receiver
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/privMessages/sender/{sId}/receiver/{rId}")
	public List<PrivMessage> findPrivMessageByReceiver(
			@PathVariable("sId") Long senderId,
			@PathVariable("rId") Long receiverId) {
		return privMessageService.listConversationMessages(senderId, receiverId);
	}

	// Post Mappings
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/privMessages")
	public PrivMessage savePrivMessage(@RequestBody PrivMessage privMessage) {
		return privMessageService.savePrivMessage(privMessage);
	}

	// Delete Mappings
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/privMessages/{id}")
	public void deletePrivMessage(@PathVariable(name = "id") Long id) {
		privMessageService.deletePrivMessage(id);
	}

}
