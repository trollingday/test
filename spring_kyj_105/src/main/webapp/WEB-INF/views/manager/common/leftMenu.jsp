<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>     
<!DOCTYPE html>
<html>

	<!-- 좌측 메뉴바 시작 -->
	<div id="left">
		<div class="left_inside">
			<!-- 좌측 메뉴  -->
	       <ul class="menubarL">
	          <li><h3>관리자 메뉴</h3></li>
	          <hr>
	          <li>
	             <h4>회원관리</h4>
	             <ul class="member_menu">
	                <li><a href="${path}/memberList.do">회원목록</a></li>
	             </ul>
	          </li>
	          <li>
	             <h4>게시판관리</h4>
	             <ul class="board_menu">
	                <li>
	                   <a href="${path}/qboardList_admin.ad">Q&A</a>
	                </li>                                            
	             </ul>
	          </li>
	          <li>
	             <h4>재고관리</h4>
	             <ul class="stock_menu">
	                <li><a href="${path}/productList.st">상품목록</a></li>
	                <li><a href="${path}/productAdd.st">상품등록</a></li>
	             </ul>
	          </li>
	          <li>
	             <h4>주문관리</h4>
	             <ul class="order_menu">
	                <li><a href="${path}/orderList.od">주문목록</a></li>
	                <li><a href="${path}/refundList.od">환불요청</a></li>
	                <li><a href="${path}/saleHistory.od">결산내역</a></li>  
	                <li><a href="${path}/saleChart.od">결산차트</a></li>                                                      
	             </ul>
	          </li>
	
	          <li>
	             <h5><a href="${path}/logout.do">로그아웃</a></h5>
	          </li> 
			</ul>
			<!-- 좌측 메뉴 끝  -->	
		</div>
	</div>
	
</html>