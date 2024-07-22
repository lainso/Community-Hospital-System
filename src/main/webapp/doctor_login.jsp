<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社区医院 | 医生登录</title>
	<style>
		body {
			background-color: #f2f2f2;
		}
		form {
			margin: 50px auto;
			padding: 20px;
			width: 400px;
			background-color: white;
			border-radius: 5px;
		}
		h2 {
			text-align: center;
		}
		input[type=text], input[type=password] {
			width: 100%;
			padding: 12px 20px;
			margin: 8px 0;
			display: inline-block;
			border: 1px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
		}
		button {
			background-color: #4CAF50;
			color: white;
			padding: 14px 20px;
			margin: 8px 0;
			border: none;
			border-radius: 4px;
			cursor: pointer;
			width: 100%;
		}
		button:hover {
			background-color: #45a049;
		}
		.register {
			text-align: center;
		}
		a {
			color: #4CAF50;
		}
	</style>
	<script>
	function login(){
		document.form1.action="doc_DoctorLogServlet";
		document.form1.submit();
	}
		
	</script>
</head>
<body>
	
	<form method="post" name="form1">
		<h2>医生登录</h2>
		<label for="username">医生账号</label>
		<input type="text" id="username" name="did" required placeholder="输入您的账号，需要为纯数字">
		<label for="password">医生密码</label>
		<input type="password" id="password" name="dpass" required placeholder="输入您的密码">
		<button type="submit" onclick="login()">登录</button>
		
		
		<label>
                	<%
                	String state = (String) session.getAttribute("sta2");
                		session.removeAttribute("sta2");
                		if(state!=null){
                			out.print(state);
                		}
                	%>
        </label>
		
		<div class="register">
			还没有账号？ <a href="doctor_register.jsp">点击注册</a>
		</div>
	</form>
	
</body>
</html>
