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

	<c:if test="${updateCnt==1}"> 
		<% request.getSession().invalidate(); %>
		<script type="text/javascript">
			alert("회원정보 수정 완료");
			window.location="${path}/main.do";
		</script>
	</c:if>

	<c:if test="${updateCnt!=1}"> 
		<script type="text/javascript">
			alert("회원정보 수정 실패");
			window.location="${path}/main.do";
		</script>
	</c:if>

</body>
</html>