package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.website.model.Admin;
import com.website.service.AdminService;

@RestController
public final class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/save-admin")
	public Admin saveAdmin (@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}

}
