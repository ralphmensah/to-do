package com.ralph.todoapp.controllers;

import com.ralph.todoapp.exceptions.NotFoundException;
import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/msg")
public class MessageController {
    private final MessageService messageService;

    //Create
    @PostMapping("/add")
    public Message addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }

//    read
    @GetMapping("/getAll")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/get/{msg_id}")
    public Message getMessageById(@PathVariable Long msg_id) throws NotFoundException {
        return messageService.getMessageById(msg_id);
    }
    @GetMapping("/get/user/{user_id}")
    public List<Message> getAllMessagesByUserID(@PathVariable Long user_id) throws NotFoundException {
        return messageService.getAllMessagesByUserID(user_id);
    }

    //Update
    @PutMapping("/update/{id}")
    public Message updateMsg(@PathVariable Long id, @RequestBody Message message) throws NotFoundException {
        return messageService.updateMsg(id,message);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteMsg(@PathVariable Long id) throws NotFoundException {
        messageService.deleteMsg(id);
    }

}
