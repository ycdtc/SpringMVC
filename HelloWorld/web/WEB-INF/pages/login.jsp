<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/stylesheets/base.css" />
</head>
<body>
<form id="login-form">
    <div>
        <input name="username" id="username" placeholder="Username" oninvalid="this.setCustomValidity('Type your username')" required/>
    </div>
    <div>
        <input type="password" name="password" id="Password" placeholder="password" oninvalid="this.setCustomValidity('Type your password')" required/>
    </div>
    <div>
        <button name="login" id="login">登录</button>
        <button name="register" id="register">注册</button>
    </div>
</form>
</body>
<script>
    $(function () {
        var loginUrl = '/login';
        $('#login').click(function (e) {
            $.post(loginUrl, $('#login-form').serialize(), function (data) {
                console.log(JSON.stringify(data));
                if(data.status == 0 && data.password == $("#password").val()){
                    if(data.department != "Human resources") {
                        location.href = "/employee/" + data.username;
                    }else{
                        location.href = "/hr";
                    }
                } else if(data.status == 1){
                    alert("此帐号还未激活");
                    //location.reload();
                } else{
                    alert("帐号/密码错误");
                }
            });
        });
        $('#register').click(function(e){
            e.preventDefault();
            location.href = "/register";
        });
    });
</script>
</html>
