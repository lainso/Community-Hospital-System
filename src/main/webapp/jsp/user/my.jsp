<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="use_com.model.User" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.NumberFormat" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
                <script src="../../static/js/jquery.min.js"></script>
                <script src="../../static/js/bootstrap.min.js"></script>
                <link rel="stylesheet" href="../../static/css/index.css">
                <script src="../../static/js/jquery-3.6.1.min.js"></script>
                <title>社区医院 | 用户首页</title>
                <style>
                    .container {
                        width: 85%;
                        justify-content: center;
                        text-align: center;
                    }
					.my-main-list {
						padding-top: 5%;
						display: flex;
						flex-direction: column;
						justify-content: center;
						align-items: center;
						gap: 1rem;
					}
					.my-main-list-item {
						border: 1px solid blue;
						padding: 0 1.2rem;
						width: 40%;
						position: relative;
						min-width: 370px;
					}
                </style>
                <script>
				function Regfix() {
						document.form1.action = "../../use_UserChaServlet"
						document.form1.submit();
					}
                    document.querySelector("#exit").addEventListener("click",()=>{
						location.href="login.jsp";
					})

				//删除
				function submit2(){
					document.form2.action = "../../use_UserDelServlet"
					document.form2.submit();
				}

				//获取
				function submit3(){
					document.form3.action = "../../use_UserQueServlet"
					document.form3.submit();
				}

                </script>
            </head>

            <body>
                <div class="nav-logo">社区医院系统</div>
                <nav>
                    <ol class="nav-bar">
                        <li class="click-pro" style="margin-left: 2rem;"><a href="index.jsp">历史订单</a></li>
                        <li class="click-pro" style="margin-left: 2rem;"><a href="my.jsp">个人中心</a></li>
                    </ol>
                </nav>
                <ul class="side-menu">
                    <br>
                    <li class="menu-item click-pro"><a href="index.jsp">历史订单</a></li>
                    <li class="menu-item click-pro"><a href="my.jsp">个人中心</a></li>
                    <br><br><br>
                    <li class="menu-item click-pro"><a href="login.jsp">退出登录</a></li>
                </ul>
                <main>
					<br>
					<h2 style="margin-left: 37%">欢迎使用社区医院系统！</h2>
                    <div class="container">
						<div class="my-main-list">
							<% String uid=(String)session.getAttribute("uid");%>
							<div class='my-main-list-item'>
								<div>
									<%
										ArrayList usermess = (ArrayList) session.getAttribute("usermessage");
										session.removeAttribute("usermessage");
										if(usermess!=null){
											User a =(User)usermess.get(0);
									%>
								</div>
								<form class="form-horizontal" role="form" name="form1" method="post"><br>
									<div class="form-group" style="display:none">
										<label for="uid" class="col-sm-2 control-label">账号</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="uid" name="uid" value="<%=uid %>"/>
										</div>
									</div>
									<div class="form-group">
										<label for="uid" class="col-sm-2 control-label">账号</label>
										<div class="col-sm-10">
											<input type="text" disabled class="form-control" id="uid5" name="uid5" value="<%=uid %>"/>
										</div>
									</div>
									<div class="form-group">
										<label for="uname" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="uname" name="uname" value="<%=a.getUname() %>"/>
										</div>
									</div>
									<div class="form-group">
										<label for="upass" class="col-sm-2 control-label">密码</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="upass" name="upass" value="<%=a.getUpass() %>"/>
										</div>
									</div>
									<div class="form-group">
										<label for="usex" class="col-sm-2 control-label">性别</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="usex" name="usex" value="<%=a.getUsex() %>"/>
										</div>
									</div>
									<div class="form-group">
										<label for="uage" class="col-sm-2 control-label">年龄</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="uage" name="uage" value="<%=a.getUage() %>"/>
										</div>
									</div>
									<div class="form-group">
										<label for="utel" class="col-sm-2 control-label">电话</label>
										<div class="col-sm-10">
											<% 
											double aa = a.getUtel();
											NumberFormat nf = NumberFormat.getIntegerInstance();
											String b = nf.format(aa);
											%>
											<input type="text" class="form-control" id="utel" name="utel" value="<%=b %>"/>
										</div>
									</div>
									<div class="form-group" style="display:none">
										<label for="inputEmail36" class="col-sm-2 control-label">特殊</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputEmail36" name="ucondition" value="<%=a.getUcondition() %>"/>
										</div>
									</div>
									<div class="form-group" style="display:none">
										<label for="inputEmail37" class="col-sm-2 control-label">备注</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputEmail37" name="udescripe" value="<%=a.getUdescripe() %>"/>
										</div>
									</div>
									<% } %>
									<br>
									<button type="submit" class="btn btn-default" onclick="Regfix();" id="getbtn"
											style="background-color: #f8f38e; margin-right: 1.5rem">修改个人信息</button>
								</form>

								<form class="form-horizontal" role="form" name="form3" method="post">
									<div class="form-group">
										<label></label>
										<input type="text" style="display: none" id="fixbtn" name="uid3" value="<%=uid %>"/>
										<br><button style="background-color: lightgreen; margin-right: 1.5rem" type="submit" class="btn btn-default" onclick="submit3();">加载用户信息</button>
									</div>
								</form>

								<form class="form-horizontal" role="form" name="form2" method="post">
									<div class="form-group">
										<label></label>
										<input type="text" class="form-control" id="inputEmail38" name="uid2" value="<%=uid %>" style="display:none;"/>
										<button type="submit" class="btn btn-default" onclick="submit2();" style="background-color: #ef405d; margin-right: 1.5rem">永久删除账户</button><br>
									</div>
								</form>

							</div>
						</div>
                    </div>
                </main>
            </body>

            </html>