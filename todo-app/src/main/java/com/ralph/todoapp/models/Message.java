package com.ralph.todoapp.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table( name = "message")
public class Message {
    @JsonProperty("body")
    private String body;
    @Id
    @SequenceGenerator(
            name = "messageSequence",
            sequenceName = "messageSequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    public Message(String body) {
        this.body = body;
    }

    protected Message() {

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
