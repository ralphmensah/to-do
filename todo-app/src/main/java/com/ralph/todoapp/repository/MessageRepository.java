package com.ralph.todoapp.repository;

import com.ralph.todoapp.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query("select m from Message m where m.userID.id = ?1")
    List<Message> findAllMessagesByUserId(Long userId);
}
