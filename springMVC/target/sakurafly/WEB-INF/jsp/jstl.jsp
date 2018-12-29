<%@ page import="java.util.List" %>
<%@ page import="com.sakurafly.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/27
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div id="global">
    <h1>user list</h1>
<table class="table table-hover table-bordered">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>age</th>
    </tr>
   <%-- <%List<User> lists =(List<User>) request.getAttribute("userlist");
        for (User user :lists) {
            System.out.println(user.getAge());
            System.out.println(user.getId());
            System.out.println(user.getPassword());
            System.out.println(user.getUsername());
        }
    %>--%>
    <c:forEach items="${userlist}" var="user">
    <tr >
        <%--设置属性--%>


        <c:set target="${user}" property="username" >ljq</c:set>

        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>
            <c:out value="${user.password}"/>
            <c:if test="${user.password}!=null">${user.password}</c:if>
            <c:if test="${user.password}==null">密码为空，兄弟</c:if>
        </td>

        <td>${user.age}</td>
    </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
