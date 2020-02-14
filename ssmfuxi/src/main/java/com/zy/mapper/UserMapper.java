package com.zy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zy.entity.Userinfo;

public interface UserMapper {
	
	@Select("select * from userinfo where user_name = #{user_name} and user_pwd = #{user_pwd}")
	Userinfo login(Userinfo info);
	
	@Insert("insert into userinfo(user_name,user_pwd,user_nick) "
			+ "values(#{user_name},#{user_pwd},#{user_nick})")
	int reg(Userinfo info);
	
	@Select("select * from userinfo limit #{0},#{1}")
	List<Userinfo> findAllPage(int startRow,int pageSize);
	
	@Select("select * from userinfo")
	List<Userinfo> findAll();
}
