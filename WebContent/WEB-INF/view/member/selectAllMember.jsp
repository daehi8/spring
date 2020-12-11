<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>id</td>
			<td>pw</td>
			<td>email</td>
			<td>blog</td>
			<td>jm</td>
			<td>reg</td>
		</tr>
	<c:forEach var="dto" items="${memlist}">
		<tr>
			<td>${dto.id} </td>
			<td>${dto.passwd} </td>
			<td>${dto.email} </td>
			<td>${dto.blog} </td>
			<td>${dto.jumin1}-${dto.jumin2}</td>
			<td>${dto.reg_date} </td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>