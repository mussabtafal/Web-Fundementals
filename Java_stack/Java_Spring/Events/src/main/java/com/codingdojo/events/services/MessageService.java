package com.codingdojo.events.services;

import org.springframework.stereotype.Service;
import com.codingdojo.events.models.Message;
import com.codingdojo.events.repositories.MessageRepository;

@Service
public class MessageService {
	
	private final MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	 public Message createMessage(Message message) {
	        return messageRepository.save(message);
	    }
	
	

}
