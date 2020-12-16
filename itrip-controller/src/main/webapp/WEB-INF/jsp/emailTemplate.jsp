<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>邮件模板</title>
</head>
<body>
您好，感谢您的注册，这是一封验证邮件，请点击下面的链接完成注册，感谢您的支持！
<a href="#" th:href="@{http://www.luohanye.com/register/{id}(id=${id})}">激活账号</a>
</body>
</html>