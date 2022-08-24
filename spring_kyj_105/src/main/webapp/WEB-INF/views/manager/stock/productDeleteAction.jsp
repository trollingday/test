<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>    
<!DOCTYPE html>
<html>

	<c:if test="${deleteCnt!=0}">
		<script>
		alert("재고정보 삭제성공");
		window.location='${path}/productList.st';
		</script>
	</c:if>
	
	<c:if test="${deleteCnt==0}">
		<script>
		alert("재고정보 삭제실패");
		window.location='${path}/productList.st';
		</script>
	</c:if>

</html>