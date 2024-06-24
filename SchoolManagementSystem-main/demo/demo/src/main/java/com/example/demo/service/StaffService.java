package com.example.demo.service;


import com.example.demo.entities.SchoolMessage;
import com.example.demo.entities.Staff;
import com.example.demo.entities.User;
import com.example.demo.web.dto.StaffDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface StaffService extends UserDetailsService {

    void saveStaff(StaffDto staffDto);
    public Staff findUser(String username);
    public List<SchoolMessage> getMessagesAll();
}
