package com.ralph.todoapp.models;


import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@Entity
@Table
public class Message {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String msg;
    private Boolean is_done;
    @CreationTimestamp
    private LocalDateTime date_created;
    @UpdateTimestamp
    private LocalDateTime date_updated;

    public Message(String msg) {
        this.msg = msg;
        this.is_done = Boolean.FALSE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getDone() {
        return is_done;
    }

    public void setDone(Boolean done) {
        is_done = done;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }

    public LocalDateTime getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(LocalDateTime date_updated) {
        this.date_updated = date_updated;
    }
}
