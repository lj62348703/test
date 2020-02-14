package com.zy.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zy.entity.Userinfo;

public interface IUserService {
	Userinfo login(Userinfo info);
	
	int reg(Userinfo info);
	
	List<Userinfo> findAllPage(int startRow,int pageSize);
	
	PageInfo<Userinfo> findAll(Integer pageNum, Integer pageSize);
}
