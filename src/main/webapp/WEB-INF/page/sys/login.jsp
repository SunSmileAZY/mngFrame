<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <c:import url="../comm/comm.jsp" ></c:import>
    <link rel="stylesheet" href="${ctx}/static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/css/sys/login.css" />
    <script type="text/javascript" src="${ctx}/static/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
<div class="main" style="display: block">
    <h3>
        <img src="${ctx}/static/img/login/logo.png">
    </h3>
    <div id="login_box" class="login-box">
        <input type="text" id="username" name="username">
        <input type="password" id="password" name="password">
        <p style="color: red">
            {{errorMsg}}<!-- 提示信息 -->
        </p>
        <P><c:out value="${message}"/></P>
        <button class="button1 button1-right" v-on:click="login">{{message}}</button>
        <button class="button1" v-on:click="reset">重置</button>
    </div>
</div>
<script type="text/javascript" src="${ctx}/static/js/sys/login.js"></script>
</body>
</html> 