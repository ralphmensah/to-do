package com.ralph.todoapp.controllers;

import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/")
@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public String addMessage(Message message){
        return messageService.addMessage(message);
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }
}
