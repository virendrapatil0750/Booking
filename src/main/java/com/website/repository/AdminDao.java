package com.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.website.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long>{

}
