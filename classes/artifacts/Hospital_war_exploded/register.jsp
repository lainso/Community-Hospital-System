<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <title>注册</title>
        <link rel="stylesheet" type="text/css" href="./static/login.css">
    </head>

    <body>
        <div id="login">
            <h1>注册</h1>
            <form method="post" action="RegistServlet">
                <input type="text" required="required" placeholder="用户名" name="u"></input>
                <input type="password" required="required" placeholder="密码" name="p"></input>
                <button class="but" type="submit">注册</button>
                <label for="password">返回登录
                    <a href="login.jsp" style="color:blue">点这里</a>
                </label>
            </form>
        </div>
    </body>

    </html>