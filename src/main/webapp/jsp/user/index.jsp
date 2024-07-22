<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="use_com.model.Order" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../static/js/jquery.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <title>社区医院 | 用户首页</title>
    <link rel="stylesheet" href="../../static/css/index.css">
    <script src="../../static/js/jquery-3.6.1.min.js"></script>
    <style>
        .container{
            width:85%;
            justify-content: center;
            text-align: center;
        }
    </style>
    <script>
		function regFind(){
			document.form1.action="../../use_OrderQueServlet";
			document.form1.submit();
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
	<div class="container">
	<br><br>
				<div class="row clearfix">
				<div class="col-md-12 column">
					<% String uid = (String)session.getAttribute("uid");%>
					<form class="form-horizontal" role="form" name="form1" method="post">
					<input type="text" id="oid" name="uid" value="<%=uid%>" style="display:none"/>
					<button type="submit" class="btn btn-default" onclick="regFind();" style="background-color: lightgreen;">查找订单</button>
					</form>
				</div>
			</div><br>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table">
						<thead>
							<tr>
								<th>
									时间
								</th>
								<th>
									诊断结果
								</th>
								<th>
									开药信息
								</th>
								<th>
									总价
								</th>
							</tr>
						</thead>
						<tbody>
						<%
							ArrayList list = (ArrayList) session.getAttribute("orderlist");
                			session.removeAttribute("orderlist");
                			if(list!=null){
                				for(int i=0;i<list.size();i++){
                					Order temp = (Order)list.get(i);
                		%>
                		<tr class="info">
							<td>
								<%=temp.getOtime() %>
							</td>
							<td>
								<%=temp.getOresult() %>
							</td>
							<td>
								<%=temp.getOmedicine() %>
							</td>
							<td>
								<%=temp.getOmoney() %>
							</td>
						</tr>
                		<% }} %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
    </main>
</body>

</html>