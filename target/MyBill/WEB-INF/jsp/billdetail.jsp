<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2018/3/18
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/billdetail/billdetailsuccess" method="post" accept-charset="UTF-8">
    用户ID: <input type="text" name="user_id"></br>
    商品名: <input type="text" name="puduct_name"></br>
    描述: <input type="text" name="description"></br>
    花费: <input type="text" name="pay"></br>
    消费时间: <input type="text" name="pay_time"></br>
    <input type="submit" name="提交"></br>
</form>
</body>
</html>
