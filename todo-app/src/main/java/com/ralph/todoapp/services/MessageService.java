package com.ralph.todoapp.services;

import com.ralph.todoapp.exceptions.NotFoundException;
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

    public Message getMessageById(Long msg_id) throws NotFoundException {
        return messageRepository.findById(msg_id).orElseThrow(()-> new NotFoundException("Message Not Found"));
    }

    public Message addMessage(Message message) {
        message.setDone(false);
        return messageRepository.save(message);
    }

    public Message updateMsg(Long id, Message message) throws NotFoundException {
        Message updateObj = messageRepository.findById(id).orElseThrow(()-> new NotFoundException("Message Not Found"));
        updateObj.setMsg(message.getMsg());
        updateObj.setDone(message.getDone());

        return messageRepository.save(updateObj);
    }

    public void deleteMsg(Long id) throws NotFoundException {
        Message msgObj = messageRepository.findById(id).orElseThrow(()-> new NotFoundException("Message Not Found"));
        messageRepository.delete(msgObj);
    }
}
