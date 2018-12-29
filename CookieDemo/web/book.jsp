<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/26
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String bookname=request.getParameter("bookname");%>
书名：<%= bookname%> <br>
<a href="/books.jsp">返回</a>
</body>
</html>
