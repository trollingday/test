<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

   <!-- header 시작 -->
   <nav class="navbar">
   <!-- https://fontawesome.com/ -->
      
      <div class="navbar_title">
      	 <i class="fas fa-shoe-prints"></i>
         <a href="#">ShoesFunny</a>
      </div>
      <ul class="navbar_menu">
         <li><a href="${path}/main.do">HOME</a></li>
         <li><a href="${path}/productAll.st">제품소개</a></li>
         <li><a href="${path}/qboardList.ad">Q&A</a></li>
      </ul>   
      <ul class="navbar_icons">
       
      <c:if test="${sessionScope.customerID == null}">
         <li><a href="${path}/login.do">LOGIN</a></li>
      </c:if>   
      <c:if test="${sessionScope.customerID != null}">  
      	 <li><a href="${path}/logout.do">${customerID}님</a></li>
      </c:if> 
         
         <li><a href="${path}/join.do">JOIN</a></li>
         <li><a href="${path}/cartList.od"><i class="fas fa-cart-plus"></i></a></li>
         <li><a href="${path}/mypage.do"><i class="fas fa-user-alt"></i></a></li>         
      </ul>
          
   </nav>
   <!-- header 끝 -->
   
</body>
</html>