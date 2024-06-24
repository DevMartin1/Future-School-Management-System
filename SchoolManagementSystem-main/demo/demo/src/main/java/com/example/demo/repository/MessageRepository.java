package com.example.demo.repository;

import com.example.demo.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByGrade(String grade);

    @Query("SELECT m FROM Message m WHERE m.grade = ?1 ORDER BY m.creation_date DESC")
    List<Message> getMessages(String grade);

}
