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
<h1>fileNum page</h1>

<h1>id= ${id}</h1>

<c:forEach var="orgname" items="${list}">
	<h1>파일이름 = ${orgname} </h1>
</c:forEach>

<h1>orgname = ${orgname}</h1>

<h1>count = ${count}</h1>

</body>
</html>