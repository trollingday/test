<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>결제 페이지</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/productCss/purchasing.css">

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
  	
	<!-- 컨텐츠 시작 -->
	<div id="container">
		<div id="contents">
			<!-- 상단 중앙 시작 -->
			<div id="section1">
				<h1 align="center">고객 주문 정보</h1>
			</div>
			
			<!-- 상단 중앙2 시작 -->
			<div id="section2">
				<div id="se_inner">
					<div class="join">
						<form name="payform" action="${path}/purchasingAction.od" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
						<table style="padding:50px;width:900px;">
							<tr>
								<th colspan="2" style="text-align:center;"><h3>상품 정보</h3></th>
							</tr>
							
							<tr>
								<th> * 상품명 </th>
								<td> <input type="text" name="pdname" value="${dto01.getPdName()}" readonly> </td>
							</tr>
							
							<tr>
								<th>* 상품브랜드</th>
								<td> <input type="text" name="brand" value="${dto01.getBrand()}" readonly> </td>
							</tr>
							
							<tr>
								<th> * 상품사이즈 </th>
								<td> <input type="text" name="pdsize" value="${dto01.getPdsize()}" readonly> </td>
							</tr>
							
							<tr>
								<th> * 상품수량 </th>
								<td> <input type="text" name="quantity" value="${dto01.getQuantity()}" readonly> </td>
							</tr>

							<tr>
								<th> * 상품가격 </th>
								<td> <input type="text" name="price" value="${dto01.getPrice()}" readonly> </td>
							</tr>
														
						</table>

						<hr>

						<table style="padding:50px;width:900px;">
							<tr>
								<th colspan="2" style="text-align:center;"><h3>배송 정보</h3></th>
							</tr>
							<tr>
								<th> * 이름 </th>
								<td>
								<input type="text" name="name" value="${dto02.getName()}" readonly>
								</td>
							</tr>
							<tr>
								<th> * 휴대폰번호 </th>
								<td>
								<input type="text" name="hp" value="${dto02.getHp()}" readonly>
								</td>
							</tr>				
							<tr>
								<th>* 주소</th>
								<td>
								<input type="text" name="address" value="${dto02.getAddress()}" readonly>
								</td>
							</tr>
						
						</table>
						
						<hr>

						<table style="padding:50px;width:900px;">
							<tr>
								<th colspan="2" style="text-align:center;"><h3>결제 정보</h3></th>
							</tr>
							<tr>
								<th> * 상품 금액 </th>
								<td>
								<c:out value="${dto01.getQuantity() * dto01.getPrice()}"/>
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
								<input type="text" name="totalPrice" value="<c:out value="${dto01.getQuantity() * dto01.getPrice() + charge}"/>" readonly>
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
										<input type="submit" value="결제" style="width:80px;height:40px;font-size:15px;">
										<input type="button" value="결제취소" style="width:80px;height:40px;font-size:15px;" onclick="window.location='${path}/*.do'">
									</div>
							</tr>
						
						</table>		
						</form>
						</div>
					</div>
				</div>


		</div>
	</div>
	<!-- 컨텐츠 종료 -->
	
 	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
   
</body>
</html>