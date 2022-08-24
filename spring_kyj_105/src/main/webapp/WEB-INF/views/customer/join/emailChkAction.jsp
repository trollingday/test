<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증 페이지</title>
</head>
<body>

   <c:if test="${insertCnt == 0}">
      <script type="text/javascript">
         alert("회원 가입 - 이메일 인증 실패!!");
      </script>
   </c:if>
   
   <c:if test="${insertCnt != 0}">
      <script type="text/javascript">
      	 alert("회원가입 - 이메일 인증 성공!!");
         window.location="${path}/login.do";
      </script>
   </c:if>
   
</body>
</html>