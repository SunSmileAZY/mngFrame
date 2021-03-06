<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anzy
  Date: 2017/12/1
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
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

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">

  <!--左侧导航开始-->
  <jsp:include page="/login/left"/>
  <!--左侧导航结束-->
  <!--右侧部分开始-->
  <jsp:include page="/login/right"/>
  <!--右侧部分结束-->
  <!--右侧边栏开始-->
  <jsp:include page="/login/right2"/>
  <!--右侧边栏结束-->

  <div id="small-chat">
    <span class="badge badge-warning pull-right">5</span>
    <a class="open-small-chat">
      <i class="fa fa-comments"></i>

    </a>
  </div>
</div>

</body>

</html>
