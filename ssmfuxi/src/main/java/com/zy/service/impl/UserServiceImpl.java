package com.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.entity.Userinfo;
import com.zy.mapper.UserMapper;
import com.zy.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public Userinfo login(Userinfo info){
		return userMapper.login(info);
	}

	@Override
	public int reg(Userinfo info) {
		return userMapper.reg(info);
	}

	@Override
	public List<Userinfo> findAllPage(int startRow, int pageSize) {
		return userMapper.findAllPage(startRow, pageSize);
	}
	
	//返回的pageinfo 不仅有分页的数据  还有页码相关的数据
	public PageInfo<Userinfo> findAll(Integer pageNum, Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 10 : pageSize;
		//配置分页插件  startPage(页码,每页显示的条数)
		PageHelper.startPage(pageNum, pageSize);
		//执行查询获取结果，使用用分页插件之后 不会再去执行原来的查询
		//而是会将原来的查询语句分成两部分执行  第一部分 先查询总共有多少条数据  第二部分去进行分页查询
		List<Userinfo> list = userMapper.findAll();
		PageInfo<Userinfo> pageinfo = new PageInfo<Userinfo>(list);
		return pageinfo;
	}
}
