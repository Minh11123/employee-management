package com.vti.finalexamservice.service.impl;


import com.vti.finalexamservice.config.sercurity.model.SysUserDetails;
import com.vti.finalexamservice.entity.UserEntity;
import com.vti.finalexamservice.repository.UserRepository;
import com.vti.finalexamservice.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<UserEntity> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public SysUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = repository.findByUsername(username);
		SysUserDetails sysUserDetails = new SysUserDetails();

		if (user.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		BeanUtils.copyProperties(user.get(), sysUserDetails);
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.get().getDepartment().getName()));

		sysUserDetails.setAuthorities(authorities);

		return sysUserDetails;
	}
}
