<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="${path}/resources/css/customerCss/customerInfoLeft.css">

	<div id="left">
		<div class="left_inside">
			<!-- 좌측 메뉴  -->
			<ul class="menubarL">
				<li><h3>my menu</h3></li>
				<hr>
				<li>
					<h4>회원정보</h4>
					<ul class="profile_menu">
	                    <li><a href="${path}/modifyDetailAction.do">정보수정</a></li>	
						<li><a href="${path}/deleteCustomerAction.do">회원탈퇴</a></li>			   							   						
					</ul>
				</li>
				<li>
					<h4>주문정보</h4>
					<ul class="myorder_menu">
						<li><a href="${path}/customerOrderList.od">주문목록</a></li>		   							   						
					</ul>
				</li>					
			</ul>
		</div>	
	</div>

</html>