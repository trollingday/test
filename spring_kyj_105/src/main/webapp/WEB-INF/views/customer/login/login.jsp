<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원 로그인</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/customerCss/login.css">

<script src="${path}/resources/js/customerJS/login.js" defer></script>

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
		   
	<c:if test="${errorMsg != null}">
	   <script type="text/javascript">
	      alert("${errorMsg}");
	   </script>
	</c:if> 
	
	<c:if test="${msg != null}">
	   <script type="text/javascript">
	      alert("${msg}");
	   </script>
	</c:if> 
	
	<!-- 로그인 컨텐츠 시작 -->
	<div id="container">
		<div id="contents">
			<!-- 상단 중앙 시작 -->
			<div id="section1">
				<h1 align="center">로그인</h1>
			</div>
			
			<!-- 상단 중앙2 시작 -->
			<div id="section2">
				<div id="se_inner">
					<div class="login">
						<form name="loginform" action="${path}/login_check.do" onsubmit="return loginCheck()" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<table>

								<tr>
									<th> 아이디 </th>
									<td><input type="text" class="input" name="id" size="15" placeholder="공백없이 15자" autofocus required></td>
								</tr>	
								<tr>
									<th> 비밀번호 </th>
									<td><input type="password" class="input" name="password" size="15" placeholder="공백없이 15자"></td>
								</tr>
								<tr>
									<td colspan="2">
										<br>
										<div align="right" style="border-bottom:none">
											<input type="submit" value="로그인">
										</div>
									</td>
								</tr>	
															
							</table>
						</form>
					</div>
				</div>
			</div>
			
		</div>
	</div>

	<!-- 로그인 컨텐츠 끝 -->
	
   	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>