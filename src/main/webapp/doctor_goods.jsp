<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="doc_com.model.Goods" %>
<%@ page import="java.util.*" %>

<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>社区医院管理系统</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
                <script src="static/js/jquery.min.js"></script>
                <script src="static/js//bootstrap.min.js"></script>
                <link rel="stylesheet" href="static/css/index.css">
                <script src="static/js/jquery-3.6.1.min.js"></script>
     
   <script>
		function regFind(){
			document.form1.action="Doc_GoodsQueServlet";
			document.form1.submit();
		}
	</script>
		</head>
<body>
	<div class="nav-logo" style="cursor: pointer;">社区医院管理</div>
	<nav>
        <ol class="nav-bar" style="margin-left:50%;">
           <div class="top-bar top-right" style="width:40px;">物资</div>
        </ol>

        <ol class="nav-bar" style="margin-left: auto; margin-right:1.5rem">
            <li class="top-bar top-right"><span>医生</span>
                <!-- <ul class="drop-menu hidden" style="right:0;">
                    <li class="drop-item click-mgr">📰 账号管理</li>
                    <div class="line"></div>
                    <li class="drop-item click-signout">🔐 退出登录</li>
                </ul> -->
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
		    
		    <div class="row clearfix">
				<div class="col-md-12 column">
					<div class="form-group">
					<form class="form-horizontal" role="form" name="form1" method="post">
					<div class="form-group">
					 <label for="inputEmail36" class="col-sm-2 control-label">物资id</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail36" name="gname"/>
					</div>
				</div>
									
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" onclick="regFind();">查找物资</button>
				</div>
							
					<label>
                	<%
                	String state = (String) session.getAttribute("sta");
                		session.removeAttribute("sta");
                		if(state!=null){
                			out.print(state);
                		}
                	%>
                </label>
                </form>
				</div>
			</div>
			
		</div>	
			
			<table class="table">
				<thead>
					<tr>
						<th>
							物资id
						</th>
						<th>
							名称
						</th>
						<th>
							数量
						</th>
						<th>
							价格
						</th>
					</tr>
				</thead>
				<tbody>
				<%
							ArrayList list = (ArrayList) session.getAttribute("goodslist");
                			session.removeAttribute("goodslist");
                			if(list!=null){
                				for(int i=0;i<list.size();i++){
                					Goods temp = (Goods)list.get(i);
                		%>
                		<tr class="info">
							<td>
								<%=temp.getGid() %>
							</td>
							<td>
								<%=temp.getGname() %>
							</td>
							<td>
								<%=temp.getGnum() %>
							</td>
							<td>
								<%=temp.getGprice() %>
							</td>
						</tr>

                		<%
                				}
                			}
						%>
				</tbody>
			</table>
				
			
		</div>
			</div>
			</div>					
	</main>
</body>

</html>