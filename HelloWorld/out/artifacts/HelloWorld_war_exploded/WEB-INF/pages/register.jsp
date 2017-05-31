<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<form id="register-form"  action = "/upload.do" method="post" enctype="multipart/form-data">
    <img src="/pictures/resume.png" id="picture"/>
    <div>
        <input name="username" id="username"/>
        <label id="text"></label>

    </div>
    <div>
        <input name="password" id="password"/>
    </div>
    <div>
        <select name="department" id="department">
            <option value="Marketing">Marketing</option>
            <option value="Sales">Sales</option>
            <option value="Finance">Finance</option>
            <option value="Human resources">Human resources</option>
        </select>
    </div>
    <input type="file" name="file" id="file" hidden="hidden"/>
    <div>
        <button name="submit" id="submit">提交</button>
    </div>
</form>
</body>
<script>
    $("#picture").click(function(){
        $("#file").click();
    });

    $("input[type='file']").change(function(){
        var file = this.files[0];
        if (window.FileReader) {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            //监听文件读取结束后事件
            reader.onloadend = function (e) {
                $("#picture").attr("src",e.target.result);    //e.target.result就是最后的路径地址
            };
        }
    });

    $('#username').change(function (e) {
        $.post("/login", $('#register-form').serialize(), function (data) {
            if(data){
                $("#text").html("用户名重复");
                $("#text").css("color","red");
                $("#submit").attr('disabled',true);
            }else{
                $("#text").html("用户名可用");
                $("#text").css("color","green");
                $("#submit").attr('disabled',false);
            }
        });
    });

//    $('#submit').click(function (e) {
//        e.preventDefault();
//        if($("#username").val() == ""){
//            alert("请填写用户名");
//            return;
//        }
//        $.post("/upload.do", $('#register-form').serialize(), function (data) {
//            console.log(JSON.stringify(data));
//            if(data == 0){
//                alert("简历提交成功");
//                location.href = "/login";
//            } else {
//                alert("简历提交失败");
//                //location.reload();
//            }
//        });
//    });

</script>
</html>
