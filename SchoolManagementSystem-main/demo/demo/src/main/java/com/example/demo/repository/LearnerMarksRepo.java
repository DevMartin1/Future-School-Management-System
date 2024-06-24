package com.example.demo.repository;

import com.example.demo.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LearnerMarksRepo  extends JpaRepository<Mark, Long> {

    @Query("SELECT m FROM Mark m WHERE m.learner_id =?1")
    public List<Mark> getTermMarks(String learner_id);
}
