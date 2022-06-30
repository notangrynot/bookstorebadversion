<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>克隆书店</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="jumbotron">
    <div class="container">
    <h1>Hello, world!</h1>
    <p>Welcome to My BookStore,${user.username},this is made by 徐克隆 and it takes several days to make</p>
    <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/cartBookByPageServlet" role="button">Learn more</a></p>
    <a class="btn btn-info" href="${pageContext.request.contextPath}/login.jsp" role="button">退出 </a>
    </div>
</div>
</body>
</html>