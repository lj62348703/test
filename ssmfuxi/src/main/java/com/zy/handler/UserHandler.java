package com.zy.handler;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zy.entity.LoginValidate;
import com.zy.entity.RegValidate;
import com.zy.entity.Userinfo;
import com.zy.service.IUserService;

@Controller
public class UserHandler {
	@Autowired
	private IUserService userServiceImpl;
	
	//Validated 让spring 调用验证规则验证info是否符合定义的规则
	//BindingResult 如果前面的一个属性被验证有错误的话  错误的结果会绑定到BindingResult
	@RequestMapping("/login.action")
	public String login(@Validated(value=LoginValidate.class) Userinfo info,BindingResult br,Model model,HttpSession session){
		if(br.hasErrors()){
			//如果验证有错误
			List<FieldError> errors =  br.getFieldErrors();
			HashMap<String,String> map = new HashMap<String,String>();
			//遍历错误列表
			for(FieldError error : errors){
				//      user_name         用户名不能为空
				map.put(error.getField(), error.getDefaultMessage());
			}
			//request.setAttribute();
			model.addAttribute("errorMap", map);
			return "login.jsp";//转发到登录页面
		}else{//没有错误的情况下才去连接数据库进行登录判断
			Userinfo userinfo = userServiceImpl.login(info);
			if(userinfo == null){
				model.addAttribute("msg", "用户名或密码错误");
				//登录不成功
				return "login.jsp";//转发到登录页面
			}else{
				session.setAttribute("userinfo", userinfo);
				//登录成功
				return "redirect:index.jsp";//转发到首页
			}
		}
	}
	
	@RequestMapping("/reg.action")
	public String reg(@Validated(value=RegValidate.class) Userinfo info,
			BindingResult br,Model model){
		if(br.hasErrors()){
			//如果验证有错误
			List<FieldError> errors =  br.getFieldErrors();
			HashMap<String,String> map = new HashMap<String,String>();
			//遍历错误列表
			for(FieldError error : errors){
				//      user_name         用户名不能为空
				map.put(error.getField(), error.getDefaultMessage());
			}
			//request.setAttribute();
			model.addAttribute("errorMap", map);
			return "reg.jsp";//转发到登录页面
		}else{
			int num = userServiceImpl.reg(info);
			if(num == 1){
				//注册成功
				return "index.jsp";
			}else{
				model.addAttribute("msg","注册失败");
				return "reg.jsp";
			}
		}
	}
	
	@RequestMapping("/showPage.action")
	public String findAllPage(Integer startRow,Integer pageSize,Model model){
		startRow = startRow == null ? 0 : startRow;
		pageSize = pageSize == null ? 10 : pageSize;
		List<Userinfo> list = userServiceImpl.findAllPage(startRow, pageSize);
		model.addAttribute("list",list);
		return "show.jsp";
	}
	
	@RequestMapping("/showPage2.action")
	public String findAllPage2(Integer pageNum,Integer pageSize,Model model){
		PageInfo<Userinfo> pageinfo = userServiceImpl.findAll(pageNum, pageSize);
		model.addAttribute("list",pageinfo.getList());//当前分页信息
		model.addAttribute("pages",pageinfo.getPages());//总页数
		model.addAttribute("total",pageinfo.getTotal());//总行数
		return "show.jsp";
	}
	
	
	//ResponseBody  把返回值  作为响应内容响应出去，如果这个返回值是一个对象 ，自动转换为json格式
	// JsonArray arr = new JsonArray(list);
	// response.getWriter().print(arr);
	@RequestMapping("/showPage3.action")
	@ResponseBody
	public PageInfo<Userinfo> findAllPage3(Integer pageNum,Integer pageSize,Model model){
		return userServiceImpl.findAll(pageNum, pageSize);
	}
}
