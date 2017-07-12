<%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/6/27
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
</head>
<%@include file="../../include.jsp"%>
<body>
<div class="row" style="margin-left: 5%">
    <div class="col-md-11">
        <!--   Kitchen Sink -->
        <div class="panel panel-default">
            <div class="panel-heading">
                角色管理
            </div>
            <div class="panel-body">
                <button type="button" class="btn btn-success" id="addBtn">新增</button>
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>角色名称</th>
                            <th>角色描述</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td colspan="4" align="center">没有查询到结果</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- End  Kitchen Sink -->
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    var initPage = function () {
        $.ajax({
            url: "<%=basePath%>config/role/getRoleList",
            success:function (data) {
                if (data.success){
                    installData(data);
                }
            }
        });
    }

    var installData = function (data) {
        var content = data.data;

        var _html = "";
        if (content.length == 0){
            _html += "<tr><td colspan='4' align='center'>没有查询到结果</td></tr>";
        }

        for (var ob in content){
            var _deleteHtml = "<a href='javascript:void(0);' data="+content[ob].id+" onclick='deleteRole(this);'>删除</a>";
            var _detailHtml = "<a href='javascript:void(0);' data="+content[ob].id+" onclick='viewRole(this);'>详情</a>";
            var _editHtml = "<a href='javascript:void(0);' data="+content[ob].id+" onclick='editRole(this);'>编辑</a>";
            var _authHtml = "<a href='javascript:void(0);' data="+content[ob].id+" onclick='authPermission(this);'>分配许可</a>";
            _html += "<tr><td>"+(parseInt(ob)+1)+"</td><td>"+content[ob].roleName+"</td><td>"+content[ob].description+"</td><td>"+_deleteHtml+" "+_detailHtml+" "+_editHtml+" "+_authHtml+"</td></tr>";
        }

        $(".table-responsive").find("tbody").html(_html);
    }

    var deleteRole = function (event) {
        var id = $(event).attr("data");

        $.ajax({
            url :  "<%=basePath%>config/role/deleteRoleById",
            data:{"id":id},
            type:"POST",
            success:function () {
                alertTool.success("删除成功！");
                setTimeout(loadUrl("<%=basePath%>config/role"),2500);
            }
        });
    }

    var editRole = function (event) {
        var id = $(event).attr("data");

        loadUrl("<%=basePath%>config/role/editRole?id="+id)
    }

    var viewRole = function (event) {
        var id = $(event).attr("data");

        loadUrl("<%=basePath%>config/role/viewRole?id="+id)
    }

    var authPermission = function (event) {
        var id = $(event).attr("data");

        loadUrl("<%=basePath%>config/role/authPermission?id="+id);
    }

    $("#addBtn").on('click',function () {
        loadUrl("<%=basePath%>config/role/addRole");
    });

    $(document).ready(function () {
        initPage();
    });
</script>
