<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import="doc_com.model.Medicine" %>
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
//查询
function submit4(){
document.form1.action = "Doc_MedicineQueServlet"
document.form1.submit();
}

</script>
</head>
<body>
	<div class="nav-logo" style="cursor: pointer;">社区医院管理</div>
	<nav>
        <ol class="nav-bar" style="margin-left:50%;">
           <div class="top-bar top-right" style="width:40px;">药品</div>
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
		    
			<form class="form-horizontal" role="form" name="form1" method="post">
				<div class="form-group">
					 <label for="inputEmail39" class="col-sm-2 control-label">药品名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail39" name="mname"/>
					</div>
					</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default" id="a" onClick=submit4()>查询药品信息</button>
					</div>
				</div>
					<%
                	String state = (String) session.getAttribute("ch");
                		session.removeAttribute("ch");
                		if(state!=null){
                			out.print(state);
                		}
                	%>
			</form>
			
			<table class="table">
				<thead>
					<tr>
						<th>
							药品id
						</th>
						<th>
							药品名
						</th>
						<th>
							药品价格
						</th>
						<th>
							药品库存
						</th>
						<th>
							药品有效期
						</th>
					</tr>
				</thead>
				<tbody>
				
				<%
				ArrayList usermess = (ArrayList) session.getAttribute("usermessage");
        		session.removeAttribute("usermessage");
        		if(usermess!=null){
        			for(int i=0;i<usermess.size();i++){
        				Medicine a =(Medicine)usermess.get(i);
      			
        			%>
     		
        			<tr class="warning">
						<td>
							<%=a.getMid() %>
						</td>
						<td>
							<%=a.getMname() %>
						</td>
						<td>
							<%=a.getMprice() %>
						</td>
						<td>
							<%=a.getMnum() %>
						</td>
						<td>
							<%=a.getMdate() %>
						</td>
					</tr>
        			
        	    <% 
        			}
        		}	%>
        							
					
				</tbody>
			</table>
				</div>
			</div>
		</div>						
	</main>
</body>

</html>