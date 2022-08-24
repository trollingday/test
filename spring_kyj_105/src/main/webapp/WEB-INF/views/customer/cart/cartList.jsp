<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>장바구니 페이지</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/productCss/purchasing.css">

<script>

function cartRemove() {
	var checkBox = document.getElementsByName("cardId");
	var arr = new Array;
	for(var i=0;i<checkBox.length;i++){
		if(checkBox[i].checked){
			arr.push(checkBox[i].value);
		}
	}

	window.location='${path}/cartRemove.od?cartId='+arr;
}

function purchasing() {
	
	var charge = 3000;
	var checkBox = document.getElementsByName("cardId");
	var arr = new Array;
	for(var i=0;i<checkBox.length;i++){
		if(checkBox[i].checked){
			arr.push(checkBox[i].value);
		}
	}
	
	window.location='${path}/cartPay.od?${_csrf.parameterName}=${_csrf.token}&cartId='+arr;

}

</script>

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
  	
	<!-- 컨텐츠 시작 -->
	<div id="container">
		<div id="contents">
			<!-- 상단 중앙 시작 -->
			<div id="section1">
				<h1 align="center">장바구니</h1>
			</div>
			
			<!-- 상단 중앙2 시작 -->
			<div id="section2">
				<div id="se_inner">
					<div class="join">

						<table class="cartProduct" style="padding:50px;width:900px;">
						
							<tr>
								<th style="width:5%"></th>
   								<th style="width:7.5%">상품이미지</th>
								<th style="width:7.5%">상품명</th>
								<th style="width:5%">브랜드</th>
								<th style="width:5%">사이즈</th>
								<th style="width:5%">수량</th>	
								<th style="width:5%">상품가격</th>																							   								
   							</tr>
   							
   							<c:if test="${cartbox!=null}">
	   							<c:forEach var="row" items="${cartbox}">
	   								<c:set var="i" value="${i+1}" />
		   							<tr>
		   								<td><input type="checkbox" name="cardId" value=${i} /></td>
		   								<td><img src="${row.getPdImg()}" style="width:40px;height:40px;"></td>
		   								<td >${row.getPdName()}</td>
		   								<td >${row.getBrand()}</td>
		   								<td >${row.getPdsize()}</td>
		   								<td >${row.getQuantity()}</td> 
		   								<td >${row.getPrice()}</td> 			
		   							</tr>
	     						</c:forEach>		
     						</c:if>	
							<tr>
								<td colspan="7" style="border-bottom:none">
								<br>
									<div align="right">
									<input type="button" value="장바구니에서 삭제" onclick="cartRemove()" rowspan=7></td>	   								   					
									</div>
							</tr>							
						</table>
						
						<hr>

						<table style="padding:50px;width:900px;">
							<tr>
								<th colspan="2" style="text-align:center;"><h3>결제 정보</h3></th>
							</tr>
							<tr>
								<th> * 상품 총 금액 </th>
								<td>
								<c:set var = "total" value = "0" />
								<c:if test="${cartbox!=null}">
		   							<c:forEach var="row" items="${cartbox}">									
										<c:set var= "total" value="${total + row.getQuantity()*row.getPrice()}"/>	
									</c:forEach>
									<c:out value="${total}"/>			
     							</c:if>		
								</td>
							</tr>
							<tr>
								<th> * 배송비 </th>
								<td>
									${charge}
								</td>
							</tr>				
							<tr>
								<th>* 결제 예정 금액</th>
								<td>
									<c:set var= "total" value="${total + charge}"/>
									<c:out value="${total}"/>	
								</td>
							</tr>
							
							<tr>
								<th>* 결제 수단</th>
								<td>
									<input type="radio" name="chk_info" value="휴대폰결제">휴대폰결제
									<input type="radio" name="chk_info" value="계좌이체">계좌이체
								</td>
							</tr>

							<tr>
								<td colspan="3" style="border-bottom:none">
									<br>
									<div align="right">										
										<input type="button" value="결제" style="width:80px;height:40px;font-size:15px;" onclick="purchasing()">
										<input type="button" value="결제취소" style="width:80px;height:40px;font-size:15px;" onclick="window.location='${path}/*.do'">
									</div>
							</tr>
						
						</table>		
						
						</div>
					</div>
				</div>


		</div>
	</div>
	<!-- 컨텐츠 종료 -->
	
 	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
   
</body>
</html>