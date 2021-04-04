package com.ralph.todoapp.services;

import com.ralph.todoapp.exceptions.NotFoundException;
import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.models.User;
import com.ralph.todoapp.repository.MessageRepository;
import com.ralph.todoapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MessageService messageService;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getById(Long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException("User Not Found"));
    }

    public User getUserByMsg(Long msgId) throws NotFoundException {
        Message msg_Obj = messageService.getMessageById(msgId);
        Long UserID = msg_Obj.getUserID().getId();
        return userRepository.findById(UserID).orElseThrow(()-> new NotFoundException("User Not Found"));
    }
}
