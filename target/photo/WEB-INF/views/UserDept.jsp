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
    <div>
        <form class="form-horizontal media-middle" id="Add_input" action="/User/user" method="post">
            <div class="col-lg-6 form-group has-feedback">
                <label class="control-label" for="Add-name">Name</label>
                <input type="text" class="form-control" id="Add-name" aria-describedby="inputSuccess2Status" name="name">
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="false"></span>
                <%--            <span id="inputSuccess2Status" class="sr-only">(success)</span>--%>
            </div>
            <div class="col-md-6">
                <label class="col-md-2" for="password" >Password</label>
                <input type="password" id="password" name="password" class="col-md-4" >
            </div>

            <div class="col-lg-6 form-group has-feedback" id="check_password_div">
                <label class="control-label" for="check_password">Check Password</label>
                <input type="text" class="form-control" id="check_password" aria-describedby="inputSuccess2Status" name="check_password">
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="false"></span>
                <%--            <span id="inputSuccess2Status" class="sr-only">(success)</span>--%>
            </div>
            <div class="col-lg-6">
                <label class="control-label" for="Add-age">Age</label>
                <input type="text" id="Add-age" name="age" class="col-lg-4">
            </div>
            <div class="col-lg-6">
                <label class="control-label" for="Add-email" >Email</label>
                <input type="text" id="Add-email" name="email"  class="col-lg-4">
                <span class="help-block"></span>
            </div>

            <button type="submit" name="Submit" id="upload" class="button">Add</button>
        </form>
    </div>


    <script type="text/javascript">
        $("#check_password").blur(function () {
            $("#check_password_div").removeClass("has-error has-success");
           var password=$("#password").val();
           var checkPassword=$("#check_password").val();
           if(password==checkPassword){
               $("#check_password_div").addClass("has-success");
           }else{
               $("#check_password_div").addClass("has-error");
           }
        });
        $("#Add-email").blur(function () {
            var email=$("#Add-email").val();
            var regEmail=/[a-zA-Z0-9]{3,20}@([a-zA-Z0-9]{2,10}|[a-zA-Z0-9]{2,10}[.][a-zA-Z0-9]{2,10})[.](com|cn|net)/;
            $("#Add-email").next("span").text("");
            console.log(email);
            if(!regEmail.test(email)){
                $("#Add-email").next("span").text("请输入正确的邮箱");
                return false;
            }else{
                $.ajax({
                    url:"${APP_PATH}/User/checkUser",
                    data:{"email":email},
                    type:"GET",
                    success:function (result) {
                        // console.log(result);
                        if(result.code==400){
                            $("#Add-email").next("span").text(result.map.email_check_msg);
                        }else{
                            $("#Add-email").next("span").text("邮箱正确");
                        }
                    }
                })
            }

        });
        $("#upload").click(function () {
            $.ajax({
                url:"${APP_PATH}/user",
                data:$("#Add_input").serialize() ,
                type:"POST",
                success:function (result) {
                    alert(result.message);

                }
            })
            // alert("dianji");
        })
    </script>
</body>
</html>
