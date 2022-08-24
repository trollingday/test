<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>게시글 - 상세페이지</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/boardCss/board02.css">

<script>

$(function(){	

	comment_list();
		
	$(document).on("click","#btnList", function(){
		window.location.href = '${path}/qboardList.ad';
	});
	
});

//댓글목록
function comment_list(){
	$.ajax({
		type:'post',
		url:'${path}/commentList.ad?${_csrf.parameterName}=${_csrf.token}',
		data:'num=${dto.getNum()}',
		dataType:'json',
		success: function(result){			
			
			var data = "";
			array = result['commentBox'];
			
			for(var i = 0;i < array.length;i++){
				data+="<table style='width:800px;'>";
				data+="<tr>";
				data+="<td> 작성자 : "+array[i]['writer']+"내용 : "+array[i]['content']+"</td>";
				data+="</tr>";
				data+="</table>";
			}
			
			$('.commentList').html(data);
		},
		error: function() {
			alert('오류');
		}	
	});
}

</script>

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>		
    
    <!-- 컨텐츠 시작 -->
	<div id="container">
   		<div id="contents">

   				<!-- 우측내용 시작 -->
   				<div id="right">
					<!-- 상단 중앙2 시작 -->
						<div id="se_inner">
							<h2 align="center">게시판 상세페이지</h2>
							<div class="manager">
								<form name="boardInsert" action="${path}/passwordChk.ad" method="post">
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
								
								<!-- 댓글목록을 출력할 영역 -->
								<div class="commentList"> </div>
						</div>
											
					</div>
						
   		</div>				
   </div>
   <!-- 컨텐츠 종료 -->
   
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>		
   
</body>
</html>