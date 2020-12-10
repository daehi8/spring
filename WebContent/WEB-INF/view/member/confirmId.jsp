<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "ch11.logon.LogonDBBean" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/resource/etc/color.jsp"%>
<html>
<head><title>ID 중복확인</title>
<link href="/resource/style/style.css" rel="stylesheet" type="text/css">

<fmt:requestEncoding value="UTF-8"/>

<body bgcolor="${bodyback_c}">
<c:if test="${check!=0}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="${title_c}"> 
    <td height="39" >${id}이미 사용중인 아이디입니다.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="/spring/member/confirmId.do">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td bgcolor="${value_c}" align="center"> 
       다른 아이디를 선택하세요.<p>
       <input type="text" size="10" maxlength="12" name="id"> 
       <input type="submit" value="ID중복확인">
    </td>
  </tr>
</table>
</form>
</c:if>
<c:if test="${check == 0}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="${title_c}"> 
    <td align="center"> 
      <p>입력하신 ${id} 는 사용하실 수 있는 ID입니다. </p>
      <input type="button" value="닫기" onclick="setid()">
    </td>
  </tr>
</table>
</c:if>
</body>
</html>
<script>
  function setid()
    {		
    	opener.document.userinput.id.value="${id}";
		self.close();
	}
</script>
