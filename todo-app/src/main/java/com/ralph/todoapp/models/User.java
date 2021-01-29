package com.ralph.todoapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String username;
    private String password;

//    @OneToMany()
//    @JoinColumn(name = "id", referencedColumnName = "user_id")
//    private List<Message> messages;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //    private Message message;
}
