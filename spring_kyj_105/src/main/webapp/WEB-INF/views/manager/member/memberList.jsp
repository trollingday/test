<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>재고관리 - 재고목록</title>

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
					<h2 align="center">회원목록</h2>
					<form action="${path}/memberKeyword.sc?${_csrf.parameterName}=${_csrf.token}" method="post">
						<div>
							<select name="selectBox">
								<option value="1">아이디</option> 
								<option value="2">이름</option> 
								<option value="3">주소</option> 
							</select>
							<input name="keyword" type="text"></input>
							<input name="pageNum" type="hidden" value="1"></input>
							<button name="search">검색</button>
						</div>	
					</form>				
					<div class="table_div">
   						<table style="width:1000px" align="center">
   							<tr>
   								<th style="width:5%">아이디</th>
								<th style="width:5%">이름</th>	
								<th style="width:5%">생일</th>
								<th style="width:5%">주소</th>		
								<th style="width:5%">휴대폰번호</th>
								<th style="width:5%">이메일</th>	
								<th style="width:5%">가입일</th>																															   								
   							</tr>
   									
   							<!-- 게시글이 있으면 -->
   							<c:if test="${memberBox!=null}">
	   							<c:forEach var="row" items="${memberBox}">
		   							<tr>
		   								<td >${row.getId()}</td>
		   								<td >${row.getName()}</td>
		   								<td >${row.getBirthday()}</td> 	 
		   								<td >${row.getAddress()}</td>
		   								<td >${row.getHp()}</td>
		   								<td >${row.getEmail()}</td> 
		   								<td >${row.getRegDate()}</td> 		   										   								
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