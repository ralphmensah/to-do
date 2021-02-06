package com.ralph.todoapp.controllers;

import com.ralph.todoapp.exceptions.MessageNotFoundException;
import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.services.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@AllArgsConstructor
@RequestMapping(path = "/")
@RestController
public class MessageController {

    private final MessageService messageService;


    @PostMapping("add_message/")
    public Message addMessage(@RequestBody Message message){
        log.info("controller side :"+message);
        return messageService.addMessage(message);
    }

    @GetMapping("get_messages/")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("get_message/{id}")
    public Message getMessageById(@PathVariable Long id) throws MessageNotFoundException {
        return messageService.getMessagesById(id);
    }
}
