<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>

	// date를 1초마다 호출
	window.setInterval('date()', 1000);

	// Ajax 사용방법
   	function date(){
      	$.ajax({
      		// url 정보
	        url:"time2.do",
	        
	        // 전송 타입
	        type:"post",
	        
	        // 전송 완료시 설정 
	        // result = time.do 실행된 결과
	        // id가 'd'인 클래스에 result를 text로 표시한다.
	        success : function(result){
	           $("#d").text(result);
	        }
      	});
   }
</script>

<h1>date .. 페이지</h1>
<h1 id="d"></h1>