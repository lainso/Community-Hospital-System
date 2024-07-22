<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ page import="adm_com.model.Doctor" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="static/css/bootstrap.min.css" rel="stylesheet">
                <script src="static/js/jquery.min.js"></script>
                <script src="static/js//bootstrap.min.js"></script>
                <link rel="stylesheet" href="static/css/index.css">
                <script src="static/js/jquery-3.6.1.min.js"></script>
    <script>
        function regFix() {
            document.form1.action = "adm_DoctorFixServlet";
            document.form1.submit();
        }
        function regDel() {
            document.form1.action = "adm_DoctorDelServlet";
            document.form1.submit();
        }
        function regQue() {
            document.form1.action = "adm_DoctorQueServlet";
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
                                    账号
                                </th>
                                <th>
                                    密码
                                </th>
                                <th>
                                    姓名
                                </th>
                                <th>
                                    性别
                                </th>
                                <th>
                                    科室
                                </th>
                                <th>
                                    联系方式
                                </th>
                                <th>
                                    职位
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% ArrayList list=(ArrayList) session.getAttribute("doctorlist");
                                session.removeAttribute("doctorlist"); if(list!=null){ for(int i=0;i<list.size();i++){
                                Doctor temp=(Doctor)list.get(i); %>

                                <tr class="warning">
                                    <td>
                                        <%=temp.getDid() %>
                                    </td>
                                    <td>
                                        <%=temp.getDpass() %>
                                    </td>
                                    <td>
                                        <%=temp.getDname() %>
                                    </td>
                                    <td>
                                        <%=temp.getDsex() %>
                                    </td>
                                    <td>
                                        <%=temp.getDroom() %>
                                    </td>
                                    <td>
                                        <%=temp.getDtel() %>
                                    </td>
                                    <td>
                                        <%=temp.getDjob() %>
                                    </td>
                                </tr>

                                <% } } %>
                        </tbody>
                    </table>

                    <br><br><br>
                    <form class="form-horizontal" role="form" name="form1" method="post">
                        <div class="form-group">
                            <label for="inputEmail31" class="col-sm-2 control-label">账号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="did" name="did" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword32" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="dpass" name="dpass" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail33" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="dname" name="dname" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail34" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="dsex" name="dsex" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail35" class="col-sm-2 control-label">科室</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="droom" name="droom" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail36" class="col-sm-2 control-label">联系方式</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="dtel" name="dtel" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail37" class="col-sm-2 control-label">职位</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="djob" name="djob" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default" onclick="regDel();">删除</button>
                                <button type="submit" class="btn btn-default" onclick="regFix();">修改</button>
                                <button type="submit" class="btn btn-default" onclick="regQue();">查询</button>
                            </div>
                            <label>
                                <% String state=(String) session.getAttribute("sta"); session.removeAttribute("sta");
                                    if(state!=null){ out.print(state); } %>
                            </label>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>

</html>