<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/resource/etc/color.jsp"%>
<html>
<head><title>메인입니다..</title>
<link href="/resource/style/style.css" rel="stylesheet" type="text/css">
</head>
<c:if test="${sessionScope.memId == null}">
<script language="javascript">
<!--
function focusIt()
{      
   document.inform.id.focus();
}
 
 function checkIt()
 {
   inputForm=eval("document.inform");
   if(!inputForm.id.value){
     alert("아이디를 입력하세요..");
	 inputForm.id.focus();
	 return false;
   }
   if(!inputForm.passwd.value){
     alert("아이디를 입력하세요..");
	 inputForm.passwd.focus();
	 return false;
   }
 }
//-->
</script>
</head>

<body onLoad="focusIt();" bgcolor="${bodyback_c}">
  <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
      <tr>
       <td width="300" bgcolor="${bodyback_c}" height="20">
       &nbsp;
       </td>
   
       <form name="inform" method="post" action="/mvc/member/loginPro.do"  onSubmit="return checkIt();">

        <td bgcolor="${title_c}"  width="100" align="right">아이디</td>
        <td width="100" bgcolor="${value_c}">
            <input type="text" name="id" size="15" maxlength="10"></td>
      </tr>
      <tr > 
         <td rowspan="2" bgcolor="${bodyback_c}" width="300" >메인입니다.</td>
         <td bgcolor="${title_c}"  width="100" align="right">패스워드</td>
         <td width="100" bgcolor="${value_c}">
            <input type="password" name="passwd" size="15" maxlength="10"></td>
       </tr>
       <tr>
          <td colspan="3" bgcolor="${title_c}"   align="center">
            <input type="submit" name="Submit" value="로그인">
            <input type="button"  value="회원가입" onclick="javascript:window.location='/mvc/member/inputForm.do'">
          </td></form></tr></table>
</c:if>

<c:if test="${sessionScope.memId != null}">
       <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
         <tr>
           <td width="300" bgcolor="${bodyback_c}" height="20">하하하</td>

           <td rowspan="3" bgcolor="${value_c}" align="center">
             ${sessionScope.memId}님이 <br>
             방문하셨습니다
             <form  method="post" action="/mvc/member/logout.do">  
             <input type="submit"  value="로그아웃">
             <input type="button" value="회원정보변경" onclick="javascript:window.location='/mvc/member/modify.do'">
             </form>
         </td>
        </tr>
       <tr > 
         <td rowspan="2" bgcolor="${bodyback_c}" width="300" >메인입니다.</td>
      </tr>
     </table>
     <br>
</c:if>
 </body>
</html>
