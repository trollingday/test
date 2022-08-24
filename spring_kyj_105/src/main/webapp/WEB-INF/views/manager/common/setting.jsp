<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!-- 플젝명 (jsp_pj_105)을 path에 설정 -->
<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- 1. kit.fontawesome.com에서 인증 2. 이미지 사용가능-->
<script src="https://kit.fontawesome.com/980ab78713.js" crossorigin="anonymous"></script>

<!-- JQuery하고 Ajax 사용준비-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${path}/resources/js/request.js"></script>