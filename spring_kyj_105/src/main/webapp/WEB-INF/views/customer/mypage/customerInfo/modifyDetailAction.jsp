<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="spring.mvc.kyj.dto.CustomerDTO" %>   
<%@ include file="/WEB-INF/views/common/setting.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/customerCss/modifyDetailAction.css">

<script src="${path}/resources/js/customerJS/join.js" defer></script>

</head>
<body>

<div class="wrap">
<!-- HEADER 시작 -->
<%@ include file = "/WEB-INF/views/common/header.jsp" %>
<!-- HEADER 끝 -->
</div> 
   
<!-- 회원가입 컨텐츠 시작 -->
<div id="container">
   <div id="contents">
       <!-- 상단 중앙 시작 -->
      <div id="section1">
             <h2 align="center" style="padding: 10px 20px 0"> 회원정보 수정 - 상세페이지 </h2>
             <!-- border-bottom: 5px solid #B1AEB7" -->
      </div>
         	<!-- 상단 중앙 시작2 -->
             <div id="section2">
                <div id="se_inner">
                   <div class="modifyCustomerAction">
                     <form name="modifyform" action="${path}/modifyCustomerAction.do" onsubmit="return signInCheck()">
                       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                       <!-- 2-1. join.jsp 폼 바로 아래추가 --> 
                       <input type="hidden" name="hiddenId" value="0">
          
                        <table>
                        
                           <tr>
                              <th> * 아이디 </th>
                              <td>
                                 <input type="text" class="input" name="id" size="15" value=${customerDetail.getId()} placeholder="공백없이 20자 이내로 작성">                          
                              </td>
                           </tr>
                           
                           <tr>
                              <th> * 비밀번호 </th>
                              <td colspan="2"><input type="password" class="input" name="password" size="15" >
                              </td>
                           </tr>
                           
                           <tr>
                              <th> * 비밀번호(확인) </th>
                              <td colspan="2"><input type="password" class="input" name="repassword" size="15" >
                              </td>
                           </tr>
                           
                           <tr>
                                 <th>* 이름</th>
                                 <td colspan="2"><input type="text" class="input" name="name" size="15" value=${customerDetail.getName()}></td>
                           </tr>
                                 
                           <tr>
                                 <th>* 생년월일</th>
                                 <td colspan="2"><input type="date" class="input" name="birthday" size="30" value=${customerDetail.getBirthday()}></td>
                           </tr>
                           
                           <tr>
                                 <th>* 주소</th>
                                 <td colspan="2"><input type="text" class="input" name="address" size="60" value="${customerDetail.getAddress()}"></td>
                           </tr>
                                 

                           <c:if test="${customerDetail.getHp()==null}">       
                           <tr>
                                <th> 핸드폰</th>
                                <td>
                                <input type="text" class="input" name="hp1" style="width:50px">
			                     -
			                    <input type="text" class="input" name="hp2" style="width:50px">
			                     -
			                    <input type="text" class="input" name="hp3" style="width:50px">
			                    </td>
                          </tr>
                          </c:if>
                          
                          <c:if test="${customerDetail.getHp()!=null}">  
                          <c:set var="array" value="${fn:split(customerDetail.getHp(),'-')}" />

                          <tr>
                                <th> 핸드폰</th>
                                <td>
                                <input type="text" class="input" name="hp1" value=${array[0]} style="width:50px">
			                     -
			                    <input type="text" class="input" name="hp2" value=${array[1]}  style="width:50px">
			                     -
			                    <input type="text" class="input" name="hp3" value=${array[2]}  style="width:50px">
			                    </td>
                          </tr>
                          </c:if>
                         
                          <c:set var="array2" value="${fn:split(customerDetail.getEmail(),'@')}" />
                          
                          <tr>
                                <th> 이메일</th>
                                <td>
                                <input type="text" class="input" name="email1" value=${array2[0]} style="width:50px">
                              		@
                                <input type="text" class="input" name="email2" value=${array2[1]} style="width:50px">
                                <select class="input" name = "email3" style="width: 100px" onchange="selectEmailChk()">
                                   <option value="0">직접입력</option>
                                   <option value="naver.com">네이버</option>
                                   <option value="gmail.com">구글</option>
                                   <option value="daum.net">다음</option>
                                   <option value="nate.com">네이트</option>
                                </select>
                              	</td>
                           </tr>
                                 
                          <tr>
                             <td colspan="3" style="border-bottom: none">
                             <br>
                                <div align="right">
                                   <input type="submit" value="회원수정">
                                   <input type="reset" value="초기화">
                                   <input type="button" class="button" value="수정취소" onclick="window.history.back()">
                                </div>
                        		</td>                       
                          </tr>  
                                             
                        </table>

	               </form>             
	             </div>
	          </div>
	      </div>
   </div>
</div>

<!-- FOOTER 시작 -->
<%@ include file = "/WEB-INF/views/common/footer.jsp" %>
<!-- FOOTER 끝 -->

</body>
</html>