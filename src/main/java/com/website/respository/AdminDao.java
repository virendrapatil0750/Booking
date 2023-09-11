package com.website.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.website.model.Admin;

@RestController
public interface AdminDao extends JpaRepository<Admin, Long>{

}
