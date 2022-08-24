<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>       
<!DOCTYPE html>
<html>

	<c:if test="${insertCnt!=0}">
		<script>
		alert("재고정보 등록성공");
		window.location='${path}/productList.st';
		</script>
	</c:if>
	
	<c:if test="${insertCnt==0}">
		<script>
		alert("재고정보 등록실패");
		window.location='${path}/productList.st';
		</script>
	</c:if>

</html>