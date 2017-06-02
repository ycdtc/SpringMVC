<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<h3>welcome,${username}</h3>
<label id="message">上次打卡时间:${lastSignInDate}</label><br>
<button id="signIn">点击此处打卡</button>
<label id="username" hidden="hidden">${username}</label>
<label id="lastSignInDate" hidden="hidden">${lastSignInDate}</label>
</body>
<script type="text/javascript">
    var date;
    var prefix = "";
    $(function () {
        date = new Date();
        if ($("#lastSignInDate").html() == date.toLocaleDateString()) {
            $("#signIn").attr("disabled", true);
            prefix = "您今天已经打过卡了<br>";
        } else {
            prefix = "点击此处进行打卡<br>";
        }
        update();
        setInterval("update()", 1000);
    });

    $("#signIn").click(function (e) {
        e.preventDefault();
        date = new Date();
        $.post("/addRecord", {"username": $("#username").html(), "date": date.toLocaleDateString()}, function (data) {
            if (data == "success") {
                alert("打卡成功");
                prefix = "您今天已经打过卡了<br>";
                $("#signIn").attr("disabled", true);
                $("#message").html("上次打卡时间" + date.toLocaleDateString());
            } else {
                alert("打卡失败，请稍后重试");
            }
        });
    });

    function update() {
        date = new Date();
        $("#signIn").html(prefix + date.toLocaleDateString() + "<br>" + date.toLocaleTimeString());
    }
</script>
</html>