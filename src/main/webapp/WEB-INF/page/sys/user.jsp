<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anzy
  Date: 2017/12/1
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>anzy框架 - 主页</title>

    <meta name="keywords" content="我的框架">
    <meta name="description" content="anzy是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <c:import url="../comm/comm.jsp"></c:import>

</head>

<body style="background-color: #f5f5f5">
<div class="container body-content" style="width:98%;padding-top:20px;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form class="form-inline">
                <div class="row">
                    <div class="col-sm-2">
                        <label class="control-label">用户名：</label>
                        <input id="txtUsername" type="text" class="form-control">
                    </div>
                    <div class="col-sm-2">
                        <label class="control-label">登录名：</label>
                        <input id="txtLoginAccount" type="text" class="form-control">
                    </div>
                    <div class="col-sm-2">
                        <label class="control-label">邮箱：</label>
                        <input id="txtEmail" type="text" class="form-control">
                    </div>
                </div>

                <div class="row text-right" style="margin-top:20px;">
                    <div class="col-sm-12">
                        <input class="btn btn-primary" type="button" value="查询" onclick="searchData()">
                        <input class="btn btn-default" type="button" value="批量删除" onclick="btchDeleteBook()">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <table id="table"></table>
</div>
</body>
<script type="text/javascript" src="${ctx}/static/js/sys/user.js"></script>

</html>
