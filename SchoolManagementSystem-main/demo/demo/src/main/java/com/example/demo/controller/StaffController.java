package com.example.demo.controller;


import com.example.demo.config.StorageProperty;
import com.example.demo.entities.SchoolMessage;
import com.example.demo.entities.Staff;
import com.example.demo.entities.User;
import com.example.demo.service.MarkService;
import com.example.demo.service.MessageService;
import com.example.demo.service.StaffService;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.MarkDto;
import com.example.demo.web.dto.MessageDto;
import com.example.demo.web.dto.StaffDto;
import com.example.demo.web.dto.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class StaffController {

    private StaffService staffService;
    private MessageService messageService;
    private UserService userService;
    private MarkService markService;
    private Path uploadsLocation;

    public StaffController(StaffService staffService,MessageService messageService, UserService userService, MarkService markService, StorageProperty storageProperty) {
        this.staffService = staffService;
        this.messageService = messageService;
        this.userService = userService;
        this.markService = markService;
        this.uploadsLocation = Paths.get(storageProperty.getUploadsLocation());
    }



    @GetMapping("/admin_dashboard")
    public String dashboard(Principal principal ,Model model)
    {



        User user = userService.findUser(principal.getName());
        String name =  user.getUsername();


        model.addAttribute("user", user);
        model.addAttribute("name", name);
        return "admin_dashboard";
    }
    @GetMapping("/announce")
    public String setAnnounce(@ModelAttribute MessageDto messageDto, Model model)
    {

        model.addAttribute("messageDto", messageDto);

        return "announce";
    }
    @PostMapping("/announce")
    public String getAnnouncement(@Valid @ModelAttribute("messageDto") MessageDto messageDto, Principal principal)
    {


        User user = userService.findUser(principal.getName());
        messageDto.setPosted_by(user.getUser_name());

        messageService.saveMessage(messageDto);

        return "redirect:/announce?success";

    }

    //Empty MarkDto object
    @GetMapping("/marks_upload")
    public String marks(@ModelAttribute MarkDto markDto, Model model)
    {
        model.addAttribute("mark", markDto);
        return "marks_upload";
    }
    @GetMapping("/viewMessages")
    public String viewMessages(Model model)
    {

        List<SchoolMessage> messages = staffService.getMessagesAll();
        model.addAttribute("messages",messages);

        return "viewMessages";

    }

    //Getting the values that the admin entered
    @PostMapping("/marks_upload")
    public String getMarks(@Valid @ModelAttribute("markDto") MarkDto markDto)
    {

        markService.public_marks(markDto);

        return "redirect:/marks_upload?success";
    }

    @GetMapping("/addExam")
    public String markexams()
    {
        return "addExam";
    }


    @GetMapping("/addteacher")
    public String teacher(@ModelAttribute StaffDto staffDto, Model model)
    {


        model.addAttribute("staff",staffDto);


        return "addteacher";

    }


    @PostMapping("/addteacher")
    public String addTeacher(@Valid @ModelAttribute("staff") StaffDto staffDto, RedirectAttributes redirectAttributes, @RequestParam("file")MultipartFile multipartFile) throws IOException
    {

        String imageName = multipartFile.getOriginalFilename();

        staffDto.setPicture(imageName);

        staffService.saveStaff(staffDto);
        User saved = userService.save(new UserRegistrationDto(staffDto.getName(), staffDto.getUsername(), staffDto.getPassword(), staffDto.getGrade(), new Date()), "ADMIN");

        String savedID = String.valueOf(saved.getId());
        Path newPath = uploadsLocation.resolve(savedID);
        if(!Files.exists(newPath)){
            try {
                Files.createDirectories(newPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Path destination = newPath.resolve(Paths.get(Objects.requireNonNull(imageName))).normalize().toAbsolutePath();
        try (InputStream inputStream = multipartFile.getInputStream()){
            Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/addteacher?success";
    }
}
