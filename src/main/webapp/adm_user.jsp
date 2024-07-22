<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="adm_com.model.User" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
                <script src="static/js/jquery.min.js"></script>
                <script src="static/js//bootstrap.min.js"></script>
                <link rel="stylesheet" href="static/css/index.css">
                <script src="static/js/jquery-3.6.1.min.js"></script>
    <script>
        //修改
        function submit1() {
            document.form1.action = "adm_UserChaServlet"
            document.form1.submit();
        }
        //删除
        function submit2() {
            document.form1.action = "adm_UserDelServlet"
            document.form1.submit();
        }
        //查询
        function submit3() {
            document.form1.action = "adm_UserQueServlet"
            document.form1.submit();
        }
    </script>
</head>


<body>
    <div class="nav-logo" style="cursor: pointer;">社区医院管理</div>
    <nav>
        <ol class="nav-bar">
            <li class="click-pro"><span><a href="adm_user.jsp">用户信息</a></span></li>
            <li><span class="click-cus"> <a href="adm_doctor.jsp">医生信息</a></span></li>
            <li class="top-bar"><span><a href="adm_medicine.jsp">药品信息</a></span>
            </li>
            <li><span class="click-order"><a href="adm_order.jsp">订单</a></span></li>
            <li class="top-bar"><span><a href="adm_goods.jsp">物资</a></span>
            </li>
            <li><span><a href="adm_rest.jsp">请假信息</a></span></li>
            <li><span><a href="adm_loginfo.jsp">系统登录</a></span></li>
        </ol>

        <ol class="nav-bar" style="margin-left: auto; margin-right:1.5rem">
            <li class="top-bar top-right"><span>管理员</span>
            </li>
        </ol>
    </nav>

    <ul class="side-menu">
        <li class="menu-header" style="padding-top: 15px;">操作菜单 </li>
        <li class="menu-item click-pro"><a href="adm_user.jsp">用户</a></li>
        <li class="menu-item click-cus"><a href="adm_doctor.jsp">医生</a></li>
        <li class="menu-item openable side-bar"><a href="adm_medicine.jsp">药品</a>
        </li>
        <li class="menu-item click-order"><a href="adm_order.jsp">订单</a></li>
        <li class="menu-item openable side-bar"><a href="adm_goods.jsp">物资</a>
        </li>
        <li class="menu-item click-res"><a href="adm_rest.jsp">请假</a></li>
        <li class="menu-item click-log"><a href="adm_loginfo.jsp">登录信息</a></li>
        <li class="menu-item click-log"><a href="adm_login.jsp">退出登录</a></li>
    </ul>
    <main>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>
                                    用户名
                                </th>
                                <th>
                                    真实姓名
                                </th>
                                <th>
                                    密码
                                </th>
                                <th>
                                    性别
                                </th>
                                <th>
                                    年龄
                                </th>
                                <th>
                                    联系电话
                                </th>
                                <th>
                                    特殊情况
                                </th>
                                <th>
                                    备注
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% ArrayList usermess=(ArrayList) session.getAttribute("usermessage");
                                session.removeAttribute("usermessage"); if(usermess!=null){ for(int
                                i=0;i<usermess.size();i++){ User a=(User)usermess.get(i); %>

                                <tr class="warning">
                                    <td>
                                        <%=a.getUid() %>
                                    </td>
                                    <td>
                                        <%=a.getUname() %>
                                    </td>
                                    <td>
                                        <%=a.getUpass() %>
                                    </td>
                                    <td>
                                        <%=a.getUsex() %>
                                    </td>
                                    <td>
                                        <%=a.getUage() %>
                                    </td>
                                    <td>
                                        <%=a.getUtel() %>
                                    </td>
                                    <td>
                                        <%=a.getUcondition() %>
                                    </td>
                                    <td>
                                        <%=a.getUdescripe() %>
                                    </td>
                                </tr>

                                <% } } %>
                        </tbody>
                    </table>
                    <br><br><br>
                    <form class="form-horizontal" role="form" name="form1" method="post">
                        <div class="form-group">
                            <label for="inputEmail31" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail31" name="uid" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword32" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword32" name="upass" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail33" class="col-sm-2 control-label">真实姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail33" name="uname" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail34" class="col-sm-2 control-label">年龄</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail34" name="uage" />
                            </div>
                        </div>
                     
						<div id="gender">
						<label for="inputEmail34" class="col-sm-2 control-label">性别</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="usex" value="男">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="usex" value="女">女
						</div>
						<br>
                        <div class="form-group">
                            <label for="inputEmail35" class="col-sm-2 control-label">联系电话</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail35" name="utel" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail36" class="col-sm-2 control-label">特殊情况</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail36" name="ucondition" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail37" class="col-sm-2 control-label">备注</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail37" name="udescripe" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default" onClick=submit2()>删除</button>
                                <button type="submit" class="btn btn-default" onClick=submit1()>修改</button>
                                <button type="submit" class="btn btn-default" onClick=submit3()>查询</button>
                            </div>
                        </div>
                        <% String state=(String) session.getAttribute("ch"); session.removeAttribute("ch");
                            if(state!=null){ out.print(state); } %>
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>

</html>