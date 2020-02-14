<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/vue.min.js"></script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>用户id</th>
				<th>用户名</th>
				<th>密码</th>
				<th>昵称</th>
			</tr>
		</thead>
		<tbody id="users">
			<tr v-for="user in list">
				<td>{{user.user_id}}</td>
				<td>{{user.user_name}}</td>
				<td>{{user.user_pwd}}</td>
				<td>{{user.user_nick}}</td>
			</tr>
		</tbody>
	</table>
	
	
	<script type="text/javascript">
		$.post("showPage3.action",{"pageNum":1,"pageSize":10},function(result){
			vue.list = result.list;//将返回结果中的用户列表赋值给  vue.list
		},"json");
		
		var vue = new Vue({
			el:"#users",//指定在id为users的元素内使用vue
			data:{
				list:[]//用来存放用户的集合
			}
		});
	</script>
</body>
</html>