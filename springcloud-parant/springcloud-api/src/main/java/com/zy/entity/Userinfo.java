package com.zy.entity;

import lombok.Data;

@Data
public class Userinfo {
	private Integer userId;
	
	private String userName;
	private String userPwd;
	private String userNick;
}
