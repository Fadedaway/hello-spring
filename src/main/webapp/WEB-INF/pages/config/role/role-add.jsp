<%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/6/28
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色新增</title>
</head>
<%@include file="../../include.jsp"%>
<body>
<!-- /. ROW  -->
<div class="row" style="margin-left: 5%">
    <div class="col-md-11 col-sm-6 col-xs-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                角色新增
            </div>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group">
                        <label>角色名称</label>
                        <input class="form-control" type="text" name="roleName" id="roleName">
                        <p class="help-block">请输入角色名称</p>
                    </div>
                    <div class="form-group">
                        <label>角色描述</label>
                        <input class="form-control" type="text" name="description" id="description">
                        <p class="help-block">请输入角色描述</p>
                    </div>

                    <button type="button" class="btn btn-info" id="submitBtn">提 交</button>
                    <button type="button" class="btn btn-default" id="backBtn">返 回</button>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $("#submitBtn").on('click',function () {
        var roleName = $("#roleName").val();
        var description = $("#description").val();

        $.ajax({
            url:"<%=basePath%>config/role/addRole",
            type:"POST",
            data:{"roleName":roleName,"description":description},
            success:function (data) {
                if (data.success){
                    alertTool.success("保存成功！");
                    setTimeout(loadUrl("<%=basePath%>config/role"),2500);
                }
            }
        });
    });

    $("#backBtn").on('click',function () {
        loadUrl("<%=basePath%>config/role");
    });
</script>
