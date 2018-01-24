<%--
  Created by IntelliJ IDEA.
  User: anzy
  Date: 2018/1/24
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>短信息检索</title>
    <c:import url="../comm/comm.jsp" ></c:import>
    <link rel="stylesheet" href="${ctx}/static/plugin/components/pagination/pagination.css">
</head>
<body>

<div class="container" id="box">
    <form role="form">
        <div class="form-group">
            <label for="tel">电话：</label>
            <input type="text" id="tel" class="form-control" placeholder="请输入电话号码" v-model="tel" />
        </div>
        <div class="form-group">
            <label for="smsContent">信息内容：</label>
            <input type="text" id="smsContent" class="form-control" placeholder="请输入信息内容" v-model="smsContent" />
        </div>
        <div class="form-group">
            <input type="button" value="查询" class="btn btn-primary" v-on:click="query()"/>
            <input type="button" value="添加" class="btn btn-primary" v-on:click="add()" />
            <input type="reset" value="重置" class="btn btn-danger" />
        </div>
    </form>
    <hr>
    <table class="table table-bordered table-hover">
        <caption class="text-center">短信息表</caption>
        <tr class="text-danger">
            <th class="text-center">序号</th>
            <th class="text-center">电话</th>
            <th class="text-center">信息内容</th>
            <th class="text-center">操作</th>
        </tr>
        <tr class="text-center" v-for="(item, index) in myData">
            <td>{{index+1}}</td>
            <td>{{item.tel}}</td>
            <td>{{item.smsContent}}</td>
            <td>
                <button class="btn btn-primary btn-sm" v-on:click="deleteMsg(index)">删除</button>
            </td>
        </tr>
        <tr v-show="myData.length!==0">
            <td colspan="4" class="text-right">
                <button class="btn btn-danger" v-on:click="deleteAll()">删除全部</button>
            </td>
        </tr>
        <tr v-show="myData.length==0">
            <td colspan="4" class="text-center text-muted">
                <p>暂无数据……</p>
            </td>
        </tr>
    </table>
        <vue-nav :cur="cur" :all="all" :callback="callback"></vue-nav>
        <p>{{msg}}</p>
</div>


</body>
<script type="text/javascript" src="${ctx}/static/plugin/components/pagination/vue-nav.js"></script>
<script type="text/javascript" src="${ctx}/static/js/sms/sms.js"></script>

</html>
