<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link>
    <title>SignIn</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/stylesheets/base.css"/>
    <link rel="stylesheet" type="text/css" href="/stylesheets/signIn.css"/>
</head>
<body>
    <div id="mid">
        <h3>Welcome,${username}</h3>
        <label id="message">Last signed in date: ${lastSignInDate}</label><br>
        <button id="signIn">Click to sign in</button>
        <label id="username" hidden="hidden">${username}</label>
        <label id="lastSignInDate" hidden="hidden">${lastSignInDate}</label>
    </div>
</body>
<script type="text/javascript">
    var date;
    var prefix = "";
    $(function () {
        date = new Date();
        if ($("#lastSignInDate").html() == date.toLocaleDateString()) {
            $("#signIn").attr("disabled", true);
            prefix = "You have signed in today<br>";
        } else {
            prefix = "Click to sign in<br>";
        }
        update();
        setInterval("update()", 1000);
    });

    $("#signIn").click(function (e) {
        e.preventDefault();
        date = new Date();
        $.post("/addRecord", {"username": $("#username").html(), "date": date.toLocaleDateString()}, function (data) {
            if (data == "success") {
                prefix = "Click to sign in<br>";
                $("#signIn").attr("disabled", true);
                $("#message").html("Last signed in date: " + date.toLocaleDateString());
            } else {
                alert("Error,try again later");
            }
        });
    });

    function update() {
        date = new Date();
        $("#signIn").html(prefix + date.toLocaleDateString() + "<br>" + date.toLocaleTimeString());
    }
</script>
</html>