package com.ralph.todoapp;

import com.ralph.todoapp.models.Message;
import com.ralph.todoapp.models.User;
import com.ralph.todoapp.repository.MessageRepository;
import com.ralph.todoapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class config {

    @Bean
    CommandLineRunner CommandLineRunner(MessageRepository repository, UserRepository userRepository) {
        return args -> {
            User user =  new User("r@m.com","password");

            Message m1 = new Message("Hello");
            Message m2 = new Message("Hello How are you");

//            userRepository.save(user);
            repository.saveAll(List.of(m1,m2));
        };
    }
}
