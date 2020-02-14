<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	${msg}
	<form action="login.action"  method="post">
		<input name="user_name">  <span>${errorMap.user_name }</span>  <br>
		<input name="user_pwd">  <span>${errorMap.user_pwd }</span>   <br>
		<button>登录</button> 
	</form>
</body>
</html>