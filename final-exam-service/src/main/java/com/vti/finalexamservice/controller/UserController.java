package com.vti.finalexamservice.controller;

import com.vti.finalexamservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping()
	public ResponseEntity getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getAllUsers());
	}
}
