<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>main페이지</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/productCss/productDetail.css">

<script>

function loadPurchasing() {
	
	var pdname="${dto.getPdName()}";
	var brand="${dto.getBrand()}";
	var pdsize=document.getElementById("pdsize").value;
	var quantity=document.getElementById("quantity").value
	var price="${dto.getPrice()}";
	
	var url='${path}/purchasing.od?pdName='+pdname+'&brand='+brand+'&pdsize='+pdsize+'&price='+price+'&quantity='+quantity;
	
	window.location=url;
}

function loadCartAdd() {
	
	var pdImg="${dto.getPdImg()}";
	var pdName="${dto.getPdName()}";
	var brand="${dto.getBrand()}";
	var pdsize=document.getElementById("pdsize").value;
	var quantity=document.getElementById("quantity").value
	var price="${dto.getPrice()}";
	
	var url='${path}/cartAdd.od?pdImg='+pdImg+'&pdName='+pdName+'&brand='+brand+'&pdsize='+pdsize+'&price='+price+'&quantity='+quantity;
	
	window.location=url;
}

</script>

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
  	
	<!-- 컨텐츠 시작 -->
	<div id="container">
   		<div id="contents">
   			<div id="section1">
   				<h1 align="center">
   				상품정보 페이지
   				<hr>
   				</h1>
   			</div>
   			
   			<!-- section2 시작 -->
   			<div id="section2">

   					<div class="table_div">
   						<h2 align="center">상품 상세설명</h2>
   						<table style="width:950px" align="center" border="1px solid black";>
			  				<tr>
					  			<td rowspan="7">
					  				<img src="${dto.getPdImg()}" >
					  			</td>	
					  			<td width="300">상품명 : ${dto.getPdName()}</td>
					  		</tr>
					  		<tr>	
					  			<td width="300">상품브랜드 : ${dto.getBrand()}</td>
					  		</tr>
					  		<tr>	
								<td>
									 상품사이즈 <br>
									<select size="1" id="pdsize"> 									
										<option value=250 >250</option>
										<option value=260 >260</option>	
										<option value=270 >270</option>												
									</select>	
								</td>
					  		</tr>
					  		<tr>	
								<td colspan="2">
									상품수량 <br>
									<input type="number" id="quantity" value="1" min="1" max="5" step="1">
								</td>
					  		</tr>
					  		<tr>	
					  			<td width="300">상품가격 : ${dto.getPrice()}</td>	
					  		</tr>
					  		<tr>	
					  			<td width="300">
					  				<input type="button" class="button" value="상품구매" onclick="loadPurchasing()">
					  				<input type="button" class="button" value="장바구니 담기" onclick="loadCartAdd()">	
					  			</td>
					  		</tr>
								  					  							  			
						</table>			
   					</div>

   			</div>	

   		</div>
    </div>
	<!-- 컨텐츠 종료 -->
	
 	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
   
</body>
</html>