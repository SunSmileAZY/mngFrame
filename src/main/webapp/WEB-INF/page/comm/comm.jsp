<%--
  Created by IntelliJ IDEA.
  User: anzy
  Date: 2017/12/16
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
  var ctxPath = "${ctx}";
</script>
<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/plugin/bootstrap-table/css/bootstrap-table.min.css">


<script type="text/javascript" src="${ctx}/static/plugin/vue.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugin/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugin/vue-resource.js"></script>
<script type="text/javascript" src="${ctx}/static/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugin/bootstrap-table/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${ctx}/static/plugin/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- 20180314新加模板加入   anzy  -->
<link rel="shortcut icon" href="favicon.ico">

<link href="${ctx}/static/css/comm/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/static/css/comm/animate.min.css" rel="stylesheet">
<link href="${ctx}/static/css/comm/style.min.css?v=4.0.0" rel="stylesheet">

<script type="text/javascript" src="${ctx}/static/plugin/contabs.min.js"></script>
<script src="${ctx}/static/plugin/extension/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctx}/static/plugin/extension/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctx}/static/plugin/extension/layer/layer.min.js"></script>
<script src="${ctx}/static/plugin/hplus.min.js"></script>
<script src="${ctx}/static/plugin/extension/pace/pace.min.js"></script>