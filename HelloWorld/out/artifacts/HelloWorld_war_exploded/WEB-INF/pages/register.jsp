<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" type="text/css" href="/stylesheets/base.css" />
    <link rel="stylesheet" type="text/css" href="/stylesheets/register.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<form id="register-form"  action = "/upload.do" method="post" enctype="multipart/form-data">
    <div id="img">
        <img src="/pictures/resume.png" id="picture"/>
    </div>
    <div id="left">
        <div>
            <label id="error"></label>
        </div>
        <div>
            <input required name="username" id="username" placeholder="Username" oninvalid="this.setCustomValidity('Type your username')" oninput="this.setCustomValidity('');$('#text').html('');"/>
        </div>
        <div>
            <input required name="password" id="password" placeholder="Password" oninvalid="this.setCustomValidity('Type your password')" oninput="this.setCustomValidity('')"/>
        </div>
        <div>
            <select required name="department" id="department" oninvalid="this.setCustomValidity('Choose your department')" onchange="this.setCustomValidity('')">
                <option value="" disabled selected>Choose department</option>
                <option value="Marketing">Marketing</option>
                <option value="Sales">Sales</option>
                <option value="Finance">Finance</option>
                <option value="Human resources">Human resources</option>
            </select>
        </div>
        <input type="file" name="file" id="file" hidden="hidden"/>
        <div>
            <button name="submit" id="submit">Submit</button>
        </div>
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

    $('#submit').click(function (e) {
        e.preventDefault();
        console.log($('#register-form'));
        console.log($('#register-form').serialize());
        $("#register-form").ajaxSubmit({url:'/upload.do',type:'post',success:function (data) {
            if(data){
                $('#error').html("Username has been used");
            }else{
                location.href = "";
            }
        }});
    });



</script>
</html>
