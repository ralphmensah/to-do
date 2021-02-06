package com.ralph.todoapp.models;


import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table( name = "message_tb")
public class Message {

    @Id
    @SequenceGenerator(
            name = "messageSequence",
            sequenceName = "messageSequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String Body;
    @CreationTimestamp
    private LocalDateTime created;

    public Message(String body) {
        this.Body = body;
    }
}





