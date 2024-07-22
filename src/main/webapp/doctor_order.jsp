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
				function regFix(){
					document.form1.action="doc_OrderFixServlet";
					document.form1.submit();
				}
				function regDel(){
					document.form1.action="doc_OrderDelServlet";
					document.form1.submit();
				}
				function regAdd(){
					document.form1.action="doc_OrderAddServlet";
					document.form1.submit();
				}
		</script>
<body>
	<div class="nav-logo" style="cursor: pointer;">社区医院管理</div>
	<nav>
        <ol class="nav-bar" style="margin-left:50%;">
           <div class="top-bar top-right" style="width:40px;">订单</div>
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
			
			<table class="table">
				<thead>
					<tr>
						<th>
							订单id
						</th>
						<th>
							订单时间
						</th>
						<th>
							用户id
						</th>
						<th>
							诊断结果
						</th>
						<th>
							开药信息
						</th>
						<th>
							订单总价
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
								<%=temp.getOid() %>
							</td>
							<td>
								<%=temp.getOtime() %>
							</td>
							<td>
								<%=temp.getUid() %>
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

                		<%
                				}
                			}
						%>
        							
					
				</tbody>
			</table>
				</div>
			</div>
			
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form class="form-horizontal" role="form" name="form1" method="post">
						<div class="form-group">
							 <label for="inputEmail31" class="col-sm-2 control-label">订单id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="oid" name="oid" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail33" class="col-sm-2 control-label">订单时间</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="otime" name="otime"/>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail33" class="col-sm-2 control-label">用户id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="uid" name="uid"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail33" class="col-sm-2 control-label">诊疗结果</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="oresult" name="oresult"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail33" class="col-sm-2 control-label">开药信息</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="omedicine" name="omedicine"/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail34" class="col-sm-2 control-label">查诊费用</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="omoney" name="omoney"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default" onclick="regAdd();">添加订单</button>
								<button type="submit" class="btn btn-default" onclick="regDel();">删除订单</button>
								<button type="submit" class="btn btn-default" onclick="regFix();">修改订单</button>
								<button type="submit" class="btn btn-default" onclick="regFind();">查找订单</button>	
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
						</div>
					</form>
				</div>
			</div>
			
		</div>						
	</main>
</body>

</html>