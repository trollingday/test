<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>main페이지</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">

</head>
<body>

	<%@ include file="header.jsp" %>
	
	<!-- UserLoginSuccessHandler 에서 msg 넘김 -->
   	<c:if test="${msg != null}">
      	<script type="text/javascript">
         	alert("${msg}");
      	</script>
   	</c:if>

	<!-- 컨텐츠 시작 -->
	<div style='text-align:center;padding:50px;'>
		<img src="${path}/resources/image/main_Image.jpg">
	</div>
	<!-- 컨텐츠 종료 -->
	
 	<%@ include file="footer.jsp" %>
   
</body>
</html>