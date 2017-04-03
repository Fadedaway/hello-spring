<%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/3/14
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();

        String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <title>Title</title>
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=basePath%>css/bootstrap-theme.css" rel="stylesheet"/>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Spring MVC + Bootstrap</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">

        <p align="center">
            我是页面，你好世界！
            <br/>
            <input class="input-group-lg" type="text" id="test" name="name" value="${user.name}"/>
        </p>
        <p>
            <a class="btn btn-primary btn-lg" href="#" role="button">Maps Talk</a>
        </p>
    </div>
</div>

<div class="container">

    <div class="row">
        <div class="col-md-4">
            <h2>Maps</h2>
            <p>maps</p>
            <p>
                <a class="btn btn-danger" href="#" role="button">Maps</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>can</h2>
            <p>can</p>
            <p>
                <a class="btn btn-default" href="#" role="button">can</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>Talk</h2>
            <p>Talk</p>
            <p>
                <a class="btn btn-default" href="#" role="button">Talk</a>
            </p>
        </div>
    </div>

    <hr>
    <footer>
        <p>© ThinkingInGIS 2016</p>
    </footer>
</div>
</body>
<script>
    var root ='<%=basePath%>';
</script>
<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-3.1.1.min.js"></script>
<script>
    //$('#test').val("测试");
   /* $.ajax({
     url:root+"getUser",
     type:"POST",

     })*/
</script>
</html>
