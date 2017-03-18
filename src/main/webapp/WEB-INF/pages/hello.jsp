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
    <title>Title</title>
</head>
<body>
<%
    String path = request.getContextPath();

    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
        我是页面，你好世界！
        <br/>
        <input type="text" id="test" name="name" value="${user.name}"/>
        <input type="text" id="test" name="phone" value="${user.phone}"/>
</body>
<script>
    var root ='<%=basePath%>';
</script>
<script type="text/javascript" src="js/jquery/jquery-3.1.1.min.js"></script>
<script>
    //$('#test').val("测试");
   /* $.ajax({
     url:root+"getUser",
     type:"POST",

     })*/
</script>
</html>
