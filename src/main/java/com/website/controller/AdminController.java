package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.exception.AdminNotFoundExecption;
import com.website.model.Admin;
import com.website.service.AdminService;

@RestController
@RequestMapping("/admin")
public final class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/save")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
		Admin admin1 = adminService.saveAdmin(admin);
		return ResponseEntity.ok(admin1);
	}

	@GetMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestParam String username,
											@RequestParam String password) {
		try {
			Admin admin = adminService.loginAdmin(username, password);
			return ResponseEntity.ok(admin);
		}catch(AdminNotFoundExecption e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
										
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		Admin admin1 = adminService.updateAdmin(admin);
		return ResponseEntity.ok(admin1);
	}
}
