package com.example.demo.service;

import com.example.demo.entities.Mark;
import com.example.demo.repository.LearnerMarksRepo;
import com.example.demo.web.dto.MarkDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {

    private LearnerMarksRepo learnerMarksRepo;

    public MarkServiceImpl(LearnerMarksRepo learnerMarksRepo) {
        this.learnerMarksRepo = learnerMarksRepo;
    }

    @Override
    public void public_marks(MarkDto markDto)
    {
        Double total_mark = markDto.getPyhiscal_edu()+ markDto.getEnglish() +  markDto.getMaths() + markDto.getScience();
        Double average = (total_mark/4)*100;
        Mark mark = new Mark(markDto.getTerm(),markDto.getGrade(), markDto.getLearner_id(), markDto.getPyhiscal_edu(),markDto.getEnglish(), markDto.getMaths(), markDto.getScience(), markDto.getComment(),average, new Date() );

        learnerMarksRepo.save(mark);

    }

    @Override
    public List<Mark> getLearnerMarks(String learner_id)
    {

        List<Mark> marks = learnerMarksRepo.getTermMarks(learner_id);

        return marks;

    }




}
