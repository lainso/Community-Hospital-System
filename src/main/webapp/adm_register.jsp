<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社区医院 | 用户注册</title>
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
	<form action="adm_DoctorAddServlet" method="post">
		<h2>注册</h2>
		<label for="did">用户账号</label>
		<input type="text" id="username" name="did" required placeholder="需要为纯数字">
		<label for="password">密码</label>
		<input type="password" id="password" name="dpass" required placeholder="输入您的密码">
		<label for="username">姓名</label>
		<input type="text" id="username" name="dname" required placeholder="输入您的真实姓名">
		<label for="username">性别</label>
		<input type="text" id="username" name="dsex" required placeholder="输入您的性别，例如：男">
		<label for="username">科室</label>
		<input type="text" id="username" name="droom" required placeholder="输入您的科室">
		<label for="username">联系电话</label>
		<input type="text" id="username" name="dtel" required placeholder="输入您的联系电话">
		<label for="username">职位</label>
		<input type="text" id="username" name="djob" required value="管理员">
		<button type="submit">注册</button>
		<div class="register">
			已经注册过了？ <a href="adm_login.jsp">点击登录</a>
		</div>
	</form>
	<label>
                	<%
                		String state = (String) session.getAttribute("sta");
                		session.removeAttribute("sta");
                		if(state!=null){
                			out.print(state);
                		}
                	%>
                </label>
</body>
</html>
