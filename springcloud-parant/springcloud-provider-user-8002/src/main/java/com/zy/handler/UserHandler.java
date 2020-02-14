package com.zy.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zy.entity.Userinfo;
import com.zy.service.IUserService;

@RestController
public class UserHandler {
	@Autowired
	private IUserService userServiceImpl;
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/user/get/{id}")
	public Userinfo findById(@PathVariable("id") Integer userid) {
		System.out.println("服务提供端------"+port+"------findById");
		return userServiceImpl.findById(userid);
	}

	@RequestMapping("/user/list")
	public List<Userinfo> findAll() {
		System.out.println("服务提供端-----"+port+"-------findAll");
		return userServiceImpl.findAll();
		
	}

	@RequestMapping("/user/add")
	public boolean save(@RequestBody Userinfo userinfo) {
		System.out.println("服务提供端-----"+port+"-------save");
		try{
			userServiceImpl.save(userinfo);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
