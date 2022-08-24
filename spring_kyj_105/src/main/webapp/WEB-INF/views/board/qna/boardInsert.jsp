<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>게시판 - 글쓰기</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/boardCss/board02.css">

<script>

$(function(){
	$("#btnInsert").click(function(){
		document.boardInsert.submit();
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

						<div id="se_inner">
							<h2 align="center">게시판 글쓰기</h2>
							<div class="manager">
								<form name="boardInsert" action="${path}/qboard_insertAction.ad?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
									<table style="width:800px;">
									
										<tr>
											<th>* 작성자</th>
											<td>
												<input type="text" class="input" name="writer" id="writer" size="20" >
											</td>
										</tr>
																	
										<tr>
											<th> * Q&A목적 </th>
											<td colspan="2">
												<input type="text" class="input" name="title" id="title" size="50" >
											</td>
										</tr>
										
										<tr>
											<th> * 상품사진 </th>
											<td colspan="2">
												<input type="file" class="input" name="imgFile" accept="image/*">
											</td>
										</tr>
								
										
										<tr>
											<th> * Q&A내용 </th>
											<td>
												<textarea row="5" cols="60" class="input" name="content" id="content"></textarea>
											</td>
										</tr>
																																								
										<tr>
											<td colspan="3" style="border-bottom:none;background:none;">
												<br>
												<div align="right">						
													<input type="button" id="btnInsert" value="등록" >
													<input type="reset" value="초기화" >
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