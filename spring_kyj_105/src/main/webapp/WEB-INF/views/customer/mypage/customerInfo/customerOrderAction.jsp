<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>

	<c:choose>
		<c:when test="${buyResult == 1}">
			<script type="text/javascript">
				alert("구매취소 요청 성공");
				window.location='${path}/customerOrderList.od';
			</script>
		</c:when>
		<c:when test="${buyResult == 0}">
			<script type="text/javascript">
				alert("환불요청 성공");
				window.location='${path}/customerOrderList.od';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("요청 오류");
				window.location='${path}/customerOrderList.od';
			</script>
		</c:otherwise>																				
	</c:choose>
	
</html>