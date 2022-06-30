<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
  <!-- 指定字符集 -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>修改用户</title>

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <script src="js/jquery-2.1.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
  <h3 style="text-align: center;">修改联系人</h3>
  <form action="${pageContext.request.contextPath}/updateBookServlet" method="post">
    <!--  隐藏域 提交id-->
    <input type="hidden" name="id" value="${book.id}">

    <div class="form-group">
      <label for="name">id</label>
      <input type="text" class="form-control" id="name" name="id"  value="${book.id}" readonly="readonly" />
    </div>

    <div class="form-group">
      <label for="isbn">ISBN</label>
      <input type="text" id="isbn" class="form-control" value="${book.ISBN}" name="ISBN"/>
    </div>

    <div class="form-group">
      <label for="email">类型编号</label>
      <input type="text" id="email" class="form-control" value="${book.clasno}" name="clasno"/>
    </div>
    <div class="form-group">
      <label for="bookname">书名</label>
      <input type="text" id="bookname" class="form-control" value="${book.bookname}" name="bookname"/>
    </div>
    <div class="form-group">
      <label for="author">作者</label>
      <input type="text" id="author" class="form-control" value="${book.author}" name="author"/>
    </div>
    <div class="form-group">
      <label for="price">价格</label>
      <input type="text" id="price" class="form-control" value="${book.price}" name="price"/>
    </div>

    <div class="form-group" style="text-align: center">
      <input class="btn btn-primary" type="submit" value="提交" />
      <input class="btn btn-default" type="reset" value="重置" />
      <input class="btn btn-default" type="button" value="返回" href="/findBookByPageServlet"/>
    </div>
  </form>
</div>
</body>
</html>