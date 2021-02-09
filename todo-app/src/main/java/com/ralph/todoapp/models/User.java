package com.ralph.todoapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @SequenceGenerator(
            name = "userSequence",
            sequenceName = "userSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<Message> messages;
    @CreationTimestamp
    private LocalDateTime created;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
