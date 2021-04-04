package com.ralph.todoapp.models;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.View;


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

    @JsonProperty("user_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @Lazy
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userID;
    private String msg;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public Message(String msg) {
        this.msg = msg;
    }

    public Message(User userID, String msg) {
        this.userID = userID;
        this.msg = msg;
    }
}
