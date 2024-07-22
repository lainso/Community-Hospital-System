<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="doc_com.model.Order" %>
<%@ page import="java.util.*" %>

<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>社区医院管理系统</title>
                <link href="static/css/bootstrap.min.css" rel="stylesheet">
                <script src="static/js/jquery.min.js"></script>
                <script src="static/js//bootstrap.min.js"></script>
                <link rel="stylesheet" href="static/css/index.css">
                <script src="static/js/jquery-3.6.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
   <script>
				function regFind(){
					document.form1.action="doc_OrderQueServlet";
					document.form1.submit();
				}
				 
				
				 
   </script>



<body>
	<div class="nav-logo" style="cursor: pointer;">社区医院管理</div>
	<nav>
        <ol class="nav-bar" style="margin-left:50%;">
           <div class="top-bar top-right" style="width:40px;">主菜单</div>
        </ol>

        <ol class="nav-bar" style="margin-left: auto; margin-right:1.5rem">
            <li class="top-bar top-right"><span>医生</span>
            </li>
        </ol>
    </nav>
			<ul class="side-menu">
		        <li class="menu-header" style="padding-top: 15px;">菜单 </li>
		        <li class="menu-item openable side-bar"><a href="doctor_index.jsp">主界面</a>
		        </li>
		        <li class="menu-item openable side-bar"><a href="doctor_medicine.jsp">药品</a>
		        </li>
		        <li class="menu-item click-order"><a href="doctor_order.jsp">订单</a></li>
		        <li class="menu-item openable side-bar"><a href="doctor_goods.jsp">物资</a>
		        </li>
		        <li class="menu-item click-res"><a href="doctor_rest.jsp">请假</a></li>
		        <li class="menu-item click-log"><a href="doctor_login.jsp">退出登录 </a></li>
		        </ul>
	<main>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
		    <br><br><br>
	           <h1>欢迎进入社区医院管理系统</h1>
				</div>
			</div>
			
			
		</div>						
	</main>
</body>

</html>