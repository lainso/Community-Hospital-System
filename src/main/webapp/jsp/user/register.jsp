<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社区医院 | 用户注册</title>
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
</head>
<body>
	<form action="../../use_UserRegServlet" method="post">
		<h2>注册</h2>
		<label for="uid">用户账号</label>
		<input type="text" id="uid" name="uid" required placeholder="输入您的账号，需要为纯数字">
		<label for="password">密码</label>
		<input type="password" id="password" name="upass" required placeholder="输入您的密码">
		<label for="uname">姓名</label>
		<input type="text" id="uname" name="uname" required placeholder="输入您的真实姓名">
		<label for="usex">性别</label>
		<input type="text" id="usex" name="usex" required placeholder="性别有时决定着治疗方案，请如实填写">
		<label for="uage">年龄</label>
		<input type="text" id="uage" name="uage" required placeholder="年龄有时决定着治疗方案，请如实填写">
		<label for="utel">联系电话</label>
		<input type="text" id="utel" name="utel" required placeholder="留下您的联系方式，我们将为您更好地服务">
		<button type="submit">注册</button>
		<div class="register">
			已经注册过了？ <a href="login.jsp">点击登录</a>
		</div>
	</form>
</body>
</html>
