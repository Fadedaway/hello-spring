<%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/3/15
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <link href="/css/bootstrap-theme.css" rel="stylesheet"/>
    <style>
        body{
            margin-left:auto;
            margin-right:auto;
            margin-TOP:100PX;
            width:20em;
        }
    </style>
</head>
<body>
    <p class="panel-heading h1" align="center">WELCOME</p>
    <p class="page-header"></p>
    <!--下面是用户名输入框-->
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon">@</span>
        <input id="userName" type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1">
    </div>
    <br>
    <!--下面是密码输入框-->
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">@</span>
        <input id="passWord" type="text" class="form-control" placeholder="密码" aria-describedby="basic-addon1">
    </div>
    <br>
    <!--下面是登陆按钮,包括颜色控制-->
    <button type="button" style="width:280px;" class="btn btn-default">登 录</button>
</body>
<script type="text/javascript" src="js/jquery/jquery-3.1.1.min.js"></script>
</html>
