<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/3
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script src="/js/echarts.common.min.js"></script>
    <title>hr</title>
</head>
<body>
<button id="generateCharts">Show Charts</button>
<button id="generateResumes">View Resume</button>
<div id="res"></div>
</body>
<script>
    $(function () {
        $("#generateCharts").click(function () {
            $("#res").empty();
            $("#res").append($("<div id=\"bar\" style=\"width: 600px;height:400px;\"></div>"));
            $("#res").append($("<div id=\"pie\" style=\"width: 600px;height:400px;\"></div>"));
            $("#res").append($("<div id=\"line\" style=\"width: 600px;height:400px;\"></div>"));
            var date = new Date();
            $.post("/getData",{"prefix":date.getFullYear() + "-" + (date.getMonth() + 1)},function (data) {
                console.log(data);
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('bar'));
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: 'Department members'
                    },
                    legend: {
                        data:['numbers']
                    },
                    xAxis: {
                        data: data[0].name
                    },
                    yAxis: {},
                    series: [{
                        type: 'bar',
                        data: data[0].value
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

                var myChart = echarts.init(document.getElementById('pie'));
                var dataArray = [];
                for(var i=0;i<data[1].name.length;i++){
                    var tmp = {value:data[1].value[i],name:data[1].name[i]};
                    dataArray.push(tmp);
                }
                // 指定图表的配置项和数据
                var option = {
                    title : {
                        text: 'Department members',
                        x:'center'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: data[1].name
                    },
                    series : [
                        {
                            type: 'pie',
                            radius : '55%',
                            data:dataArray
                        }
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

                var myChart = echarts.init(document.getElementById('line'));
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: 'SignIn'
                    },
                    legend: {
                        data:['times']
                    },
                    xAxis: {
                        data: data[2].name
                    },
                    yAxis: {},
                    series: [{
                        type: 'line',
                        data: data[2].value
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

            });

        });

        $("#generateResumes").click(function () {
            $("#res").empty();
            $.post("/getResume",null,function(data){
                console.log(data);
                var s = "<div class=\"resumes\">\n";
                for(var i=0;i<data.length;i++){
                    s += "<div class=\"resume\">\n";
                    s += "<img class=\"pic\" src=\"" + data[i].picture + "\" />\n";
                    s += "<div class=\"info\">\n";
                    s += "<p>name:" + data[i].username + "</p>";
                    s += "<p>department:" + data[i].department + "</p>";
                    s += "</div>";
                    s += "<button class='accept' value=\"" + data[i].username + "\">Accept</button><hr />";
                    s += "</div>\n";
                }
                s += "</div>\n";
                $(s).appendTo($("#res"));
                $(".accept").click(function (e) {
                    e.preventDefault();
                    $.post("/accept",{"username":this.value},function (data) {
                        if(data == 0){
                            alert("success");
                        }else{
                            alert("fail");
                        }
                    });
                    $("#generateResumes").click();
                });
            });
        });
    });


</script>
</html>