package com.ralph.todoapp.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table( name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Body;

    @CreationTimestamp
    private LocalDateTime created;

  //TODO: learn more about references with jpa
//    @ManyToOne()
//    @JoinTable(name = "id", foreignKey = "user_id")
//    private User user;

    public Message(String body) {
        this.Body = body;
//        this.user = user;
    }
}





