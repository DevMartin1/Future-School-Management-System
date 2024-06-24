package com.example.demo.service;

import com.example.demo.entities.Message;
import com.example.demo.web.dto.MessageDto;
import com.example.demo.web.dto.SchoolMsgDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MessageService  {

    public void saveSchoolMsg(SchoolMsgDto schoolMsgDto);
    void saveMessage(MessageDto messageDto);
    public List<Message> getMessages(String grade);
    public List<Message> getGradeMessages(String grade);
}
