<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="adm_com.model.Loginfo" %>
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
        function regFind() {
            document.form1.action = "adm_LoginfoQueServlet";
            document.form1.submit();
        }
        function regFix() {
            document.form1.action = "adm_LoginfoFixServlet";
            document.form1.submit();
        }
        function regDel() {
            document.form1.action = "adm_LoginfoDelServlet";
            document.form1.submit();
        }
        function regAdd() {
            document.form1.action = "adm_LoginfoAddServlet";
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
                                    记录id
                                </th>
                                <th>
                                    登录人姓名
                                </th>
                                <th>
                                    登录时间
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% ArrayList list=(ArrayList) session.getAttribute("infolist");
                                session.removeAttribute("infolist"); if(list!=null){ for(int i=0;i<list.size();i++){
                                Loginfo temp=(Loginfo)list.get(i); %>

                                <tr class="warning">
                                    <td>
                                        <%=temp.getLid() %>
                                    </td>
                                    <td>
                                        <%=temp.getLname() %>
                                    </td>
                                    <td>
                                        <%=temp.getLtime() %>
                                    </td>
                                </tr>

                                <% } } %>
                        </tbody>
                    </table>
                    <br><br><br>
                    <form class="form-horizontal" role="form" name="form1" method="post">
                        <div class="form-group">
                            <label for="inputEmail31" class="col-sm-2 control-label">记录id</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="lid" name="lid" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail33" class="col-sm-2 control-label">登录人姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="lname" name="lname" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail34" class="col-sm-2 control-label">登录时间</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="ltime" name="ltime" />
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default" onclick="regAdd();">添加</button>
                                <button type="submit" class="btn btn-default" onclick="regDel();">删除</button>
                                <button type="submit" class="btn btn-default" onclick="regFix();">修改</button>
                                <button type="submit" class="btn btn-default" onclick="regFind()">查询</button>
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