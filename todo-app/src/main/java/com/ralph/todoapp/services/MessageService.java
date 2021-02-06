package com.ralph.todoapp.services;

import com.ralph.todoapp.exceptions.MessageNotFoundException;
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
    //Get message by Id
    public Message getMessagesById(Long id) throws MessageNotFoundException {
        Optional<Message> messageById = messageRepository.findById(id);
        if(messageById.isPresent()){
            return messageById.get();
        }else {
            throw new MessageNotFoundException("Message Not Found");
        }
    }

    public Message updateMessage(Long id, Message message) throws MessageNotFoundException {
        Optional<Message> messageById = messageRepository.findById(id);
        if(messageById.isPresent()){
            Message msg_obj = messageById.get();
            msg_obj.setBody(message.getBody());
            return msg_obj;
        }else {
            throw new MessageNotFoundException("Message Not Found");
        }
    }

//    public Optional<Message> getById(Long Id){
//        if (messageRepository.findById(Id).isPresent()){
//
//        }
//
//    }
}
