<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>관리자 Q&A게시글 상세</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/managerCss/table2.css">

<script>

$(function(){	//페이지가 로드되면
	//자동으로 댓글목록 호출
	comment_list();
		
	$(document).on("click","#btnList", function(){
		window.location.href = '${path}/qboardList_admin.ad';
	});
	
    $("#btnComment").click(function(){
    	comment_add();
    });

});


//댓글쓰기
function comment_add(){
	
	//게시글번호, 작성자, 글내용을 파라미터로 넘길
	var param={
		"board_num":${dto.getNum()},
		"writer":$('#writer').val(),
		"content":$('#content').val()
	};
	
	$.ajax({
		type:'post',
		url:'${path}/commentAdd.ad?${_csrf.parameterName}=${_csrf.token}',
		data:param,		//commentAdd.ad?board_num=1&writer=홍길동&content=댓글테스트
		success: function(result){	//댓글쓰기가 완료되면 서버에서 콜백함수 호출
			$('#writer').val("");
			$('#content').val("");
			alert("등록완료");
			comment_list();	//댓글목록을 새로고침
		},
		error: function() {
			alert('오류');
		}

	});
}

//댓글목록
function comment_list(){
	$.ajax({
		type:'post',
		url:'${path}/commentList.ad?${_csrf.parameterName}=${_csrf.token}',
		data:'num=${dto.getNum()}',
		success: function(result){
			$('#commentList').html(result);
		},
		error: function() {
			alert('오류');
		}	
	});
}

</script>

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
					<!-- 상단 중앙2 시작 -->
						<div id="se_inner">
							<h2 align="center">게시판 상세페이지</h2>
							<div class="manager">
								<form name="boardInsert" action="#" method="post">
									<input type="hidden" name="boardNum" value=${dto.getNum()} >
									<input type="hidden" name="buttontype">			
									<table style="width:800px;">
										<tr>
											<th>* 작성자</th>
											<td>
												${dto.getWriter()}
											</td>
											<th>* 작성일</th>
											<td>
												${dto.getRegDate()}
											</td>
											<th>* 조회수</th>
											<td>
												${dto.getReadCnt()}
											</td>
										</tr>
										<tr>
											<th> * Q&A목적 </th>
											<td colspan="5">
												${dto.getTitle()}
											</td>
										</tr>
										
										<tr>
											<th> * 상품 사진 </th>
											<td colspan="5">
												<img src="${dto.getPdImg()}" style="width:400px;height:400px;"><br>
											</td>
										</tr>
										
										<tr style="height:100px;">
											<th> * Q&A내용 </th>
											<td colspan="5">
												${dto.getContent()}
											</td>
										</tr>
																																								
										<tr>
											<td colspan="6" style="border-bottom:none;background:none;">
												<br>
												<div align="right">		
													<input type="button" id="btnList" value="목록" style="width:100px;height:50px;font-size:20px;" >
												</div>
										</tr>
										</table>
									</form>									
								</div>
								
						</div>
						
						<!-- 댓글입력코드 -->
						<div style="align:center;width:600px;height:135px;border:1px solid;padding:2px;margin-left:200px;">
								<input id="writer" placeholder="이름">
								<br>
								<textarea rows="5" cols="80" id="content" placeholder="내용을 입력하세요."></textarea>		
								<br>
								<input type="button" id="btnComment" value="확인" >					
						</div>
						
						<!-- 댓글목록을 출력할 영역 -->
						<div id="commentList"> </div>	
										
					</div>	
				
   			</div>
   				
   		</div>
   	</div>
   	<!-- 컨텐츠 종료 -->

	<%@ include file="/WEB-INF/views/manager/common/footer.jsp" %>
   
</body>
</html>