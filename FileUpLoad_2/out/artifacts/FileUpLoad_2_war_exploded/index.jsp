<%--
  Created by IntelliJ IDEA.
  User: zhaoxin
  Date: 2020/3/27
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
    <head>
        <meta charset="UTF-8">
        <title>心得上传页2</title>
        <link rel="icon" href="images/上传.png" type="image/x-icon">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
        <!--手机屏幕自适应的响应式布局-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: sans-serif;
                background-size: cover;
                background: url(images/网页-动漫.jpg) no-repeat fixed right 0;
                -webkit-background-size: cover;
                -o-background-size: cover;
                -moz-background-size: cover;
                -ms-background-size: cover;
                z-index: -1;
            }
            #footer {
                line-height: 40px;
                position: fixed;
                height: auto;
                width: auto;
                bottom: 0;
                right: 0;
                text-align: center;
                background: #333;
                color: #fff;

                font-family: 微软雅黑;
                font-size: 12px;
                letter-spacing: 1px;
            }
        </style>
    </head>
    <body class="container-fluid">
        <div class="jumbotron" style="background: rgba(217, 217, 217,0.85);">
            <div class="text-center">
                <h1>学习心得提交</h1>
                <p>命名：第3讲学习体会（2018040499-信息学院-计科1804-李三）</p>
            </div>

            <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">

                姓名：<input type="text" name="username"><br>
                第一份心得：<input type="file" name="file1"><br>
                第二份心得：<input type="file" name="file2"><br>
                <input type="submit" value="提交">
            </form>
            <br><br><br>
            提交结果：
            <br>
            ${result1}
            <br>
            ${result2}
            <br>
            ${result3}
        </div>


        <div id="footer">
            图片由宣恒小可爱提供&&前端果然不是我这只菜鸡能驾驭的
        </div>
    </body>
</html>
