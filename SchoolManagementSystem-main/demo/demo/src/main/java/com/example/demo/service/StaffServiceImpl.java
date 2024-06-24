package com.example.demo.service;

import com.example.demo.entities.Role;
import com.example.demo.entities.SchoolMessage;
import com.example.demo.entities.Staff;
import com.example.demo.entities.User;
import com.example.demo.repository.SchoolMsgRepo;
import com.example.demo.repository.StaffRepository;
import com.example.demo.web.dto.StaffDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{


    private StaffRepository staffRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    private SchoolMsgRepo schoolMsgRepo;

    public StaffServiceImpl(StaffRepository staffRepository, BCryptPasswordEncoder encoder, SchoolMsgRepo schoolMsgRepo) {
        this.staffRepository = staffRepository;
        this.encoder = encoder;
        this.schoolMsgRepo = schoolMsgRepo;
    }

    @Override
    public void saveStaff(StaffDto staffDto) {

        Staff staff = new Staff(staffDto.getName(), staffDto.getLast_name(),staffDto.getUsername(),staffDto.getGrade(), staffDto.getContact(), encoder.encode(staffDto.getPassword()), Arrays.asList(new Role("ADMIN")), staffDto.getPicture());
        staffRepository.save(staff);

    }

    @Override
    public Staff findUser(String username)
    {
        return staffRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Staff staff = staffRepository.findByUsername(username);

        if (staff== null)
        {
            throw new UsernameNotFoundException("Error 404");
        }else{
            return new CustomStaffUserDetails(staff);
        }

    }

    public List<SchoolMessage> getMessagesAll()
    {
        List<SchoolMessage> messages = schoolMsgRepo.findAll();

        return messages;
    }
}
