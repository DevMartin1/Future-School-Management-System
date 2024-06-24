package com.example.demo.controller;

import com.example.demo.entities.Mark;
import com.example.demo.entities.Message;
import com.example.demo.entities.User;
import com.example.demo.service.MarkService;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.SchoolMsgDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {


    UserService userService ;
    MessageService messageService;

    MarkService markService;

    public HomeController(UserService userService, MessageService messageService,MarkService markService) {
        this.userService = userService;
        this.messageService = messageService;

        this.markService = markService;
    }

    @GetMapping("/announcements")
    public String cccc(Model model, Principal principle)
    {
        User user = userService.findUser(principle.getName());
        String grade = user.getGrade();

        List<Message> messages = messageService.getGradeMessages(grade);
        model.addAttribute("messages", messages);
        return "announcements";

    }
    @GetMapping("/myclass")
    public String getMyClass()
    {

        return "myclass";
    }
    @GetMapping("/contacts")
    public String getContacts()
    {

        return "contacts";

    }
    @GetMapping("/mark_page")
    public String getMarks(Model model, Principal principal)
    {
        User user = userService.findUser(principal.getName());
        String username = user.getUsername();
        List<Mark> marks = markService.getLearnerMarks(username);

        model.addAttribute("marks", marks);

        return "mark_page";
    }
    @GetMapping("/extra_curri")
    public String exCurri(@ModelAttribute SchoolMsgDto schoolMsgDto, Model model)
    {


        model.addAttribute("schoolMsgDto",schoolMsgDto);

        return "extra_curri";
    }
    @PostMapping("/extra_curri")
    public String getMsgSchool(@Valid @ModelAttribute("schoolMsgDto") SchoolMsgDto schoolMsgDto)
    {
        messageService.saveSchoolMsg(schoolMsgDto);

        return "redirect:/extra_curri?success";
    }


}

