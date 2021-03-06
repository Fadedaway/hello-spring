<%@ page import="me.jovi.hellospring.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: joyce
  Date: 2017/4/2
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shortcut Technologies</title>
</head>
<%@include file="include.jsp"%>
<%
    User user = (User) session.getAttribute("loginUser");
%>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=basePath%>user/main">FELSS</a>
            </div>

            <div class="header-right">

                <a href="javascript:void(0);" class="btn btn-primary" title="New Message"><b style="font-size: 20px">您好，<%=user.getName()%></b></a>
                <a href="<%=basePath%>logout" class="btn btn-danger" title="Logout"><i class="fa fa-exclamation-circle fa-2x"></i></a>

            </div>
        </nav>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <%--<li>
                        <div class="user-img-div">
                            <img src="assets/img/user.png" class="img-thumbnail" />

                            <div class="inner-text">
                                Jhon Deo Alex
                                <br />
                                <small>Last Login : 2 Weeks Ago </small>
                            </div>
                        </div>

                    </li>--%>
                    <li>
                        <a class="active-menu" href="<%=basePath%>user/main"><i class="fa fa-dashboard "></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-desktop "></i>系统管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="javascript:void(0);" url="<%=basePath%>/config/user" onclick="jumpToRight(this);"><i class="fa fa-circle-o "></i>用户管理</a>
                            </li>
                            <li>
                                <a href="javascript:void(0);" url="<%=basePath%>/config/role" onclick="jumpToRight(this);"><i class="fa fa-toggle-on"></i>角色管理</a>
                            </li>
                            <li>
                                <a href="javascript:void(0);" url="<%=basePath%>/config/permission" onclick="jumpToRight(this);"><i class="fa fa-bell "></i>许可管理</a>
                            </li>
                            <li>
                                <a href="buttons.html"><i class="fa fa-code "></i>Buttons</a>
                            </li>
                            <li>
                                <a href="icons.html"><i class="fa fa-bug "></i>Icons</a>
                            </li>
                            <li>
                                <a href="wizard.html"><i class="fa fa-bug "></i>Wizard</a>
                            </li>
                            <li>
                                <a href="typography.html"><i class="fa fa-edit "></i>Typography</a>
                            </li>
                            <li>
                                <a href="grid.html"><i class="fa fa-eyedropper "></i>Grid</a>
                            </li>


                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-yelp "></i>Extra Pages <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="invoice.html"><i class="fa fa-coffee"></i>Invoice</a>
                            </li>
                            <li>
                                <a href="pricing.html"><i class="fa fa-flash "></i>Pricing</a>
                            </li>
                            <li>
                                <a href="component.html"><i class="fa fa-key "></i>Components</a>
                            </li>
                            <li>
                                <a href="social.html"><i class="fa fa-send "></i>Social</a>
                            </li>

                            <li>
                                <a href="message-task.html"><i class="fa fa-recycle "></i>Messages & Tasks</a>
                            </li>


                        </ul>
                    </li>
                    <li>
                        <a href="table.html"><i class="fa fa-flash "></i>Data Tables </a>

                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bicycle "></i>Forms <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">

                            <li>
                                <a href="form.html"><i class="fa fa-desktop "></i>Basic </a>
                            </li>
                            <li>
                                <a href="form-advance.html"><i class="fa fa-code "></i>Advance</a>
                            </li>


                        </ul>
                    </li>
                    <li>
                        <a href="gallery.html"><i class="fa fa-anchor "></i>Gallery</a>
                    </li>
                    <li>
                        <a href="error.html"><i class="fa fa-bug "></i>Error Page</a>
                    </li>
                    <li>
                        <a href="login.html"><i class="fa fa-sign-in "></i>Login Page</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap "></i>Multilevel Link <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"><i class="fa fa-bicycle "></i>Second Level Link</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-flask "></i>Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#"><i class="fa fa-plus "></i>Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa fa-comments-o "></i>Third Level Link</a>
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="blank.html"><i class="fa fa-square-o "></i>Blank Page</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <label>Welcome!</label>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

</body>
<script type="text/javascript">
var jumpToRight = function (event) {
    var url = $(event).attr("url");

    loadUrl(url);
}

var loadUrl = function (url) {
    $("#page-inner").load(url);
}
</script>
</html>
