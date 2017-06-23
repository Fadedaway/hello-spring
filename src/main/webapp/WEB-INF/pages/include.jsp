<%--
  Created by IntelliJ IDEA.
  User: jovi
  Date: 2017/6/23
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();

    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- BOOTSTRAP STYLES-->
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="<%=basePath%>css/font-awesome.css" rel="stylesheet" />
<link href="<%=basePath%>css/jquery.toast.min.css" rel="stylesheet"/>
<link rel="shortcut icon" href="<%=basePath%>img/favicon.ico"/>
<link rel="bookmark" href="<%=basePath%>img/favicon.ico"/>

<script src="<%=basePath%>js/jquery/jquery-3.1.1.min.js"></script>
<script src="<%=basePath%>js/jquery/jquery.validate.js"></script>
<script src="<%=basePath%>js/toast/alertTool.js"></script>
<script src="<%=basePath%>js/toast/jquery.toast.min.js"></script>