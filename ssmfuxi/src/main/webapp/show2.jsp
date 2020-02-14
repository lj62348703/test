<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
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
		</tbody>
	</table>
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	
	<script type="text/javascript">
		$.post("showPage3.action",{"pageNum":2,"pageSize":5},function(result){
			var list = result.list;//获取用户集合
			$(list).each(function(){//this 就是从list中遍历到的每一个userinfo
				var tr = $("<tr></tr>");
				var td1 = $("<td>"+this.user_id+"</td>");
				var td2 = $("<td>"+this.user_name+"</td>")
				var td3 = $("<td>"+this.user_pwd+"</td>")
				var td4 = $("<td>"+this.user_nick+"</td>")
				tr.append(td1);  tr.append(td2);  tr.append(td3);  tr.append(td4);
				
				$("#users").append(tr);
			});
		},"json");
	</script>
</body>
</html>