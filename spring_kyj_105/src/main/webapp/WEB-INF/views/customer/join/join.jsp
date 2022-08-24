<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/customerCss/join.css">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${path}/resources/js/customerJS/join.js" defer></script>
</head>
<body>

	<div class="wrap">
	
	<%@ include file = "/WEB-INF/views/common/header.jsp" %>
	
	</div>
   
	<!-- 회원가입 컨텐츠 시작 -->
	<div id="container">
	   <div id="contents">
	       <!-- 상단 중앙 시작 -->
	      <div id="section1">
	             <h2 align="center" style="padding: 10px 20px 0"> 회원가입 </h2>
	      </div>
	         	<!-- 상단 중앙 시작2 -->
	             <div id="section2">
	                <div id="se_inner">
	                   <div class="join">
	                     <form name="joinform" action="${path}/joinAction.do" onsubmit="return signInCheck()" method="post">
	                       <!-- 2-1. join.jsp 폼 바로 아래추가 --> 
	                       <input type="hidden" name="hiddenId" value="0">
	                       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
	                        <table>
	                           <colgroup>
	                           <col style="width: 150px;">
	                           <col style="width: auto;">
	                           <col style="width: auto;">
	                           </colgroup>
	                           <tr>
	                              <th> * 아이디 </th>
	                              <td>
	                                 <input type="text" class="input" name="id" size="15" placeholder="공백없이 20자 이내로 작성">
	                                 <input type="button" name="dupChk" value="중복확인" style=margin-left:10px" onclick="confirmId()">
	                              </td>
	                           </tr>
	                           
	                           <tr>
	                              <th> * 비밀번호 </th>
	                              <td colspan="2"><input type="password" class="input" name="password" size="15" placeholder="공백없이 15자 이내로 작성">
	                              </td>
	                           </tr>
	                           
	                           <tr>
	                              <th> * 비밀번호(확인) </th>
	                              <td colspan="2"><input type="password" class="input" name="repassword" size="15" placeholder="공백없이 15자 이내로 작성">
	                              </td>
	                           </tr>
	                           
	                           <tr>
	                                 <th>* 이름</th>
	                                 <td colspan="2"><input type="text" class="input" name="name" size="15"></td>
	                           </tr>
	                                 
	                           <tr>
	                                 <th>* 생년월일</th>
	                                 <td colspan="2"><input type="date" class="input" name="birthday" size="30"></td>
	                           </tr>
	                           
	                           <tr>
	                                <th>* 주소</th>
									<td>
	                                <input type="text" id="sample4_postcode" placeholder="우편번호">
									<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
									<input type="text" id="sample4_roadAddress" placeholder="도로명주소" size="60" ><br>
									<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소"  size="60">
									<span id="guide" style="color:#999;display:none"></span>
									<input type="text" name="address" id="sample4_detailAddress" placeholder="상세주소"  size="60"><br>
									<input type="hidden" id="sample4_extraAddress" placeholder="참고항목"  size="60">
									<input type="hidden" id="sample4_engAddress" placeholder="영문주소"  size="60" ><br>
	                           		</td>
	                           </tr>
	                                 
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
	                          
	                          <tr>
	                                <th> 이메일</th>
	                                <td>
	                                <input type="text" class="input" name="email1" style="width:50px">
	                              		@
	                                <input type="text" class="input" name="email2" style="width:50px">
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
	                           		<th> 이메일 인증</th>
	                           		<td> 이메일 인증을 해야 회원가입이 완료 됩니다.</td>
	                           </tr>
	                                 
	                          <tr>
	                             <td colspan="3" style="border-bottom: none">
	                             <br>
	                                <div align="right">
	                                   <input type="submit" value="회원가입">
	                                   <input type="reset" value="초기화">
	                                   <input type="button" class="button" value="가입취소" onclick="window.history.back()">
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
	<!-- 회원가입 컨텐츠 끝 -->

	<%@ include file = "/WEB-INF/views/common/footer.jsp" %>

</body>
</html>