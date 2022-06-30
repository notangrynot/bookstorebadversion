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
    <script>

    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">简版书店${user.id}</h3>
     <div style="float:left;margin-bottom: 5px">
        <form class="form-inline" action="${pageContext.request.contextPath}/cartBookByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">ISBN号</label>
                <input type="text" name="ISBN" value="${condition.ISBN[0]}" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName1">书籍类型编号</label>
                <input type="text" name="clasno" value="${condition.clasno[0]}" class="form-control" id="exampleInputName1">
            </div>
            <div class="form-group">
                <label for="exampleInputName4">书名</label>
                <input type="text" name="bookname" value="${condition.name[0]}" class="form-control" id="exampleInputName4">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">作者</label>
                <input type="text" name="author" value="${condition.author[0]}" class="form-control" id="exampleInputName3">
            </div>

            <button type="submit" class="btn btn-default" style="float: right;">查询</button>
        </form>

    </div>


    <form id="form" action="/cartBookByPageServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="info">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>id</th>
                <th>ISBN</th>
                <th>类型编号</th>
                <th>书名</th>
                <th>作者</th>
                <th>价格</th>
            </tr>
            <c:forEach items="${pb.list}" var="book" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="uid" value="${book.id}"></th>
                    <td>${s.count}</td>
                    <td>${book.id}</td>
                    <td>${book.ISBN}</td>
                    <td>${book.clasno}</td>
                    <td>${book.bookname}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/addCartServlet?bid=${book.id}">添加到购物车</a></td>
                </tr>
            </c:forEach>

        </table>
        <div style="float: right;margin: 5px;">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/findCartByPageServlet?iid=${user.id}">我的购物车</a>
            <a class="btn btn-info" href="${pageContext.request.contextPath}/userpage.jsp">返回主页</a>
        </div>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/cartBookByPageServlet?currentPage=${pb.currentPage - 1}&rows=5&ISBN=${condition.ISBN[0]}&clasno=${condition.clasno[0]}&bookname=${condition.bookname[0]}&author=${condition.author[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/cartBookByPageServlet?currentPage=${i}&rows=5&ISBN=${condition.ISBN[0]}&clasno=${condition.clasno[0]}&bookname=${condition.bookname[0]}&author=${condition.author[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/cartBookByPageServlet?currentPage=${i}&rows=5&ISBN=${condition.ISBN[0]}&clasno=${condition.clasno[0]}&bookname=${condition.bookname[0]}&author=${condition.author[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pb.currentPage >= pb.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage < pb.totalPage}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/cartBookByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&ISBN=${condition.ISBN[0]}&clasno=${condition.clasno[0]}&bookname=${condition.bookname[0]}&author=${condition.author[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 20px;margin-left: 5px">

                共${pb.totalCount}条记录，共${pb.totalPage}页

            </span>
            </ul>
        </nav>

    </div>

</div>
</body>
</html>
