<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <title>注册</title>
</head>
<body>
<form action="/user/register" method="post">
    用户名：<input type="text" id="username" name="username"/><br>
    密码：<input type="password" id="password" name="password"/><br>
    邮箱：<input type="email" id="email" name="email"/><br>
    <input type="submit" value="注册"/>
</form>
<a href="/user/loginPage">登录</a>
</body>
</html>