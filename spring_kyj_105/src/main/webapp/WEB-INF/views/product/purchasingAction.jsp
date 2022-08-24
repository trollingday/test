<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>      
<!DOCTYPE html>
<html>

	<c:choose>
		<c:when test="${insertCnt == 1}">
			<script type="text/javascript">
				alert("구매요청 성공");
				window.location='${path}/main.do';
			</script>
		</c:when>
		<c:when test="${insertCnt == 0}">
			<script type="text/javascript">
				alert("구매요청 실패");
				window.location='${path}/main.do';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("요청 오류");
				window.location='${path}/main.do';
			</script>
		</c:otherwise>																				
	</c:choose>

</html>