<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>书籍信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

</head>
<body>
<div class="container">
    <h3 style="text-align: center">${user.username}的购物车</h3>
    <form id="form" action="${pageContext.request.contextPath}/delCartServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>ISBN</th>
                <th>书名</th>
                <th>作者</th>
                <th>价格</th>
            </tr>
            <c:forEach var="book" items="${list}">
                <tr>
                    <td>${book.ISBN}</td>
                    <td>${book.bookname}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delCartServlet?iid=${user.id}&bid=${book.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <div style="float: right;margin: 5px;">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/userpage.jsp">返回主页</a>
        </div>
    </form>

</div>

</div>
</body>
</html>
