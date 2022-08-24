<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>상품 진열 페이지</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/productCss/productAll.css">

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
  	
	<!-- 컨텐츠 시작 -->
	<div id="container">
   		<div id="contents">
   			<div id="section1">
   				<h1 align="center">
   				상품진열
   				<hr>
   				</h1>
   			</div>
   			
   			<!-- section2 시작 -->
   			<div id="section2">
   				
   				<div class="row">
   				
   				<c:if test="${productBox!=null}">
	   				<c:forEach var="row" items="${productBox}">
	   				
						<div class="box">
							<a href="${path}/productDetail2.st?pdName=${row.getPdName()}&pdImg=${row.getPdImg()}&brand=${row.getBrand()}&price=${row.getPrice()}">
							<img src="${row.getPdImg()}" width="300" height="300">
							</a>
							<br>${row.getBrand()} ${row.getPdName()} ${row.getPrice()}
						</div>
					
					</c:forEach>
				</c:if>
				</div>
	
   		</div>
    </div>
	<!-- 컨텐츠 종료 -->
	
 	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
   
</body>
</html>