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
    <title>用户管理</title>
</head>
<%@include file="../../include.jsp"%>
<body>
<div class="row" style="margin-left: 5%">
    <div class="col-md-11">
        <!--   Kitchen Sink -->
        <div class="panel panel-default">
            <div class="panel-heading">
                用户管理
            </div>
           <%-- <div class="panel-body">
                <button type="button" class="btn btn-success" id="addBtn">新增</button>
            </div>--%>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>用户名称</th>
                            <th>用户年龄</th>
                            <th>用户性别</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td colspan="5" align="center">没有查询到结果</td>
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
            url: "<%=basePath%>config/user/getUserList",
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
            _html += "<tr><td colspan='5' align='center'>没有查询到结果</td></tr>";
        }

        for (var ob in content){
            var _deleteHtml = "<a href='javascript:void(0);' data="+content[ob].id+" onclick='deleteUser(this);'>删除</a>";
            var _detailHtml = "<a href='javascript:void(0);' data="+content[ob].id+" onclick='viewUser(this);'>详情</a>";
            var _editHtml = "<a href='javascript:void(0);' data="+content[ob].id+" onclick='authUser(this);'>授权</a>";
            _html += "<tr><td>"+(parseInt(ob)+1)+"</td><td>"+content[ob].name+"</td><td>"+content[ob].age+"</td><td>"+content[ob].sexStr+"</td><td>"+_deleteHtml+" "+_detailHtml+" "+_editHtml+"</td></tr>";
        }

        $(".table-responsive").find("tbody").html(_html);
    }

    var deleteUser = function (event) {
        var id = $(event).attr("data");

        $.ajax({
            url :  "<%=basePath%>config/user/deleteUserById",
            data:{"id":id},
            type:"POST",
            success:function () {
                alertTool.success("删除成功！");
                setTimeout(loadUrl("<%=basePath%>config/user"),2500);
            }
        });
    }

    var authUser = function (event) {
        var id = $(event).attr("data");

        loadUrl("<%=basePath%>config/user/authUser?id="+id)
    }

    var viewUser = function (event) {
        var id = $(event).attr("data");

        loadUrl("<%=basePath%>config/user/viewUser?id="+id)
    }

    $("#addBtn").on('click',function () {
        loadUrl("<%=basePath%>config/user/addUser");
    });

    $(document).ready(function () {
        initPage();
    });
</script>
