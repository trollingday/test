<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>재고관리 - 재고등록</title>

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
					<h2 align="center">재고정보 등록</h2>
						<div class="manager">
							<form name="managerform" action="${path}/productAddAction.st?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
							<table style="width:800px;">
								
								<tr>
									<th> * 상품명 </th>
									<td colspan="2">
										<input type="text" class="input" name="pdName" size="30" >
									</td>
								</tr>
								
								<tr>
									<th> * 상품이미지 </th>
									<td colspan="2">
										<input type="file" class="input" name="imgFile" accept="image/*">
									</td>
								</tr>
								
								<tr>
									<th> * 상품브랜드 </th>
									<td colspan="2">
										<input type="text" class="input" name="brand" size="30" >
									</td>
								</tr>
								
								<tr>
									<th> * 사이즈 </th>
									<td colspan="2">
										<select size="4" name="pdsize"> 
											<optgroup label="사이즈">	
												<option value=250>250</option>
												<option value=260>260</option>	
												<option value=270>270</option>		
											</optgroup>
										</select>	
									</td>
								</tr>
								
								<tr>
									<th> * 상품가격 </th>
									<td colspan="2">
										<input type="text" class="input" name="price" size="30">
									</td>
								</tr>
								
								<tr>
									<th> * 상품수량 </th>
									<td colspan="2">
										<input type="number" name="quantity" value="1" min="1" max="5" step="1">
									</td>
								</tr>	
																
								<tr>
									<th> * 판매상태 </th>
									<td colspan="2">
										<select size="4" name="status"> 
											<optgroup label="판매상태">	
												<option value="판매중" selected>판매중</option>
												<option value="품절">품절</option>		
											</optgroup>
										</select>	
									</td>
								</tr>																			
								
								<tr>
									<td colspan="3" style="border-bottom:none;background:none;">
										<br>
										<div align="right">						
											<input type="submit" class="button" value="상품등록" style="width:80px;height:40px;font-size:15px;">
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