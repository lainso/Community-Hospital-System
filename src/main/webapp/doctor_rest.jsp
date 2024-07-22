<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="doc_com.model.Rest" %>
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
//添加
function submit1(){
document.form1.action = "doc_RestAddServlet"
document.form1.submit();	
}
//修改
function submit2(){
document.form1.action = "doc_RestFixServlet"
document.form1.submit();	
}
//删除
function submit3(){
document.form1.action = "doc_RestDelServlet"
document.form1.submit();	
}
//查询
function submit4(){
document.form1.action = "doc_RestQueServlet"
document.form1.submit();	
}
</script>
</head>
<body>
	<div class="nav-logo" style="cursor: pointer;">社区医院管理</div>
	<nav>
        <ol class="nav-bar" style="margin-left:50%;">
           <div class="top-bar top-right" style="width:40px;">请假</div>
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
			
			<table class="table">
				<thead>
					<tr>
						<th>
							请假id
						</th>
						<th>
							请假原因
						</th>
						<th>
							开始时间
						</th>
						<th>
							结束时间
						</th>
						<th>
							审批状态
						</th>
					</tr>
				</thead>
				<tbody>
				
				<%
				ArrayList usermess = (ArrayList) session.getAttribute("usermessage");
        		session.removeAttribute("usermessage");
        		if(usermess!=null){
        			for(int i=0;i<usermess.size();i++){
        				Rest a =(Rest)usermess.get(i);
        			%>
     		
        			<tr class="warning">
						<td>
							<%=a.getRid() %>
						</td>
						<td>
							<%=a.getRreason() %>
						</td>
						<td>
							<%=a.getRstart() %>
						</td>
						<td>
							<%=a.getRend() %>
						</td>
						<td>
							<%=a.getRcondition() %>
						</td>
					</tr>
        			
        	    <% 
        			}
        		}	%>
        			
	
					
					
				</tbody>
			</table>
				</div>
			</div>
			
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form class="form-horizontal" role="form" name="form1" method="post">
				<div class="form-group">
					 <label for="inputEmail31" class="col-sm-2 control-label" >请假id</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail31" name="rid"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputEmail34" class="col-sm-2 control-label">请假原因</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail34" name="rreason"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputEmail35" class="col-sm-2 control-label">开始时间</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail35" name="rstart"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputEmail36" class="col-sm-2 control-label">结束时间</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail36" name="rend"/>
					</div>
				</div>
				<div class="form-group" style="display:none">
					 <label for="inputEmail36" class="col-sm-2 control-label">审批状态</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail36" name="rcondition" value="0"/>
					</div>
				</div>
							
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default" onClick=submit1()>添加请假信息</button>
						 <button type="submit" class="btn btn-default" onClick=submit3()>删除请假信息</button>
						 <button type="submit" class="btn btn-default" onClick=submit2()>修改请假信息</button>						 
						 <button type="submit" class="btn btn-default" onClick=submit4()>查询请假信息</button>
					</div>
				</div>		
				<table>
				<%
                	String state = (String) session.getAttribute("ch");
                		session.removeAttribute("ch");
                		if(state!=null){
                			out.print(state);
                		}
                	%>
				</table>
			
			</form>
				</div>
			</div>
			
		</div>						
	</main>
</body>

</html>