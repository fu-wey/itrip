<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<form action="/user/login" method="post">
    用户名：<input type="text" id="username" name="username"/><br>
    密码：<input type="password" id="password" name="password"/><br>
    <input type="submit" value="登录">
</form>
</body>
</html>