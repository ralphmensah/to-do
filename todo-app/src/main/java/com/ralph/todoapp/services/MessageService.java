package com.ralph.todoapp.services;

import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {


    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    public String addMessage(Message message){
        messageRepository.save(message);
        return "Saved Successfully";
    }
}
