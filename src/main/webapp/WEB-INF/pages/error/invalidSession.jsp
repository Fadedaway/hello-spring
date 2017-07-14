<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/13
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有访问权限</title>
    <%@include file="../include.jsp"%>
    <link href="<%=basePath%>css/error.css" rel="stylesheet" />
</head>
<body>
<div class="container">

    <div class="row text-center">

        <div class="col-md-12 set-pad" >

            <strong class="error-txt">ERROR ! </strong>
            <p class="p-err">Sorry!您长时间没有活动了，会话已经过期，请重新登录！</p>
            <a href="<%=basePath%>user/login" class="btn btn-danger" ><i class="fa fa-mail-reply"></i>&nbsp;PLEASE LOGIN</a>
        </div>


    </div>
</div>
</body>
</html>
