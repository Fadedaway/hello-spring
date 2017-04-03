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
                        <h5>Enter Details to Login</h5>
                        <br />
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                            <input type="text" id="loginName" class="form-control" placeholder="Your Username " />
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                            <input type="password" id="password" class="form-control"  placeholder="Your Password" />
                        </div>
                        <div class="form-group">
                            <label class="checkbox-inline">
                                <input type="checkbox" /> Remember me
                            </label>
                            <span class="pull-right">
                                                       <a href="index.html" >Forget password ? </a>
                                                </span>
                        </div>

                        <a href="javascript:void(0);" id="loginBtn" class="btn btn-primary ">Login Now</a>
                        <hr />
                        Not register ? <a href="index.html" >click here </a> or go to <a href="index.html">Home</a>
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
