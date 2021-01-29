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
    @SequenceGenerator(
            name = "userSequence",
            sequenceName = "userSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userSequence")
    private Long id;

    private String username;
    private String password;

    @OneToMany()
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    private List<Message> messages;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //    private Message message;
}
