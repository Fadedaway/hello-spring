<%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/4/2
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link href="<%=basePath%>css/jquery-accordion-menu.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/font-awesome.css" rel="stylesheet" type="text/css" />
<style type="text/css">
    *{box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;}
    body{background:#f0f0f0;}
    .content{width:260px;margin:20px auto;}
    .filterinput{
        background-color:rgba(249, 244, 244, 0);
        border-radius:15px;
        width:90%;
        height:30px;
        border:thin solid #FFF;
        text-indent:0.5em;
        font-weight:bold;
        color:#FFF;
    }
    #demo-list a{
        overflow:hidden;
        text-overflow:ellipsis;
        -o-text-overflow:ellipsis;
        white-space:nowrap;
        width:100%;
    }
</style>
<script src="<%=basePath%>js/jquery/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery/jquery-accordion-menu.js" type="text/javascript"></script>
<body>
    <div id="rightMenu" style="float: left;">
        <div class="content">
            <div id="jquery-accordion-menu" class="jquery-accordion-menu blue">

                <ul id="demo-list">

                    <li class="active"><a href="#"><i class="fa fa-home"></i>Home </a></li>
                    <li><a href="#"><i class="fa fa-glass"></i>Events </a></li>
                    <li><a href="#"><i class="fa fa-file-image-o"></i>Gallery </a><span class="jquery-accordion-menu-label">
                        12 </span></li>
                    <li><a href="#"><i class="fa fa-cog"></i>Services </a>
                        <ul class="submenu">
                            <li><a href="#" onclick="display(this);" _url="<%=basePath%>">Web Design </a></li>
                            <li><a href="#">Hosting </a></li>
                            <li><a href="#">Design </a>
                                <ul class="submenu">
                                    <li><a href="#">Graphics </a></li>
                                    <li><a href="#">Vectors </a></li>
                                    <li><a href="#">Photoshop </a></li>
                                    <li><a href="#">Fonts </a></li>
                                </ul>
                            </li>
                            <li><a href="#">Consulting </a></li>
                        </ul>
                    </li>
                    <li><a href="#" onclick="display(this);" _url="<%=basePath%>hello"><i class="fa fa-home"></i>系统管理 </a></li>
                    <li><a href="#"><i class="fa fa-suitcase"></i>Portfolio </a>
                        <ul class="submenu">
                            <li><a href="#">Web Design </a></li>
                            <li><a href="#">Graphics </a><span class="jquery-accordion-menu-label">10 </span>
                            </li>
                            <li><a href="#">Photoshop </a></li>
                            <li><a href="#">Programming </a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-user"></i>About </a></li>
                    <li><a href="#"><i class="fa fa-envelope"></i>Contact </a></li>

                </ul>
                <div class="jquery-accordion-menu-footer">
                    Footer
                </div>
            </div>
        </div>
    </div>
    <iframe id="leftFrame" width="70%" height="90%" border="0" frameborder="no"></iframe>

</body>
<script type="text/javascript">
    (function($) {
        $.expr[":"].Contains = function(a, i, m) {
            return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
        };
        function filterList(header, list) {
            //@header 头部元素
            //@list 无需列表
            //创建一个搜素表单
            var form = $("<form>").attr({
                "class":"filterform",
                action:"#"
            }), input = $("<input>").attr({
                "class":"filterinput",
                type:"text"
            });
            $(form).append(input).appendTo(header);
            $(input).change(function() {
                var filter = $(this).val();
                if (filter) {
                    $matches = $(list).find("a:Contains(" + filter + ")").parent();
                    $("li", list).not($matches).slideUp();
                    $matches.slideDown();
                } else {
                    $(list).find("li").slideDown();
                }
                return false;
            }).keyup(function() {
                $(this).change();
            });
        }
        $(function() {
            filterList($("#form"), $("#demo-list"));
        });
    })(jQuery);

    var display = function (event) {
        var url = $(event).attr("_url");
        $('#leftFrame').attr("src",url);
    }
</script>

<script type="text/javascript">

    jQuery("#jquery-accordion-menu").jqueryAccordionMenu();

</script>
</html>
