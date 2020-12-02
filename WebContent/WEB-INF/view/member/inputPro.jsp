<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "ch11.logon.LogonDBBean" %>
<%@ page import = "java.sql.Timestamp" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	alert("가입되었습니다.")
	window.location="/spring/member/loginForm.do"
</script>
