<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社区医院 | 用户登录</title>
	<style>
		body {
			background-color: #f2f2f2;
			background-image: url("https://img.zcool.cn/community/01911f5c7c8aa3a801213f26abdd9d.jpg@1280w_1l_2o_100sh.jpg");
            background-position: center 0;
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
	<form action="adm_DoctorLogServlet" method="post">
		<h2>登录</h2>
		<label for="username">用户账号</label>
		<input type="text" id="username" name="did" required placeholder="输入您的账号，需要为纯数字">
		<label for="password">用户密码</label>
		<input type="password" id="password" name="dpass" required placeholder="输入您的密码">
		<button type="submit">登录</button>
		<div class="register">
			还没有账号？ <a href="adm_register.jsp">点击注册</a>
		</div>
	</form>
</body>
</html>
