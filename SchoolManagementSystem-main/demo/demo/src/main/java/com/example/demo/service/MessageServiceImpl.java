package com.example.demo.service;

import com.example.demo.entities.Message;
import com.example.demo.entities.SchoolMessage;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.SchoolMsgRepo;
import com.example.demo.web.dto.MessageDto;
import com.example.demo.web.dto.SchoolMsgDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MessageServiceImpl implements MessageService{

    private MessageRepository messageRepository;
    private SchoolMsgRepo schoolMsgRepo;

    public MessageServiceImpl(MessageRepository messageRepository, SchoolMsgRepo schoolMsgRepo) {
        this.messageRepository = messageRepository;
        this.schoolMsgRepo = schoolMsgRepo;
    }

    @Override
    public List<Message> getMessages(String grade)
    {

        return messageRepository.findAllByGrade(grade);

    }
    @Override
    public List<Message> getGradeMessages(String grade)
    {
        return messageRepository.getMessages(grade);

    }


    @Override
    public void saveMessage(MessageDto messageDto) {

        Message message = new Message(messageDto.getTitle(),messageDto.getPosted_by(),messageDto.getGrade(), messageDto.getDescription(), new Date());
        messageRepository.save(message);
    }
    @Override
    public void saveSchoolMsg(SchoolMsgDto schoolMsgDto)
    {

        SchoolMessage schoolMessage = new SchoolMessage(schoolMsgDto.getQuery_code(), schoolMsgDto.getDscription(), new Date());
        schoolMsgRepo.save(schoolMessage);

    }
}
