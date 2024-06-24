package com.example.demo.repository;

import com.example.demo.entities.SchoolMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolMsgRepo extends JpaRepository<SchoolMessage, Long> {


}
