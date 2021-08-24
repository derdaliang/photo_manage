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
    <title>File-upload</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" >
    <script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js" ></script>
</head>
<body>
<form action="/photoFileUpload" method="post" enctype="multipart/form-data">
    <table width="600">
        <tr>
            <td>上传文件</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>

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
