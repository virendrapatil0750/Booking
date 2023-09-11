package com.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.model.Admin;
import com.website.respository.AdminDao;
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public Admin saveAdmin(Admin admin) {
		
		return adminDao.save(admin);
	}

}
