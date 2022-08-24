<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>관리자 메인</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/managerCss/table.css">

</head>
<body>

	<%@ include file="/WEB-INF/views/manager/common/header.jsp" %>
  
    <!-- 컨텐츠 시작 -->
	<div id="container">
   		<div id="contents">
   		
   			<div id="section1">
   				<h1 align="center">
   				ADMIN PAGE
   				<hr>
   				</h1>
   			</div>
   			
			<!-- section2 시작 -->
			<div id="section2">
				<!-- 왼쪽내용 시작 -->
				<%@ include file="/WEB-INF/views/manager/common/leftMenu.jsp" %> 
				
				
				
   				
   			</div>
   				
   		</div>
   	</div>
   	<!-- 컨텐츠 종료 -->

	<%@ include file="/WEB-INF/views/manager/common/footer.jsp" %>
   
</body>
</html>