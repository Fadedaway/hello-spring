<%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/4/3
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登   录</title>
    <%
        String path = request.getContextPath();

        String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <!-- BOOTSTRAP STYLES-->
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="<%=basePath%>css/font-awesome.css" rel="stylesheet" />
    <!-- GOOGLE FONTS
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />-->
</head>
<body style="background-color: #E2E2E2;">
    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <img src="<%=basePath%>img/logo-invoice.png" />
            </div>
        </div>
        <div class="row ">

            <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

                <div class="panel-body">
                    <form role="form">
                        <hr />
                        <h5>登  录</h5>
                        <br />
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                            <input type="text" id="loginName" class="form-control" placeholder="请输入您的登录名" />
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                            <input type="password" id="password" class="form-control"  placeholder="请输入您的密码" />
                        </div>
                        <div class="form-group">
                            <label class="checkbox-inline">
                                <input type="checkbox" /> 记住我
                            </label>
                            <span class="pull-right">
                                                       <a href="index.html" >忘记密码？ </a>
                                                </span>
                        </div>

                        <a href="javascript:void(0);" id="loginBtn" class="btn btn-primary ">马上登录</a>
                        <hr />
                        没有账号？ <a href="<%=basePath%>user/gotoRegister" >点击此处</a> 马上 <a href="<%=basePath%>user/gotoRegister">注册</a>
                    </form>
                </div>

            </div>

        </div>
    </div>
</body>
<script src="<%=basePath%>js/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    var root = '<%=basePath%>';

    $("#loginBtn").on('click',function () {
        var loginName = $("#loginName").val();
        var password = $("#password").val();

        $.ajax({
            url:root+"user/doLogin",
            data:{"loginName":loginName,"password":password},
            type:"POST",
            success:function (data) {
                if (data.success){
                    window.location.href = root + "user/main";
                }else{
                    alert(data.data);
                }
            }
        });
    })
</script>
</html>
