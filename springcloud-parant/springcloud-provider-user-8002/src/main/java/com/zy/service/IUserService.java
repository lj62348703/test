package com.zy.service;

import java.util.List;

import com.zy.entity.Userinfo;

public interface IUserService {
	Userinfo findById(Integer userid);
	
	List<Userinfo> findAll();
	
	void save(Userinfo userinfo);
}
