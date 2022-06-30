<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>

<span style="font-size: 30px;">欢迎：</span><span style="font-size: 30px">${admin.adname}</span>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/login.jsp" style="float: right;margin-right: 8px;margin-top: 8px">退出</a>

<div style="text-align: center;margin-top: 250px">

    <a
            href="${pageContext.request.contextPath}/findUserByPageServlet" style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
    <br>
    <a
            href="${pageContext.request.contextPath}/findBookByPageServlet" style="text-decoration:none;font-size:33px">查询所有书籍信息
    </a>

</div>

</body>
</html>