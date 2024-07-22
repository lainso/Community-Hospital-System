<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <title>登录</title>
        <link rel="stylesheet" type="text/css" href="./static/login.css">
    </head>

    <body>
        <div id="login">
            <h1>登录</h1>
            <form method="post">
                <input type="text" required="required" placeholder="用户名" name="u"></input>
                <input type="password" required="required" placeholder="密码" name="p"></input>
                <button class="but" type="submit">登录</button>
                <label for="password">注册
                    <a href="register.jsp" style="color:blue">点这里</a>
                </label>
            </form>
        </div>
    </body>

    </html>