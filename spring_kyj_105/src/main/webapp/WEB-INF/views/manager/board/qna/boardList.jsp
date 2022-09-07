<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>관리자 Q&A게시글 목록</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/managerCss/table.css">

</head>
<body>

	<%@ include file="/WEB-INF/views/manager/common/header.jsp" %>
  
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
				<!-- 왼쪽내용 시작 -->
				<%@ include file="/WEB-INF/views/manager/common/leftMenu.jsp" %> 
				  				
				<!-- 우측내용 시작 -->
				<div id="right">
					<h2 align="center">Q&A게시판 관리</h2>
					<form action="${path}/boardKeyword.sc?${_csrf.parameterName}=${_csrf.token}" method="post">
						<div>
							<select name="selectBox">
								<option value="1">글쓴이</option> 
								<option value="2">글제목</option> 
								<option value="3">글내용</option> 
							</select>
							<input name="keyword" type="text"></input>
							<input name="pageNum" type="hidden" value="1"></input>
							<button type="submit" name="search">검색</button>
						</div>
					</form>						
   					<div class="table_div">
   						<table style="width:1000px;" align="center" >
   						
   							<tr>
   								<th style="width:5%">글번호</th>
								<th style="width:10%">작성자</th>
								<th style="width:15%">Q&A목적</th>
								<th style="width:10%">날짜</th>
								<th style="width:10%">조회수</th>																								   								
   							</tr>
   							
   							<!-- 게시글이 있으면 -->
   							<c:if test="${boardBox!=null}">
	   							<c:forEach var="row" items="${boardBox}">
		   							<tr>
		   								<td >${row.getNum()}</td>
		   								<td >${row.getWriter()}</td>
		   								<td onclick="location.href='${path}/qboard_detailAction_admin.ad?num=${row.getNum()}'">
		   									${row.getTitle()} (${row.getCommentCount()})
		   								</td>
		   								<td >${row.getRegDate()}</td>
		   								<td >${row.getReadCnt()}</td> 	   								   								
		   							</tr>
	     						</c:forEach>
     						</c:if>
     							
							<tr >
								<td colspan="5" style="background:#FFD9BC;">
									<!-- 페이징처리 -->
									<!-- 이전버튼 활성화 여부 -->
									<c:if test="${paging.startPage > 10}">
										<a href="${path}/qboardList_admin.ad?pageNum=${paging.prev}">[이전]</a>
									</c:if>
									<!-- 페이지번호 처리 -->
									<c:if test="${paging!=null}">
										<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
											<a href="${path}/qboardList_admin.ad?pageNum=${num}">${num}</a>
										</c:forEach>
									</c:if>
									<!-- 다음버튼 활성화 여부 -->
									<c:if test="${paging.endPage < paging.pageCount}">
										<a href="${path}/qboardList_admin.ad?pageNum=${paging.next}">[다음]</a>
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