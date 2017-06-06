<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/stylesheets/base.css" />
    <link rel="stylesheet" type="text/css" href="/stylesheets/login.css">
</head>
<body>
<form id="login-form">
    <div id="error">
        <label></label>
    </div>
    <div>
        <input name="username" id="username" placeholder="Username" oninvalid="this.setCustomValidity('Type your username')" oninput="this.setCustomValidity('');$('#error').html('');"” required/>
    </div>
    <div>
        <input type="password" name="password" id="password" placeholder="Password" oninvalid="this.setCustomValidity('Type your password')" oninput="this.setCustomValidity('');$('#error').html('');" required/>
    </div>
    <div>
        <button name="login" id="login">Login</button>
        <button name="register" id="register">Register</button>
    </div>
</form>
</body>
<script>
    $(function () {
        var loginUrl = '/login';
        $('#login-form').submit(function (e) {
            e.preventDefault();
            $.post(loginUrl, $('#login-form').serialize(), function (data) {
                console.log(data);
                if(data.status == 0 && data.password == $("#password").val()){
                    if(data.department != "Human resources") {
                        location.href = "/employee/" + data.username;
                    }else{
                        location.href = "/hr";
                    }
                } else if(data.status == 1){
                    $("#error").html("This account has not been activated");
                } else{
                    $("#error").html("Wrong username/password");
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
