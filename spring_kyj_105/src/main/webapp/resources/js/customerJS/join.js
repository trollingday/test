/**
 * 회원 가입 validation check
 */

//필수항목 체크
function signInCheck() {
	if(!document.joinform.id.value) {
		alert("아이디를 입력하세요.");
		document.joinform.id.focus();
		return false;
		
	//password
	} else if(!document.joinform.password.value) {
		alert("비밀번호를 입력하세요.");
		document.joinform.password.focus();
		return false;
		
	//repassword	
	} else if(!document.joinform.repassword.value) {
		alert("비밀번호(확인)를 입력하세요.");
		document.joinform.repassword.focus();
		return false;
		
	//password 일치	
	} else if(document.joinform.password.value != document.joinform.repassword.value) {
		alert("비밀번호가 일치하지않습니다.");
		document.joinform.password.focus();
		return false;
		
	//name	
	} else if(!document.joinform.name.value) {
		alert("이름를 입력하세요.");
		document.joinform.name.focus();
		return false;
		
	//birthday	
	} else if(!document.joinform.birthday.value) {
		alert("생일을 입력하세요.");
		document.joinform.birthday.focus();
		return false;
		
	//address	
	} else if(!document.joinform.address.value) {
		alert("주소를 입력하세요.");
		document.joinform.address.focus();
		return false;
		
	//email	
	} else if(!document.joinform.email1.value) {
		alert("이메일을 입력하세요.");
		document.joinform.email1.focus();
		return false;
		
	//이메일형식 불일치	
	//email2.value 미존재 && 직접 입력 => 이메일형식 불일치
	} else if(!document.joinform.email2.value && document.joinform.email3.value=="0") {
		alert("이메일형식 불일치");
		document.joinform.email2.focus();
		return false;	
    
	// 2-1. join.jsp 폼 바로 아래추가 
    // <input type="hidden" name="hiddenId" value="0">
    
	//2-2.중복확인 버튼을 클릭하지 않는 경우 "중복확인 해주세요."
	} else if(document.joinform.hiddenId.value == "0"){
		alert("중복확인 해주세요.");
		document.joinform.dupChk.focus();
		return false;	
	}
	
	
}



//아이디 중복확인 페이지
//1.중복확인 페이지 open
//2.중복확인 버튼을 클릭하지 않는 경우 "중복확인 해주세요."
function confirmId() {
	
	if(!document.joinform.id.value) {
		alert("아이디를 입력하세요.");
		document.joinform.id.focus();
		return false;
	}
			
	var url="/kyj/confirmIdAction.do?id="+document.joinform.id.value;
	window.open(url,"confirm","menubar=no, width=500, height=400");
	
}

//이메일 주소를 select 박스로 선택
function selectEmailChk() {
	if(document.joinform.email3.value!="0") {
		document.joinform.email2.value=document.joinform.email3.value;
		return false;		
	} else {
		document.joinform.email2.value="";
		document.joinform.email2.focus();
		return false;
	}
}



//---------- 중복확인 ------------------
function confirmIdFocus(){
	document.confirmform.id.focus();
}

function confirmIdCheck(){
	if(!document.confirmform.id.value) {
		alert("아이디를 입력하세요.");
		document.confirmform.id.focus();
	}
	return false;
}

//4. 자식창에서 부모창으로 id값을 전달
//opener : window객체의 open() 메서드로 열린 새창(=중복확인창)에서 부모창에 접근할때 사용
//join.jsp - hiddenId : 
//self.close(); 내창 닫기

function setId(id){
	opener.document.joinform.id.value=id;
	opener.document.joinform.hiddenId.value="0";
	self.close();
}

function confirmIdButtonOK(){
	opener.document.joinform.hiddenId.value = 1;
	self.close();
}



//---------- 주소찾기 ------------------
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
     
            document.getElementById("sample4_engAddress").value = data.addressEnglish;
                   
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}