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
	<c:forEach var="dto" items="${list}">
	${dto.num} ${dto.id} ${dto.orgname} ${dto.reg} 
	<input type ="button" value ="다운로드" onclick="window.location.href='/spring/file/download.do?num=${dto.num}'"/> <br />
	<hr />
	</c:forEach>
</body>
</html>