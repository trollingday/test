<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${deleteCnt==1}">	
		<script type="text/javascript">
			alert("회원탈퇴 완료");
			window.location="${path}/main.do";
		</script>
		<% request.getSession().invalidate(); %>
	</c:if>
			
	<c:if test="${deleteCnt!=1}">	
		<script type="text/javascript">
			alert("회원탈퇴 실패");
			window.location="${path}/main.do";
		</script>
	</c:if>							
	
</body>
</html>