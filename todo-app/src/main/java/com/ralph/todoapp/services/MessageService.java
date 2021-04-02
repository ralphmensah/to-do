package com.ralph.todoapp.services;

import com.ralph.todoapp.exceptions.MessageNotFoundException;
import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;


    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long msg_id) throws MessageNotFoundException {
        return messageRepository.findById(msg_id).orElseThrow(()-> new MessageNotFoundException("Message Not Found"));
    }

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message updateMsg(Long id, Message message) throws MessageNotFoundException {
        Message updateObj = messageRepository.findById(id).orElseThrow(()-> new MessageNotFoundException("Message Not Found"));
        updateObj.setMsg(message.getMsg());

        return messageRepository.save(updateObj);
    }

    public void deleteMsg(Long id) throws MessageNotFoundException {
        Message msgObj = messageRepository.findById(id).orElseThrow(()-> new MessageNotFoundException("Message Not Found"));
        messageRepository.delete(msgObj);
    }
}
