<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>

    <link rel="stylesheet" href="${ctx}/static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/css/sys/login.css" />
    <script type="text/javascript" src="${ctx}/static/js/sys/login.js"></script>
    <script type="text/javascript" src="${ctx}/static/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>

<div class="main" style="display: block">
    <h3>
        <img src="${ctx}/static/img/login/logo.png">
    </h3>
    <div class="login-box">
        <input type="text" id="username" name="username">
        <input type="password" id="password" name="password">
        <p id="error_msg">
            <!-- 提示信息 -->
        </p>
        <button id="a_login" class="button1 button1-right">登录</button>
        <button id="a_reset" class="button1">重置</button>
    </div>
</div>
</body>
</html> 