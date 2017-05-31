<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>
<h3>welcome,${username}</h3>
<label id="messagePrefix">上次打卡时间:${lastSignInDate}</label><br>
<button id="signIn">点击此处打卡</button>
<input type="text" id="username" value=<%=username%>  hidden="hidden"/>
<input type="text" id="lastSignInDate" value=<%=username%> hidden="hidden"/>
</body>
<script type="text/javascript">
    var date;
    var prefix = "";
    $(function () {
        date = new Date();
        if($("lastSignInDate").value == date.toLocaleDateString()){
            $("#signIn").disable();
            prefix = "您今天已经打过卡了<br>";
        }else{
            prefix = "点击此处进行打卡<br>";
        }
        update();
        setInterval("update()",1000);
    });

    $("#signIn").click(function (e){
        e.preventDefault();
        $.post("/addRecord",{"keyword":"abcd"},function(data){
            if(data == "success"){
                alert("打卡成功");
                prefix = "您今天已经打过卡了<br>";
                $("#signIn").disable();
            }else{
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