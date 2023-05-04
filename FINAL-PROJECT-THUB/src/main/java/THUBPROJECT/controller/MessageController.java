package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import THUBPROJECT.dto.Message;
import THUBPROJECT.service.MessageService;

	@RestController // Rest controller
	@RequestMapping("/api")
	public class MessageController {

		// Implement service
		@Autowired
		MessageService messageService;

		// Get Mappings
		@GetMapping("/messages")
		public List<Message> listMessages() {
			return messageService.listMessages();
		}

		@GetMapping("/messages/{id}")
		public Message messageById(@PathVariable(name = "id") Long id) {
			Message messagexID = new Message();

			messagexID = messageService.messageById(id);

			return messagexID;
		}

		@GetMapping("/messages/party/{partyId}")
		public List<Message> listMessagesByPartyId(@PathVariable(name = "partyId") Long partyId) {
			return messageService.listMessagesByPartyId(partyId);
		}

		// Post Mappings
		@PostMapping("/messages")
		public Message saveMessage(@RequestBody Message message) {
			return messageService.saveMessage(message);
		}

		// Delete Mappings
		@DeleteMapping("/messages/{id}")
		public void deleteMessage(@PathVariable(name = "id") Long id) {
			messageService.deleteMessage(id);
		}



}
