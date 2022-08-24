<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원정보 페이지</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
  	
	<!-- 컨텐츠 시작 -->
     
	<div id="container">
		<div id="contents">
			<div id="section1">
				<h1 align="center">
				MY PAGE
				<hr>
				</h1>
			</div>
			
			<!-- section2 시작 -->
			<div id="section2">
				<!-- 좌측 메뉴바 시작 -->
				<%@ include file="/WEB-INF/views/customer/mypage/customerInfo/customerInfoLeft.jsp" %>
				
				<!-- 우측내용 시작 -->
		
				<!-- 우측내용 끝 -->	
			</div>		
		</div>
	</div>
   
	<!-- 컨텐츠 종료 -->
	
 	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
   
</body>
</html>