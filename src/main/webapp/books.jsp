<%--
  Created by IntelliJ IDEA.
  User: xkl
  Date: 2022/6/15
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎${user.id}号顾客</h1>
<tr>
    <td>${book.id}</td>
    <td>${book.ISBN}</td>
    <td>${book.clasno}</td>
    <td>${book.bookname}</td>
    <td>${book.author}</td>
    <td>${book.price}</td>
    <td>${user.id}</td>
</tr>
<form action="${pageContext.request.contextPath}/updateCartServlet?iid=${user.id}">
    <input type="hidden" name="iid" value="${user.id}">
    <input type="hidden" name="bid" value="${book.id}">

    <div>
        <label for="count">数量</label>
        <input type="text" id="count" name="count">
    </div>
</form>

</body>
</html>
