<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.djs.test.*" 
    %>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>    
<% 
	List<User> l = new ArrayList();
	l.add(new User("1","zhangsan","1111"));
	l.add(new User("1","zhangsan","1111"));
	l.add(new User("1","zhangsan","1111"));
	l.add(new User("1","zhangsan","1111"));
	l.add(new User("1","zhangsan","1111"));
	request.setAttribute("key", l);


%>>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>${requestScope.key}</p>
	<table border="1px">
		<thead>
			<tr>
				<th>用户id</th>
				<th>用户名</th>
				<th>密码</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.key}" var="u">
				<tr>
					<td>${u.id} </td>
					<td>${u.uname} </td>
					<td>${u.upw} </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>