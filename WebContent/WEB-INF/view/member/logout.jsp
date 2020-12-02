<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="UTF-8"/>
<script>
	alert("로그아웃되었습니다.")
	window.location="/mvc/member/loginForm.do"
</script>