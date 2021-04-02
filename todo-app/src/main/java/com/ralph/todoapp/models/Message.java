package com.ralph.todoapp.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table
public class Message {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String msg;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public Message(String msg) {
        this.msg = msg;
    }
}
