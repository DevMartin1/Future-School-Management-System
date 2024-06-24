package com.example.demo.repository;

import com.example.demo.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    public Staff findByUsername(String username);
}
