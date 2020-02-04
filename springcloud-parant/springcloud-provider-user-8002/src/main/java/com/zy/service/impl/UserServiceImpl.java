package com.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.entity.Userinfo;
import com.zy.repository.UserRepository;
import com.zy.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Userinfo findById(Integer userid) {
		return userRepository.findById(userid).get();
	}

	@Override
	public List<Userinfo> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(Userinfo userinfo) {
		userRepository.save(userinfo);
	}
}
