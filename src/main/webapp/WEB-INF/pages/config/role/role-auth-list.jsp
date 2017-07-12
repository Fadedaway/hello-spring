<%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/6/27
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>许可管理</title>
</head>
<%@include file="../../include.jsp"%>
<body>
<div class="row" style="margin-left: 5%">
    <div class="col-md-11">
        <!--   Kitchen Sink -->
        <div class="panel panel-default">
            <div class="panel-heading">
                许可分配
            </div>
            <div class="panel-body">
                <button type="button" class="btn btn-info" id="submitBtn">提 交</button>
                <button type="button" class="btn btn-default" id="backBtn">返 回</button>
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th><input type="checkbox" onclick="fetchAll(this);"></th>
                            <th>许可名称</th>
                            <th>许可描述</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td colspan="3" align="center">没有查询到结果</td>
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
    var id = '${id}';

    $("#backBtn").on('click',function () {
        loadUrl("<%=basePath%>config/role");
    });

    $("#submitBtn").on('click',function () {
        var ids = getAllCheckedIds();

        $.ajax({
            url : "<%=basePath%>config/permission/authPermission",
            data : {"ids":ids,"roleId":id},
            type : "POST",
            success : function (data) {
                if (data.success){
                    alertTool.success("授权成功！");
                    initPage();
                }else{
                    alertTool.error("授权失败！");
                }
            },
            error : function () {
                alertTool.error("授权失败！");
            }
        });
    });

    var fetchAll = function (event) {
        var optionals = $("input[name=items]");

        for (var ob in optionals){
            if (event.checked){
                optionals[ob].checked = true;
            }else{
                optionals[ob].checked = false;
            }
        }
    }

    /**
     * 获取所有选中的id值
     * @returns {string}
     * @author jovi
     */
    var getAllCheckedIds = function () {
        var optionals = $("input[name=items]");
        var ids = "";

        for (var ob = 0;ob < optionals.length; ob++){
            if (optionals[ob].checked){
                if (ob == (optionals.length-1)){
                    ids += optionals[ob].value;
                }else{
                    ids += optionals[ob].value + ",";
                }
            }
        }
        return ids;
    }

    var initPage = function () {
        $.ajax({
            url: "<%=basePath%>config/permission/getPermissionWithAuthStatus",
            data:{"roleId":id},
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
            _html += "<tr><td colspan='3' align='center'>没有查询到结果</td></tr>";
        }

        for (var ob in content){
            if ("IN" == content[ob].permissionStatus){
                _html += "<tr><td><input type='checkbox' name='items' value='"+content[ob].id+"' checked></td>";
            }else{
                _html += "<tr><td><input type='checkbox' name='items' value='"+content[ob].id+"'></td>";
            }
            _html += "<td>"+content[ob].permissionName+"</td><td>"+content[ob].description+"</td></tr>";
        }

        $(".table-responsive").find("tbody").html(_html);
    }

    $(document).ready(function () {
        initPage();
    });
</script>
