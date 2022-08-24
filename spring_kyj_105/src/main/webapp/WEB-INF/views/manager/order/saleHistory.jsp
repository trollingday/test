<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>주문관리 - 결산</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/managerCss/table.css">

</head>
<body>

   <div class="wrap">
		<%@ include file="/WEB-INF/views/manager/common/header.jsp" %>
   </div>   
     
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
 				<%@ include file="/WEB-INF/views/manager/common/leftMenu.jsp" %>	
				<!-- 우측내용 시작 -->
				<div id="right">
					<h2 align="center">결산</h2>
					<div class="table_div">
   						<table style="width:1000px" align="center">
   							<tr>
   								<th style="width:5%">주문번호</th>
								<th style="width:5%">상품명</th>
								<th style="width:5%">결제금액</th>		
								<th style="width:5%">주문일</th>																																   								
   							</tr>
   									
   							<!-- 게시글이 있으면 -->
   							<c:if test="${saleHistoryBox!=null}">
	   							<c:forEach var="row" items="${saleHistoryBox}">
		   							<tr>
		   								<td >${row.getOrderNo()}</td>
		   								<td >${row.getPdName()}</td>	 
		   								<td >${row.getPrice()}</td>
		   								<td >${row.getOrderDate()}</td> 				  								   								
		   							</tr>
	     						</c:forEach>
     						</c:if>
     						
     						<tr>
								<td colspan="11" align="center" style="background:#FFD9BC;">
									<!-- 페이징처리 -->
									<!-- 이전버튼 활성화 여부 -->
									<c:if test="${paging.startPage > 10}">
										<a href="${path}/productList?pageNum=${paging.prev}">[이전]</a>
									</c:if>
									<!-- 페이지번호 처리 -->
									<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
										<a href="${path}/productList?pageNum=${num}">${num}</a>
									</c:forEach>
									<!-- 다음버튼 활성화 여부 -->
									<c:if test="${paging.endPage < paging.pageCount}">
										<a href="${path}/productList?pageNum=${paging.next}">[다음]</a>
									</c:if>
								</td>
							 </tr>		
							 											
   						</table>
					</div>   										
				</div>
			</div>
			
		</div>
	</div>	  	
    <!-- 컨텐츠 종료 -->
   
	<%@ include file="/WEB-INF/views/manager/common/footer.jsp" %> 
	
</body>
</html>