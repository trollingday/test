<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>

	<c:choose>
		<c:when test="${payResult == -1}">
			<script type="text/javascript">
				alert("재고가 없습니다.");
				window.location='${path}/orderList.od';
			</script>
		</c:when>
		<c:when test="${payResult == 1}">
			<script type="text/javascript">
				alert("결제승인 성공");
				window.location='${path}/orderList.od';
			</script>
		</c:when>
		<c:when test="${payResult == 0}">
			<script type="text/javascript">
				alert("결제취소 성공");
				window.location='${path}/orderList.od';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("결제 오류");
				window.location='${path}/orderList.od';
			</script>
		</c:otherwise>																				
	</c:choose>
	
</html>