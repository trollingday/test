<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>아이디 중복 체크</title>

<link rel="stylesheet" href="${path}/resources/css/customerCss/confirmIdAction.css">

<script src="${path}/resources/js/customerJS/join.js" defer></script>

</head>
<body>
	<h2>중복 확인 페이지</h2>
	
	${selectCnt}

	<form action="${path}/confirmIdAction" method="post" name="confirmform"
		onsubmit="return confirmIdCheck()">
	
		<c:if test="${selectCnt == 1}">
			<table>
				<tr>
					<th colspan="2">
						<span>${id}</span>는 사용할수 없습니다.
					</th>
				</tr>
				
				<tr>
					<th>아이디 : </th>
					<td>
						<input class="input" type="text" name="id" maxlength="20"
							style="width:150px" autofocus required>
					</td>
				</tr>
				
				<tr>
					<th colspan="2">
						<input class="inputButton" type="submit" value="확인">
						<input class="inputButton" type="reset" value="취소" onclick="self.close();">				
					</th>
				</tr>
			</table>
		</c:if>
		<c:if test="${selectCnt != 1}">
			<table>
				<tr>
					<td align="center">
						<span>${id}</span>는 사용할수 있습니다.
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input class="inputButton" type="button" value="확인" onclick="confirmIdButtonOK()">			
					</th>
				</tr>
			</table>
		</c:if>

	</form>	

</body>
</html>