<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.djs.entity.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>显示</title>
            <link rel="stylesheet" href="bootstrap/common/css/bootstrap.css">
            <script src="bootstrap/common/js/jquery-3.2.1.js"></script>
            <script src="bootstrap/common/js/bootstrap.js"></script>
        </head>

        <body>

            <a href="action.show" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-search">查询所有宠物信息</span></a>


            <div class="container">

                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>编号</th>
                            <th>种类</th>
                            <th>颜色</th>
                            <th>价格</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.Pets}" var="pet">
                            <tr>
                                <td>${pet.id}</td>
                                <td>${pet.kind}</td>
                                <td>${pet.color}</td>
                                <td>${pet.price}</td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>

            </div>



        </body>

        </html>