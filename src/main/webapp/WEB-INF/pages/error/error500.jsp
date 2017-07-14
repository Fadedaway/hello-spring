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
    <title>页面异常</title>
    <%@include file="../include.jsp"%>
    <link href="<%=basePath%>css/error.css" rel="stylesheet" />
</head>
<body>
<div class="container">

    <div class="row text-center">

        <div class="col-md-12 set-pad" >

            <strong class="error-txt">ERROR ! 500</strong>
            <p class="p-err">Sorry!页面出错啦！</p>
            <a href="javascript:window.history.back();" class="btn btn-danger" ><i class="fa fa-mail-reply"></i>&nbsp;PLEASE GO BACK</a>
        </div>


    </div>
</div>
</body>
</html>
