package com.example.demo.service;

import com.example.demo.entities.Mark;
import com.example.demo.web.dto.MarkDto;

import java.util.List;

public interface MarkService {

    public void public_marks(MarkDto markDto);
    public List<Mark> getLearnerMarks(String learner_id);
}
