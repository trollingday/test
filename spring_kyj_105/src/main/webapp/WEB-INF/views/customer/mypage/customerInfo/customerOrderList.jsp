<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>고객 주문관리 페이지</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/managerCss/table.css">

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
				<div id="right">
					<h2 align="center">주문목록</h2>
					<div class="table_div">
   						<table style="width:1000px" align="center">
   							<tr>
   								<th style="width:5%">주문순서</th>
   								<th style="width:5%">주문번호</th>
								<th style="width:5%">상품명</th>
								<th style="width:5%">브랜드</th>	
								<th style="width:5%">사이즈</th>
								<th style="width:5%">결제금액</th>		
								<th style="width:5%">상품수량</th>
								<th style="width:5%">주문상태</th>	
								<th style="width:5%">주문일</th>	
								<th style="width:5%">주문자명</th>									
								<th style="width:5%" colspan=2>요청</th>																							   								
   							</tr>
   									
   							<!-- 게시글이 있으면 -->
   							<c:if test="${OrderBox!=null}">
	   							<c:forEach var="row" items="${OrderBox}">
	   								<c:set var="i" value="${i+1}" />
		   							<tr>
		   								<td >${i }번</td>
		   								<td >${row.getOrderNo()}</td>
		   								<td >${row.getPdName()}</td>
		   								<td >${row.getBrand()}</td>
		   								<td >${row.getPdsize()}</td> 	 
		   								<td >${row.getPrice()}</td>
		   								<td >${row.getQuantity()}</td>
		   								<td >${row.getOrderStatus()}</td> 
		   								<td >${row.getOrderDate()}</td> 	
		   								<td >${row.getCusName()}</td>
		   								<td ><input type="button" value="구매취소" onclick="window.location='${path}/purchasedCancel.od?${_csrf.parameterName}=${_csrf.token}&orderNo=${row.getOrderNo()}&orderState=${row.getOrderStatus()}'"></td>	   		   								  								   								 							   		   								  								   				   							
		   								<td ><input type="button" value="환불" onclick="window.location='${path}/refundReq.od?${_csrf.parameterName}=${_csrf.token}&orderNo=${row.getOrderNo()}&orderState=${row.getOrderStatus()}'"></td>	   		   								  								   								 							   		   								  								   		
		   							</tr>
	     						</c:forEach>
     						</c:if>
     													
   						</table>
					</div>   										
				</div>		
		
				<!-- 우측내용 끝 -->	
			</div>		
		</div>
	</div>
   
	<!-- 컨텐츠 종료 -->
	
 	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
   
</body>
</html>