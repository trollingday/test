<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>accessDenied.jsp</title>
<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/managerCss/table.css">

</head>
<body>

<div class="wrap">
   <!-- header 시작 -->
   <%@ include file="/WEB-INF/views/common/header.jsp" %>   
   <!-- header 끝 -->
   <!-- 메인 컨텐츠 시작 : 화면 크기 조정을 위한 container -->
   <div id="container">
      <!-- 메인 컨텐츠 시작 : 화면 크기 조정을 위한 contents - 화면 max-width: 1240, min-width: 1240 -->
      <div id="contents" style="text-align: center">
      <!-- 상단 중앙 시작 -->
         <h1>관리자 페이지</h1>
         <br>
         <p style="font-size: 18px">${errMsg}</p> <br>
         <c:if test="${sessionScope.customerID !=null}">
            <button value="이동하기" class="inputButton" style="width:200px; font-size:24px; text-align: center;"
               onclick="window.location='logout.do'">이동하기</button>
         </c:if>
         <c:if test="${sessionScope.customerID == null}">
            <button value="이동하기" class="inputButton" style="width:200px; font-size:24px; text-align: center;"
               onclick="window.location='login.do'">이동하기</button>
         </c:if>
      </div>
   </div>
</div>

<!-- footer 시작 -->
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
<!-- footer 끝 -->

</body>
</html>
