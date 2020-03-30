<%--
  Created by IntelliJ IDEA.
  User: zhaoxin
  Date: 2020/3/16
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>文件上传1.0</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>学习心得提交</h1>
        </div>
        <div class="container-fluid">
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
    </body>
</html>































