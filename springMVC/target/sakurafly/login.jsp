<%@ taglib prefix="action" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/20
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        /* id选择器*/
        #login{
            margin-top: 250px;
            margin-left: 500px;
            width: 30%;
        }
    </style>
</head>
<body>

    <form action="/login" method="post" id="login">
        <div class="form-group"  >
            <label for="exampleInputEmail1" > 用户名</label>
            <input type="text" class="form-control" name="username" id="exampleInputEmail1" placeholder="username">
        </div>
        <div class="form-group" >
            <label for="exampleInputPassword1">密码</label>
            <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
        </div>

        <button type="submit" class="btn btn-info">提交登陆</button><br>
        <a href="/selectAll" class="btn btn-info" >查询所有用户的信息</a>
    </form>



</body>
</html>
