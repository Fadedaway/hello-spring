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
    <title>许可编辑</title>
</head>
<%@include file="../../include.jsp"%>
<body>
<!-- /. ROW  -->
<div class="row" style="margin-left: 5%">
    <div class="col-md-11 col-sm-6 col-xs-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                许可编辑
            </div>
            <div class="panel-body">
                <form role="form" id="permissionForm">
                    <div class="form-group">
                        <label>许可名称</label>
                        <input class="form-control" type="text" name="permissionName" id="permissionName">
                        <p class="help-block">请输入许可名称</p>
                    </div>
                    <div class="form-group">
                        <label>许可描述</label>
                        <input class="form-control" type="text" name="description" id="description">
                        <p class="help-block">请输入许可描述</p>
                    </div>
                    <input type="hidden" name="id" id="permissionId"/>
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
    var id = '${id}';

    $("#submitBtn").on('click',function () {
        var permissionName = $("#permissionName").val();
        var description = $("#description").val();

        $.ajax({
            url:"<%=basePath%>config/permission/editPermission",
            type:"POST",
            data:$("#permissionForm").serialize(),
            success:function (data) {
                if (data.success){
                    alertTool.success("更新成功！");
                    setTimeout(loadUrl("<%=basePath%>config/permission"),2500);
                }
            }
        });
    });

    $("#backBtn").on('click',function () {
        loadUrl("<%=basePath%>config/permission");
    });

    var initData = function () {
        if (null == id || id == undefined || id == ""){
            return false;
        }

        $.ajax({
           url:"<%=basePath%>config/permission/getPermissionById",
            data:{"id":id},
            type:"GET",
            success:function (data) {
                if (data.success){
                    $("#permissionId").val(data.data.id);
                    $("#permissionName").val(data.data.permissionName);
                    $("#description").val(data.data.description);
                }
            }
        });
    }

    $(document).ready(function () {
        initData();
    });
</script>
