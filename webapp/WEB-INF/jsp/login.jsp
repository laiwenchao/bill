<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2018/3/22
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/billdetail/login" method="post" accept-charset="UTF-8">
登录名: <input type="text" name="username"></br>
密  码: <input type="password" name="password"> </br>
<input type="submit" name="提交"></br>
</form>
</body>
</html>
