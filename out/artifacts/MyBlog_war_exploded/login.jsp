<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/7/27
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <title>登录</title>
    <script type="text/javascript">
        function reLoad() {
            $("#verifyCode").attr("src","verificode?time"+(new Date().getTime()));
        }
    </script>
</head>
<body>
<h2>登录</h2>
<form action="login" method="post">
    I&nbsp;&nbsp;D：<input type="text" name="uid"><br>
    密码:<input type="password" name="password"><br>
    验证码：<input type="text" name="verificode"><a href="javascript:reLoad();"><img id="verifyCode" src="verificode"></a><br>
    <input type="submit" value="登录"><input type="reset" value="重置">
</form>
</body>
</html>
