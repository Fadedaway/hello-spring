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
    <title>角色详情</title>
</head>
<%@include file="../../include.jsp"%>
<body>
<!-- /. ROW  -->
<div class="row" style="margin-left: 5%">
    <div class="col-md-11 col-sm-6 col-xs-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                角色详情
            </div>
            <div class="panel-body">
                <form role="form" id="roleForm">
                    <div class="form-group">
                        <label>角色名称</label>
                        <input class="form-control" type="text" name="roleName" id="roleName" readonly />
                    </div>
                    <div class="form-group">
                        <label>角色描述</label>
                        <input class="form-control" type="text" name="description" id="description" readonly />
                    </div>

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

    $("#backBtn").on('click',function () {
        loadUrl("<%=basePath%>config/role");
    });

    var initData = function () {
        if (null == id || id == undefined || id == ""){
            return false;
        }

        $.ajax({
           url:"<%=basePath%>config/role/getRoleById",
            data:{"id":id},
            type:"GET",
            success:function (data) {
                if (data.success){
                    $("#roleName").val(data.data.roleName);
                    $("#description").val(data.data.description);
                }
            }
        });
    }

    $(document).ready(function () {
        initData();
    });
</script>
