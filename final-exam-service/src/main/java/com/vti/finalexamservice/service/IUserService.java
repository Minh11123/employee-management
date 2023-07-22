package com.vti.finalexamservice.service;


import com.vti.finalexamservice.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

	List<UserEntity> getAllUsers();
}
