package com.ralph.todoapp.services;

import com.ralph.todoapp.exception.MessageNotFoundException;
import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    public Message addMessage(Message message){
        log.info("In service: "+message.toString());
        messageRepository.save(message);
        return message;
    }
    //TODO: Get message by Id
    public Optional<Message> getById(Long id) throws MessageNotFoundException {
        Optional<Message> getById = messageRepository.findById(id);
        return Optional.of(getById.orElseThrow(() -> new MessageNotFoundException("Message Not Found"))) ;
    }
}
