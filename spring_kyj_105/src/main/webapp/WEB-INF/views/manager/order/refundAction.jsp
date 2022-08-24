<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>

	<c:choose>
		<c:when test="${refundResult == 1}">
			<script type="text/javascript">
				alert("환불 승인");
				window.location='${path}/orderList.od';
			</script>
		</c:when>
		<c:when test="${refundResult == 0}">
			<script type="text/javascript">
				alert("환불 거절");
				window.location='${path}/orderList.od';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("승인 오류");
				window.location='${path}/orderList.od';
			</script>
		</c:otherwise>																				
	</c:choose>
	
</html>