<%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/4/3
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注  册</title>
    <%
        String path = request.getContextPath();

        String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <!-- BOOTSTRAP STYLES-->
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="<%=basePath%>css/font-awesome.css" rel="stylesheet" />
</head>
<body>
    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <img src="<%=basePath%>img/logo-invoice.png" />
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                <div class="panel-body">
                    <form role="form" id="registerForm">
                        <hr />
                        <h5>注  册</h5>
                        <br />
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-user"  ></i></span>
                            <input type="text" id="name" name="name" class="form-control" placeholder="如何称呼您" />
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-apple"  ></i></span>
                            <select class="form-control" id="sex" name="sex">
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-arrows"  ></i></span>
                            <input type="text" id="age" name="age" class="form-control" placeholder="请输入您的年龄" />
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                            <input type="text" id="loginName" name="loginName" class="form-control" placeholder="请输入您的登录名" />
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input type="password" id="password" name="password" class="form-control"  placeholder="请输入您的密码" />
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i> </span>
                            <input type="password" id="repass" name="repass" class="form-control" placeholder="请再次输入您的密码" />
                        </div>
                        <div class="form-group">
                            <%--<label class="checkbox-inline">
                                <input type="checkbox" /> 记住我
                            </label>--%>
                            <span class="pull-right">
                                                       <a href="index.html" >忘记密码？ </a>
                                                </span>
                        </div>

                        <a href="javascript:void(0);" id="registerBtn" class="btn btn-primary ">马上注册</a>
                        <hr />
                        已有账号？ <a href="<%=basePath%>" >点击此处</a> 马上 <a href="<%=basePath%>">登录</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="<%=basePath%>js/jquery/jquery-3.1.1.min.js"></script>
<script src="<%=basePath%>js/jquery/jquery.validate.js"></script>
<script type="text/javascript">
var root = '<%=basePath%>';
var registerForm = $("#registerForm");

registerForm.validate({
    rules:{
        name:{
            required:true,
            maxlength:10
        },
        age:{
            required:true,
            digits:true
        },
        loginName:{
            required:true,
            maxlength:10
        },
        password:{
            required:true,
            maxlength:10
        },
        repass:{
            required:true,
            equalTo:"#password"
        }

    },
    messages:{
        name:{
            required:"此项必填",
            maxlength:"超出最大长度限制"
        },
        age:{
            required:"此项必填",
            digits:"只能输入正整数"
        },
        loginName:{
            required:"此项必填",
            maxlength:"超出最大长度限制"
        },
        password:{
            required:"此项必填",
            maxlength:"超出最大长度限制"
        },
        repass:{
            required:"此项必填",
            equalTo:"两次输入密码不一致"
        }
    },
    //自定义错误消息放到哪里
    errorPlacement : function(error, element) {
        element.next().remove();//删除显示图标
        element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
        element.closest('.form-group').append(error);//显示错误消息提示
    },
    //给未通过验证的元素进行处理
    highlight : function(element) {
        $(element).closest('.form-group').addClass('has-error has-feedback');
    },
    //验证通过的处理
    success : function(label) {
        var el=label.closest('.form-group').find("input");
        el.next().remove();//与errorPlacement相似
        el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
        label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
        label.remove();
    }
});

$("#registerBtn").on('click',function () {
    //禁用注册按钮
    $("#registerBtn").attr("disabled","disabled");

    if (!registerForm.valid()){ //验证不通过
        $("#registerBtn").remove("disabled");
        return false;
    }

    $.ajax({
        url:root+"/user/doRegister",
        data:registerForm.serialize(),
        type:"POST",
        success:function (data) {
            alert(data.data);
            if (data.success){
                setTimeout(window.location.href = root,3500);
            }
        }
    });
})

</script>
</html>
