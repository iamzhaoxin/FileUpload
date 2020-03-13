<%--
  Created by IntelliJ IDEA.
  User: zhaoxin
  Date: 2020/3/11
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>文件上传网页(test)</title>
    </head>
    <body>
        <h1>第一篇心得提交入口</h1>
        <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
            学号：<input type="text" name="username"/><br>
            文件：<input type="file" name="file"/><br>
            <input type="submit" value="提交"/>
        </form>

        <h1>第二篇心得提交入口</h1>
        <form action="${pageContext.request.contextPath}/upload2" method="post" enctype="multipart/form-data">
            学号：<input type="text" name="username"/><br>
            文件：<input type="file" name="file"/><br>
            <input type="submit" value="提交"/>
        </form>
    </body>
</html>
