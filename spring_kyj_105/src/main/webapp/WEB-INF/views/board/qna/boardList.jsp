<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>게시글 목록</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/boardCss/board01.css">

<script>

$(function(){
	$("#btnInsert").click(function(){
		location.href="${path}/qboard_insert.ad";
	});
});

</script>

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
 
    <!-- 컨텐츠 시작 -->
	<div id="container">
   		<div id="contents">
   				  				
				<!-- 우측내용 시작 -->
				<div id="right">
					<h2 align="center">Q&A게시판</h2>
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
		   								<td onclick="location.href='${path}/qboard_detailAction.ad?num=${row.getNum()}'">
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
										<a href="${path}/qboardList.ad?pageNum=${paging.prev}">[이전]</a>
									</c:if>
									<!-- 페이지번호 처리 -->
									<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
										<a href="${path}/qboardList.ad?pageNum=${num}">${num}</a>
									</c:forEach>
									<!-- 다음버튼 활성화 여부 -->
									<c:if test="${paging.endPage < paging.pageCount}">
										<a href="${path}/qboardList.ad?pageNum=${paging.next}">[다음]</a>
									</c:if>
									<div align="right">						
										<input type="button" class="inputbutton" value="글쓰기" id="btnInsert" >
									</div>
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