package com.ralph.todoapp.services;

import com.ralph.todoapp.exceptions.MessageNotFoundException;
import com.ralph.todoapp.exceptions.UserNotFoundException;
import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.models.User;
import com.ralph.todoapp.repository.MessageRepository;
import com.ralph.todoapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MessageService {


    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }
//TODO: in adding a message user_id must be defined in the path and also must be saved into the db
    public Message addMessage(Long user_id,Message message) throws UserNotFoundException {
        Optional<User> userId = userRepository.findById(user_id);
        log.info("In service: "+message.toString());
        if(userId.isPresent()){
            return messageRepository.save(message);
        }else {
            throw new UserNotFoundException("Message Not Found");
        }

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

    public Message deleteMessage(Long id) throws MessageNotFoundException {
        Optional<Message> messageById = messageRepository.findById(id);
        if(messageById.isPresent()){
            Message msg_obj = messageById.get();
            messageRepository.delete(msg_obj);
            return msg_obj;
        }else {
            throw new MessageNotFoundException("Message Not Found");
        }
    }
}
