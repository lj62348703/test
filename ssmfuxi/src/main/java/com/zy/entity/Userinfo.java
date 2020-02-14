package com.zy.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Userinfo {
	private Integer user_id;
	
	//groups={LoginValidate.class,RegValidate.class}  标识在登录和注册的时候需要校验
	@NotNull(message="用户名不能为空",groups={LoginValidate.class,RegValidate.class})
	@Pattern(regexp="^.{3,12}$",message="用户名必须是3-12位",groups={LoginValidate.class,RegValidate.class})
	private String user_name;
	
	@NotNull(message="密码不能为空",groups={LoginValidate.class,RegValidate.class})
	@Pattern(regexp="^.{6,18}$",message="密码必须是6-18位",groups={LoginValidate.class,RegValidate.class})
	private String user_pwd;
	
	@NotNull(message="昵称不能为空",groups={RegValidate.class})
	@Pattern(regexp="^.{3,8}$",message="昵称必须是3-8位",groups={RegValidate.class})
	private String user_nick;
}
