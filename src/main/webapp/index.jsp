<%--
  Created by IntelliJ IDEA.
  User: 李雪锋
  Date: 2021/8/21
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" >
    <script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js" ></script>
</head>
<body>
<form class="form-inline" id="Login_input" action="/User/login" method="get">
    <div class="form-group">
        <label class="sr-only" for="email">Email address</label>
        <input type="email" class="form-control" id="email" placeholder="Email" name="email">
    </div>
    <div class="form-group">
        <label class="sr-only" for="password">Password</label>
        <input type="password" class="form-control" id="password" placeholder="Password" name="password">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Remember me
        </label>
    </div>
    <button type="submit" class="btn btn-default" id="login">Sign in</button>
</form>
<button href="${APP_PATH}/photoFileUpload">跳转上传</button>
<script type="text/javascript">
    <%--$("#login").click(function () {--%>
    <%--    $.ajax({--%>
    <%--        url:"${APP_PATH}/login",--%>
    <%--        data:{"email":$("#email").val(),"password":$("#password").val()},--%>
    <%--        type:"GET",--%>
    <%--        success:function (result) {--%>
    <%--            window.document.location.href = "UserDept.jsp";--%>
    <%--        },--%>
    <%--        error:function (result) {--%>
    <%--            window.document.location.href = "index.jsp";--%>
    <%--        }--%>
    <%--    })--%>
    <%--});--%>

    function to_userDet() {

    }
</script>
</body>
</html>
