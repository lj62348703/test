<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list }" var="user">
		${user.user_name }  -- ${user.user_pwd }  -- ${user.user_nick }
		<Br>
	</c:forEach>
</body>
</html>