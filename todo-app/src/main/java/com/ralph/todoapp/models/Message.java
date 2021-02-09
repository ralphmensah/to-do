package com.ralph.todoapp.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table( name = "message_tb")
public class Message {

    @Id
    @SequenceGenerator(
            name = "messageSequence",
            sequenceName = "messageSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String Body;

    @ManyToOne
    private User user;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime Updated;

  //TODO: learn more about references with jpa

//    @ManyToOne()
//
//    private User user;

    public Message(String body,User user) {
        this.Body = body;
        this.user = user;
    }
}





