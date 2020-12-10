<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> main page </h1>
	<c:forEach var="dto" items="${testDAO}">
	<h1> num = ${dto.num}</h1>
	<h1> id = ${dto.id}</h1>
	<h1> 원본파일명 = ${dto.orgname}</h1>
	<h1> 저장파일명 = ${dto.savename}</h1>
	<h1> 날짜 = ${dto.reg}</h1><br />
	</c:forEach>
</body>
</html>