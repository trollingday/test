<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>주문관리 - 주문목록</title>

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
					<h2 align="center">주문목록</h2>
					<form action="${path}/orderKeyword.sc?${_csrf.parameterName}=${_csrf.token}" method="post">
						<div>
							<select name="selectBox">
								<option value="1">상품명</option> 
								<option value="2">브랜드</option> 
								<option value="3">주문자명</option> 
							</select>
							<input name="keyword" type="text"></input>
							<input name="pageNum" type="hidden" value="1"></input>
							<button name="search">검색</button>
						</div>	
					</form>			
					<div class="table_div">
   						<table style="width:1000px" align="center">
   							<tr>
   								<th style="width:5%">주문번호</th>
								<th style="width:5%">상품명</th>
								<th style="width:5%">브랜드</th>	
								<th style="width:5%">사이즈</th>
								<th style="width:5%">결제금액</th>		
								<th style="width:5%">상품수량</th>
								<th style="width:5%">주문상태</th>	
								<th style="width:5%">주문일</th>	
								<th style="width:5%">주문자명</th>									
								<th style="width:5%" colspan=2>결제</th>																							   								
   							</tr>
   									
   							<!-- 게시글이 있으면 -->
   							<c:if test="${OrderBox!=null}">
	   							<c:forEach var="row" items="${OrderBox}">
		   							<tr>
		   								<td >${row.getOrderNo()}</td>
		   								<td >${row.getPdName()}</td>
		   								<td >${row.getBrand()}</td>
		   								<td >${row.getPdsize()}</td> 	 
		   								<td >${row.getPrice()}</td>
		   								<td >${row.getQuantity()}</td>
		   								<td >${row.getOrderStatus()}</td> 
		   								<td >${row.getOrderDate()}</td> 	
		   								<td >${row.getCusName()}</td>
		   								<td ><input type="button" value="승인" onclick="window.location='payPermit.od?${_csrf.parameterName}=${_csrf.token}&orderNo=${row.getOrderNo()}&orderState=${row.getOrderStatus()}'"></td>  
		   								<td ><input type="button" value="취소" onclick="window.location='payCancel.od?${_csrf.parameterName}=${_csrf.token}&orderNo=${row.getOrderNo()}&orderState=${row.getOrderStatus()}'"></td>   		   							 		   								  								   										   							  		   								  								   					
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
									
									<!-- 페이징처리2 -->
									<!-- 이전버튼 활성화 여부 -->
									<c:if test="${paging2.startPage > 10}">
										<a href="${path}/boardKeyword.sc?selectBox=${searchMap['type']}&keyword=${searchMap['keyword']}&pageNum=${paging.prev}">[이전]</a>
									</c:if>
									<!-- 페이지번호 처리 -->
									<c:if test="${paging2!=null}">
										<c:forEach var="num" begin="${paging2.startPage}" end="${paging2.endPage}">
											<a href="${path}/boardKeyword.sc?selectBox=${searchMap['type']}&keyword=${searchMap['keyword']}&pageNum=${num}">${num}</a>
										</c:forEach>
									</c:if>
									<!-- 다음버튼 활성화 여부 -->
									<c:if test="${paging2.endPage < paging2.pageCount}">
										<a href="${path}/boardKeyword.sc?selectBox=${searchMap['type']}&keyword=${searchMap['keyword']}&pageNum=${paging.next}">[다음]</a>
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