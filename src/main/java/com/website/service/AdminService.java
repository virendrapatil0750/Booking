package com.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.website.exception.AdminNotFoundExecption;
import com.website.model.Admin;
import com.website.repository.AdminDao;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public Admin saveAdmin(Admin admin) {

		return adminDao.save(admin);
	}

	
	public Admin loginAdmin(String username, String password) {

		Admin admin = adminDao.findByusernameAndPassword(username, password);
		
		if (admin != null) {
			return admin;
		}else {
			throw new AdminNotFoundExecption("Admin with this username is not found "+username);
		}
	}


	public Admin updateAdmin(Admin admin) {
		
		if (admin.getId() == null) {
			throw new IllegalArgumentException("Id can not be null to update Admin");
		}
		
		Admin existingAdmin = adminDao.findById(admin.getId()).orElseThrow(() ->
		new AdminNotFoundExecption("Admin with Id " + admin.getId() + " not found"));
		
		
		existingAdmin.setName(admin.getName());
		existingAdmin.setUsername(admin.getUsername());
		existingAdmin.setPassword(admin.getPassword());
		existingAdmin.setEmail(admin.getEmail());
		
		
		return adminDao.save(existingAdmin);
	}


	public List<Admin> getAllAdmins() {
		
		return adminDao.findAll();
	}
}
