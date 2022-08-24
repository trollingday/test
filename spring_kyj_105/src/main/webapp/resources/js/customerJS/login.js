function loginCheck() {
	
	if(!document.loginform.id.value) {
		alert("아이디를 입력하세요.");
		document.loginform.id.focus();
		return false;
		
	} else if(!document.loginform.password.value) {
		alert("비밀번호를 입력하세요.");
		document.loginform.password.focus();
		return false;
	}
}
