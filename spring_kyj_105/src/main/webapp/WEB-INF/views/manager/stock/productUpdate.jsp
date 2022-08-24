<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>재고관리 - 재고정보 수정</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/managerCss/table2.css">

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
					<h2 align="center">재고정보 수정</h2>
						<div class="manager">
							<form name="managerform" action="${path}/productUpdateAction.st?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
							<table style="width:800px;">
								
								<input type="hidden" name="pdNo" value=${dto.getPdNo()}>
								<input type="hidden" name="pageNum" value=${pageNum}>
								<input type="hidden" name="pdImg02" value=${dto.getPdImg()}>
															
								<tr>
									<th> * 상품명 </th>
									<td colspan="2">
										<input type="text" class="input" name="pdName" size="30" value=${dto.getPdName()}>
									</td>
								</tr>
								
								<tr>
									<th> * 상품이미지 </th>
									<td colspan="2">
										<img src="${dto.getPdImg()}" style="width:80px;height:80px;"><br>
										<input type="file" class="input" name="pdImg01" accept="image/*" >
										<div style="color:red;font-size:10px;">이미지 수정이 필요하면 이미지 다시 등록</div>
									</td>
								</tr>
								
								<tr>
									<th> * 상품브랜드 </th>
									<td colspan="2">
										<input type="text" class="input" name="brand" size="30" value=${dto.getBrand()}>
									</td>
								</tr>
								
								<tr>
									<th> * 사이즈 </th>
									<td colspan="2">
										<select size="4" name="pdsize"> 
											<optgroup label="사이즈">	
												<option value=250 <c:if test="${dto.getPdsize()==250}">selected</c:if> >250</option>
												<option value=260 <c:if test="${dto.getPdsize()==260}">selected</c:if> >260</option>	
												<option value=270 <c:if test="${dto.getPdsize()==270}">selected</c:if> >270</option>		
											</optgroup>
										</select>	
									</td>
								</tr>
								
								<tr>
									<th> * 상품가격 </th>
									<td colspan="2">
										<input type="text" class="input" name="price" size="30" value=${dto.getPrice()}>
									</td>
								</tr>
								
								<tr>
									<th> * 상품수량 </th>
									<td colspan="2">
										<input type="number" name="quantity" min="1" max="5" step="1" value=${dto.getQuantity()}>
									</td>
								</tr>	
																
								<tr>
									<th> * 판매상태 </th>
									<td colspan="2">
										<select size="4" name="status"> 
											<optgroup label="판매상태">	
												<option value="판매중" <c:if test="${dto.getStatus()=='판매중'}">selected</c:if>>판매중</option>
												<option value="품절" <c:if test="${dto.getStatus()=='품절'}">selected</c:if>>품절</option>		
											</optgroup>
										</select>	
									</td>
								</tr>																			
								
								<tr>
									<td colspan="3" style="border-bottom:none;background:none;">
										<br>
										<div align="right">						
											<input type="submit" class="button" value="상품정보 수정" style="width:110px;height:40px;font-size:15px;">
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
   
	<%@ include file="/WEB-INF/views/manager/common/footer.jsp" %> 
	
</body>
</html>