<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "ch11.logon.LogonDBBean" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="UTF-8"/>

<c:if test="${check == 1}">
	<script>
		window.location="/spring/member/main.do"
	</script>
</c:if>
<c:if test="${check == 0}">
	<script> 
	 	alert("등록된 아이디가 없습니다.");
     	history.go(-1);
	</script>
</c:if>
<c:if test="${check > 1}">
	<script> 
	 	alert("아이디나 비밀번호가 맞지 않습니다.");
     	history.go(-1);
	</script>
</c:if>