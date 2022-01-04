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
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {
    private final MessageService messageService;

    //Create
    @PostMapping("/add")
    public Message addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }

    //get msges
    @GetMapping("/getAll")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/get/{msg_id}")
    public Message getMessageById(@PathVariable Long msg_id) throws NotFoundException {
        return messageService.getMessageById(msg_id);
    }

    //Update
    @PutMapping("/update/{message_id}")
    public Message updateMsg(@PathVariable Long message_id, @RequestBody Message message) throws NotFoundException {
        return messageService.updateMsg(message_id,message);

    }
    //delete msg
    @DeleteMapping("/delete/{message_id}")
    public void deleteMsg(@PathVariable Long message_id) throws NotFoundException {
        messageService.deleteMsg(message_id);
    }

}
