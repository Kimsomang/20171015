//=======================================================================
	//로그인
	function login_id(){
		var login_id = document.loginForm.loginId;
		var init_id = "아 이 디(이메일 주소)";
		
		if(login_id.value==init_id) {
			login_id.value="";		
		}
	}

	function login_id2(){
		var login_id = document.loginForm.loginId;
		var init_id = "아 이 디(이메일 주소)";
		if(login_id.value.trim().length==0) {
			login_id.value = init_id;			
		}	
	}

	function login_pw(){
		var login_pw = document.loginForm.loginPw;
		var init_pw = "비 밀 번 호";
		
		if(login_pw.value==init_pw) {
			login_pw.value="";
			login_pw.type="password";
		}
	}
	
	function login_pw2(){
		var login_pw = document.loginForm.loginPw;
		var init_pw = "비 밀 번 호";
		if(login_pw.value.trim().length==0) {
			login_pw.type="text";			
			login_pw.value = init_pw;			
		}	
	}
	
//=======================================================================
	//회원가입
	function signin_id(){
		var signin_id = document.signinForm.memberId1;
		var init_id = "아 이 디";
		
		if(signin_id.value==init_id) {
			signin_id.value="";		
			document.getElementById("memberId1").style.color="black";
		}
	}
	
	function signin_id2(memberId1){
		var signin_id = document.signinForm.memberId1;
		var init_id = "아 이 디";
		if(signin_id.value.trim().length==0) {
			document.getElementById("memberId1").style.color="#E3E3E3";
			signin_id.value = init_id;			
		}	
		
		var msgToId = document.getElementById("idCheck");
		if(memberId1.trim().length==0 || memberId1==null) {
			msgToId.innerText = "[아이디 입력!]";
		}else if(memberId1.trim().length<7) {
			msgToId.innerText = "[길이 확인!]";			
		}else {
			msgToId.innerText = "";						
		}
	}
	
	function signin_email(){
		var signin_email = document.signinForm.memberId2;
		var init_email = "이메일 주소";
		
		if(signin_email.value==init_email) {
			signin_email.value="";		
			document.getElementById("memberId2").style.color="black";
		}
	}
	
	function signin_email2(){
		var signin_email = document.signinForm.memberId2;
		var init_email = "이메일 주소";
		if(signin_email.value.trim().length==0) {
			document.getElementById("memberId2").style.color="#E3E3E3";
			signin_email.value = init_email;			
		}	
	}
	
	function signin_pw(){
		var signin_pw = document.signinForm.memberPw;
		var init_pw = "비 밀 번 호";
		
		if(signin_pw.value==init_pw) {
			signin_pw.value="";
			signin_pw.type="password";
			document.getElementById("memberPw").style.color="black";
		}
	}
	
	function signin_pw2(){
		var signin_pw = document.signinForm.memberPw;
		var init_pw = "비 밀 번 호";
		if(signin_pw.value.trim().length==0) {
			document.getElementById("memberPw").style.color="#E3E3E3";
			signin_pw.type="text";			
			signin_pw.value = init_pw;		
		}	
		
		var msgToPw = document.getElementById("pwCheck");
		var memberPw = document.signinForm.memberPw.value;
		var memberPwChk = document.signinForm.memberPwChk.value;
		if(memberPw.trim().length==0 || memberPw=="비 밀 번 호") {
			msgToPw.innerText = "[비밀번호 입력!]";
		}else if(memberPw.trim().length<7) {
			msgToPw.innerText = "[길이 확인!]";	
		}else if(memberPw != memberPwChk) {
			msgToPw.innerText = "[비밀번호 불일치!!]";
		}else {			
			msgToPw.innerText = "";									
		}
	}
	
	function signin_pw_chk(){
		var signin_pw_chk = document.signinForm.memberPwChk;
		var init_pw_chk = "비 밀 번 호 확 인";
		
		if(signin_pw_chk.value==init_pw_chk) {
			signin_pw_chk.value="";
			signin_pw_chk.type="password";
			document.getElementById("memberPwChk").style.color="black";
		}
	}
	
	function signin_pw_chk2(){
		var signin_pw_chk = document.signinForm.memberPwChk;
		var init_pw_chk = "비 밀 번 호 확 인";
		if(signin_pw_chk.value.trim().length==0) {
			document.getElementById("memberPwChk").style.color="#E3E3E3";
			signin_pw_chk.type="text";			
			signin_pw_chk.value = init_pw_chk;			
		}	
		
		var msgToPw = document.getElementById("pwCheck");
		var memberPw = document.signinForm.memberPw.value;
		var memberPwChk = document.signinForm.memberPwChk.value;
		if(memberPw.trim().length==0 || memberPw=="비 밀 번 호") {
			msgToPw.innerText = "[비밀번호 입력!]";
		}else if(memberPw.trim().length<7) {
			msgToPw.innerText = "[길이 확인!]";	
		}else if(memberPw != memberPwChk) {
			msgToPw.innerText = "[비밀번호 불일치!!]";
		}else {			
			msgToPw.innerText = "";									
		}
	}
	
	function signin_name(){
		var signin_name = document.signinForm.memberName;
		var init_name = "이  름";
		
		if(signin_name.value==init_name) {
			signin_name.value="";		
			document.getElementById("memberName").style.color="black";
		}
	}
	
	function signin_name2(){
		var signin_name = document.signinForm.memberName;
		var init_name = "이  름";
		if(signin_name.value.trim().length==0) {
			document.getElementById("memberName").style.color="#E3E3E3";
			signin_name.value = init_name;			
		}	
		
		var msgToName = document.getElementById("nameCheck");
		var memberName = document.signinForm.memberName.value;
		
		if(memberName.trim().length<2){
			msgToName.innerText = "[길이 확인]";
		}else{
			msgToName.innerText = "";
		}
	}
	
	function signin_birth_year(){
		var signin_year = document.signinForm.memberBirth1;
		var init_year = "'YYYY'";
		
		if(signin_year.value==init_year) {
			signin_year.value="";		
			document.getElementById("memberBirth1").style.color="black";
		}
	}
	
	function signin_birth_year2(){
		var signin_year = document.signinForm.memberBirth1;
		var init_year = "'YYYY'";
		if(signin_year.value.trim().length==0) {
			document.getElementById("memberBirth1").style.color="#E3E3E3";
			signin_year.value = init_year;			
		}
		
		var msgToBirth1 = document.getElementById("birthCheck1");
		var memberBirth1 = document.signinForm.memberBirth1.value;
		
		if(memberBirth1.trim().length!=4){
			msgToBirth1.innerText = "[년도 형식을 맞춰주세요]";
		}else{
			msgToBirth1.innerText = "";
		}
	}

	function signin_birth_year3(){
		var signin_year = document.signinForm.memberBirth1;	
		if( isNaN(signin_year.value) ) {
			alert("숫자만 입력가능합니다!")
			signin_year.value="";
		}
		
		if(signin_year.value.trim().length==4) {
			document.signinForm.memberBirth2.focus();
		}
	}
	
	function signin_birth_mth(){
		var signin_mth = document.signinForm.memberBirth2;
		var init_mth = "'MM'";
		
		if(signin_mth.value==init_mth) {
			signin_mth.value="";		
			document.getElementById("memberBirth2").style.color="black";
		}
	}
	
	function signin_birth_mth2(){
		var signin_mth = document.signinForm.memberBirth2;
		var init_mth = "'MM'";
		if(signin_mth.value.trim().length==0) {
			document.getElementById("memberBirth2").style.color="#E3E3E3";
			signin_mth.value = init_mth;			
		}	
		
		var msgToBirth2 = document.getElementById("birthCheck2");
		var memberBirth2 = document.signinForm.memberBirth2.value;
		
		if(memberBirth2.length<2){
			msgToBirth2.innerText = "[월 형식을 맞춰주세요!]";			
		}else{
			msgToBirth2.innerText = "";
		}
		
		if(memberBirth2==0 || memberBirth2>12){
			msgToBirth2.innerText = "[월은 1~12까지 입력가능합니다!]";			
		}else{
			msgToBirth2.innerText = "";
		}
	}

	function signin_birth_mth3(){
		var signin_mth = document.signinForm.memberBirth2;	
		if( isNaN(signin_mth.value) ) {
			alert("숫자만 입력가능합니다!")
			signin_mth.value="";
		}
		
		if(signin_mth.value.trim().length==2) {
			document.signinForm.memberBirth3.focus();
		}
	}
	
	function signin_birth_date(){
		var signin_date = document.signinForm.memberBirth3;
		var init_date = "'DD'";
		
		if(signin_date.value==init_date) {
			signin_date.value="";		
			document.getElementById("memberBirth3").style.color="black";
		}
	}
	
	function signin_birth_date2(){
		var signin_date = document.signinForm.memberBirth3;
		var init_date = "'DD'";
		if(signin_date.value.trim().length==0) {
			document.getElementById("memberBirth3").style.color="#E3E3E3";
			signin_date.value = init_date;			
		}	
		
		var msgToBirth3 = document.getElementById("birthCheck3");
		var memberBirth3 = document.signinForm.memberBirth3.value;
		
		if(memberBirth3.length<2){
			msgToBirth3.innerText = "[일 형식을 맞춰주세요!]";			
		}else{
			msgToBirth3.innerText = "";
		}
		
		if(memberBirth3==0 || memberBirth3>31){
			msgToBirth3.innerText = "[일은 1~31까지 입력가능합니다!]";			
		}else{
			msgToBirth3.innerText = "";
		}
	}
	
	function signin_birth_date3(){
		var signin_date = document.signinForm.memberBirth3;
		if( isNaN(signin_date.value) ) {
			alert("숫자만 입력가능합니다!")
			signin_date.value="";
		}
		
		if(signin_date.value.trim().length==2) {
			document.signinForm.memberPhone1.focus();
		}
	}
	
	function signin_phone_fst(){
		var signin_fst = document.signinForm.memberPhone1;
		var init_fst = "01X";
		
		if(signin_fst.value==init_fst) {
			signin_fst.value="";		
			document.getElementById("memberPhone1").style.color="black";
		}
	}
	
	function signin_phone_fst2(){
		var signin_fst = document.signinForm.memberPhone1;
		var init_fst = "01X";
		if(signin_fst.value.trim().length==0) {
			document.getElementById("memberPhone1").style.color="#E3E3E3";
			signin_fst.value = init_fst;			
		}		
		
		var msgToPhone1 = document.getElementById("phoneCheck1");
		var memberPhone1 = document.signinForm.memberPhone1.value;
		
		if(memberPhone1.trim().length<3 || memberPhone1>20){
			msgToPhone1.innerText = "[01X 형태로 입력하세요!]";
		}else{
			msgToPhone1.innerText = "";
		}
	}

	function signin_phone_fst3(){
		var signin_fst = document.signinForm.memberPhone1;	
		if( isNaN(signin_fst.value) ) {
			alert("숫자만 입력가능합니다!")
			signin_fst.value="";
		}
		
		if(signin_fst.value.trim().length==3) {
			document.signinForm.memberPhone2.focus();
		}
	}
	
	function signin_phone_mid(){
		var signin_mid = document.signinForm.memberPhone2;
		var init_mid = "XXXX";
		
		if(signin_mid.value==init_mid) {
			signin_mid.value="";		
			document.getElementById("memberPhone2").style.color="black";
		}
	}
	
	function signin_phone_mid2(){
		var signin_mid = document.signinForm.memberPhone2;
		var init_mid = "XXXX";
		if(signin_mid.value.trim().length==0) {
			document.getElementById("memberPhone2").style.color="#E3E3E3";
			signin_mid.value = init_mid;			
		}	
		
		var msgToPhone2 = document.getElementById("phoneCheck2");
		var memberPhone2 = document.signinForm.memberPhone2.value;
		
		if(memberPhone2.trim().length<3 || memberPhone2.trim().length>4){
			msgToPhone2.innerText = "[가운데자리 길이확인!]";
		}else{
			msgToPhone2.innerText = "";
		}
	}

	function signin_phone_mid3(){
		var signin_mid = document.signinForm.memberPhone2;	
		if( isNaN(signin_mid.value) ) {
			alert("숫자만 입력가능합니다!")
			signin_mid.value="";
		}
		
		if(signin_mid.value.trim().length==4) {
			document.signinForm.memberPhone3.focus();
		}
	}
	
	function signin_phone_end(){
		var signin_end = document.signinForm.memberPhone3;
		var init_end = "XXXX";
		
		if(signin_end.value==init_end) {
			signin_end.value="";		
			document.getElementById("memberPhone3").style.color="black";
		}
	}
	
	function signin_phone_end2(){
		var signin_end = document.signinForm.memberPhone3;
		var init_end = "XXXX";
		if(signin_end.value.trim().length==0) {
			document.getElementById("memberPhone3").style.color="#E3E3E3";
			signin_end.value = init_end;			
		}		
		
		var msgToPhone3 = document.getElementById("phoneCheck3");
		var memberPhone3 = document.signinForm.memberPhone3.value;
		
		if(memberPhone3.trim().length<4 || memberPhone3.trim().length>4){
			msgToPhone3.innerText = "[끝자리 길이확인!]";
		}else{
			msgToPhone3.innerText = "";
		}
	}
	
	function signin_phone_end3(){
		var signin_end = document.signinForm.memberPhone3;
		if( isNaN(signin_end.value) ) {
			alert("숫자만 입력가능합니다!")
			signin_end.value="";
		}
		
		if(signin_end.value.trim().length==4) {
			document.signinForm.memberAddress1.focus();
		}
	}
	
	function signin_address_dt(){
		var signin_address_dt = document.signinForm.memberAddress2;
		var init_address_dt = "상세주소(직접입력)";
		
		if(signin_address_dt.value==init_address_dt) {
			signin_address_dt.value="";		
			document.getElementById("memberAddress2").style.color="black";
		}
	}
	
	function signin_address_dt2(){
		var signin_address_dt = document.signinForm.memberAddress2;
		var init_address_dt = "상세주소(직접입력)";
		if(signin_address_dt.value.trim().length==0) {
			document.getElementById("memberAddress2").style.color="#E3E3E3";
			signin_address_dt.value = init_address_dt;			
		}			
	}
	
	function postService() {
		var url = 'postService.jsp';
		var winName = 'searchAddress';
		var winChar = 'top=100, left=300, height=500, width=800, resizable=no';
		var childWin = window.open(url, winName, winChar);		
	}

	function goback(){
		location.href="login.jsp";
	}
//=======================================================================
	//내정보 조회
//=======================================================================
	//비밀번호 변경
	function change_pw(){
		var change_pw = document.changePwForm.changePw;
		var init_pw = "변경할 비밀번호";
		
		if(change_pw.value==init_pw) {
			change_pw.value="";
			change_pw.type="password";
		}
	}
	
	function change_pw2(){
		var change_pw = document.changePwForm.changePw;
		var init_pw = "변경할 비밀번호";
		if(change_pw.value.trim().length==0) {
			change_pw.type="text";			
			change_pw.value = init_pw;			
		}	
		
		var msgToPw = document.getElementById("pwCheck");
		var changePw = document.changePwForm.changePw.value;
		var changePwChk = document.changePwForm.changePwChk.value;
		if(changePw.trim().length==0 || changePw=="변경할 비밀번호") {
			msgToPw.innerText = "[비밀번호 입력!]";
		}else if(changePw.trim().length<7) {
			msgToPw.innerText = "[길이 확인!]";	
		}else if(changePw != changePwChk) {
			msgToPw.innerText = "[비밀번호 불일치!!]";
		}else {			
			msgToPw.innerText = "";									
		}
	}
	
	function change_pwChk(){
		var change_pw = document.changePwForm.changePwChk;
		var init_pw = "변경할 비밀번호 확인";
		
		if(change_pw.value==init_pw) {
			change_pw.value="";
			change_pw.type="password";
		}
	}
	
	function change_pwChk2(){
		var change_pw = document.changePwForm.changePwChk;
		var init_pw = "변경할 비밀번호 확인";
		if(change_pw.value.trim().length==0) {
			change_pw.type="text";			
			change_pw.value = init_pw;	
		}	
		
		var msgToPw = document.getElementById("pwCheck");
		var changePw = document.changePwForm.changePw.value;
		var changePwChk = document.changePwForm.changePwChk.value;
		if(changePwChk.trim().length==0 || changePwChk=="변경할 비밀번호 확인") {
			msgToPw.innerText = "[비밀번호 입력!]";
		}else if(changePwChk.trim().length<7) {
			msgToPw.innerText = "[길이 확인!]";	
		}else if(changePw != changePwChk) {
			msgToPw.innerText = "[비밀번호 불일치!!]";
		}else {			
			msgToPw.innerText = "";									
		}
	}
	
//=======================================================================
	//아이디 찾기
	function idfind_name(){
		var idfind_name = document.idfindForm.memberName;
		var init_name = "이  름";
		
		if(idfind_name.value==init_name) {
			idfind_name.value="";		
			document.getElementById("memberName").style.color="black";
		}
	}
	
	function idfind_name2(){
		var idfind_name = document.idfindForm.memberName;
		var init_name = "이  름";
		if(idfind_name.value.trim().length==0) {
			document.getElementById("memberName").style.color="#E3E3E3";
			idfind_name.value = init_name;			
		}	
	}
	
	function idfind_birth_year(){
		var idfind_year = document.idfindForm.memberBirth1;
		var init_year = "'YYYY'";
		
		if(idfind_year.value==init_year) {
			idfind_year.value="";		
			document.getElementById("memberBirth1").style.color="black";
		}
	}
	
	function idfind_birth_year2(){
		var idfind_year = document.idfindForm.memberBirth1;
		var init_year = "'YYYY'";
		if(idfind_year.value.trim().length==0) {
			document.getElementById("memberBirth1").style.color="#E3E3E3";
			idfind_year.value = init_year;			
		}			
	}
	
	function idfind_birth_year3(){
		var idfind_year = document.idfindForm.memberBirth1;	
		if( isNaN(idfind_year.value) ) {
			alert("숫자만 입력가능합니다!")
			idfind_year.value="";
		}
		
		if(idfind_year.value.trim().length==4) {
			document.idfindForm.memberBirth2.focus();
		}
	}
	
	function idfind_birth_mth(){
		var idfind_mth = document.idfindForm.memberBirth2;
		var init_mth = "'MM'";
		
		if(idfind_mth.value==init_mth) {
			idfind_mth.value="";		
			document.getElementById("memberBirth2").style.color="black";
		}
	}
	
	function idfind_birth_mth2(){
		var idfind_mth = document.idfindForm.memberBirth2;
		var init_mth = "'MM'";
		if(idfind_mth.value.trim().length==0) {
			document.getElementById("memberBirth2").style.color="#E3E3E3";
			idfind_mth.value = init_mth;			
		}			
	}
	
	function idfind_birth_mth3(){
		var idfind_mth = document.idfindForm.memberBirth2;	
		if( isNaN(idfind_mth.value) ) {
			alert("숫자만 입력가능합니다!")
			idfind_mth.value="";
		}
		
		if(idfind_mth.value.trim().length==2) {
			document.idfindForm.memberBirth3.focus();
		}
	}
	
	function idfind_birth_date(){
		var idfind_date = document.idfindForm.memberBirth3;
		var init_date = "'DD'";
		
		if(idfind_date.value==init_date) {
			idfind_date.value="";		
			document.getElementById("memberBirth3").style.color="black";
		}
	}
	
	function idfind_birth_date2(){
		var idfind_date = document.idfindForm.memberBirth3;
		var init_date = "'DD'";
		if( isNaN(idfind_date.value) ) {
			alert("숫자만 입력가능합니다!")
			idfind_date.value="";
		}
	}

	function idfind_birth_date3(){
		var idfind_date = document.idfindForm.memberBirth3;
		var init_date = "'DD'";
		if(idfind_date.value.trim().length==0) {
			document.getElementById("memberBirth3").style.color="#E3E3E3";
			idfind_date.value = init_date;			
		}			
	}	
	
	
	
//=======================================================================	
	//아이디/비밀번호 찾기 주요 버튼 설정
	
	function goSignin(){
		location.href = "signin.jsp";
	}
	
	function goback(){
		location.href = "login.jsp";		
	}

	function goPwfind(){
		location.href = "pwfind.jsp";				
	}
	
	function goIdfind(){
		location.href = "idfind.jsp";				
	}
	
//=======================================================================
	//비밀번호 찾기 
	function pwfind_id(){
		var pwfind_id = document.pwfindForm.memberId;
		var init_id = "아 이 디";
		
		if(pwfind_id.value==init_id) {
			pwfind_id.value="";		
			document.getElementById("memberId").style.color="black";
		}
	}
	
	function pwfind_id2(memberId){
		var pwfind_id = document.pwfindForm.memberId;
		var init_id = "아 이 디";
		if(pwfind_id.value.trim().length==0) {
			document.getElementById("memberId").style.color="#E3E3E3";
			pwfind_id.value = init_id;			
		}	
	}
	
	function pwfind_email(){
		var pwfind_email = document.pwfindForm.memberId2;
		var init_email = "이메일 주소";
		
		if(pwfind_email.value==init_email) {
			pwfind_email.value="";		
			document.getElementById("memberId2").style.color="black";
		}
	}
	
	function pwfind_email2(){
		var pwfind_email = document.pwfindForm.memberId2;
		var init_email = "이메일 주소";
		if(pwfind_email.value.trim().length==0) {
			document.getElementById("memberId2").style.color="#E3E3E3";
			pwfind_email.value = init_email;			
		}	
	}
	
	function pwfind_birth_year(){
		var pwfind_year = document.pwfindForm.memberBirth1;
		var init_year = "'YYYY'";
		
		if(pwfind_year.value==init_year) {
			pwfind_year.value="";		
			document.getElementById("memberBirth1").style.color="black";
		}
	}
	
	function pwfind_birth_year2(){
		var pwfind_year = document.pwfindForm.memberBirth1;
		var init_year = "'YYYY'";
		if(pwfind_year.value.trim().length==0) {
			document.getElementById("memberBirth1").style.color="#E3E3E3";
			pwfind_year.value = init_year;			
		}			
	}
	
	function pwfind_birth_year3(){
		var pwfind_year = document.pwfindForm.memberBirth1;	
		if( isNaN(pwfind_year.value) ) {
			alert("숫자만 입력가능합니다!")
			pwfind_year.value="";
		}
		
		if(pwfind_year.value.trim().length==4) {
			document.pwfindForm.memberBirth2.focus();
		}
	}
	
	function pwfind_birth_mth(){
		var pwfind_mth = document.pwfindForm.memberBirth2;
		var init_mth = "'MM'";
		
		if(pwfind_mth.value==init_mth) {
			pwfind_mth.value="";		
			document.getElementById("memberBirth2").style.color="black";
		}
	}
	
	function pwfind_birth_mth2(){
		var pwfind_mth = document.pwfindForm.memberBirth2;
		var init_mth = "'MM'";
		if(pwfind_mth.value.trim().length==0) {
			document.getElementById("memberBirth2").style.color="#E3E3E3";
			pwfind_mth.value = init_mth;			
		}			
	}
	
	function pwfind_birth_mth3(){
		var pwfind_mth = document.pwfindForm.memberBirth2;	
		if( isNaN(pwfind_mth.value) ) {
			alert("숫자만 입력가능합니다!")
			pwfind_mth.value="";
		}
		
		if(pwfind_mth.value.trim().length==2) {
			document.pwfindForm.memberBirth3.focus();
		}
	}
	
	function pwfind_birth_date(){
		var pwfind_date = document.pwfindForm.memberBirth3;
		var init_date = "'DD'";
		
		if(pwfind_date.value==init_date) {
			pwfind_date.value="";		
			document.getElementById("memberBirth3").style.color="black";
		}
	}
	
	function pwfind_birth_date2(){
		var pwfind_date = document.pwfindForm.memberBirth3;
		var init_date = "'DD'";
		if( isNaN(pwfind_date.value) ) {
			alert("숫자만 입력가능합니다!")
			pwfind_date.value="";
		}
		
		if(pwfind_date.value.trim().length==2) {
			document.pwfindForm.memberPhone1.focus();
		}
	}
	
	function pwfind_birth_date3(){
		var pwfind_date = document.pwfindForm.memberBirth3;
		var init_date = "'DD'";
		if(pwfind_date.value.trim().length==0) {
			document.getElementById("memberBirth3").style.color="#E3E3E3";
			pwfind_date.value = init_date;			
		}			
	}	

	function pwfind_phone_fst(){
		var pwfind_fst = document.pwfindForm.memberPhone1;
		var init_fst = "01X";
		
		if(pwfind_fst.value==init_fst) {
			pwfind_fst.value="";		
			document.getElementById("memberPhone1").style.color="black";
		}
	}
	
	function pwfind_phone_fst2(){
		var pwfind_fst = document.pwfindForm.memberPhone1;
		var init_fst = "01X";
		if(pwfind_fst.value.trim().length==0) {
			document.getElementById("memberPhone1").style.color="#E3E3E3";
			pwfind_fst.value = init_fst;			
		}			
	}

	function pwfind_phone_fst3(){
		var pwfind_fst = document.pwfindForm.memberPhone1;	
		if( isNaN(pwfind_fst.value) ) {
			alert("숫자만 입력가능합니다!")
			pwfind_fst.value="";
		}
		
		if(pwfind_fst.value.trim().length==3) {
			document.pwfindForm.memberPhone2.focus();
		}
	}
	
	function pwfind_phone_mid(){
		var pwfind_mid = document.pwfindForm.memberPhone2;
		var init_mid = "XXXX";
		
		if(pwfind_mid.value==init_mid) {
			pwfind_mid.value="";		
			document.getElementById("memberPhone2").style.color="black";
		}
	}
	
	function pwfind_phone_mid2(){
		var pwfind_mid = document.pwfindForm.memberPhone2;
		var init_mid = "XXXX";
		if(pwfind_mid.value.trim().length==0) {
			document.getElementById("memberPhone2").style.color="#E3E3E3";
			pwfind_mid.value = init_mid;			
		}			
	}

	function pwfind_phone_mid3(){
		var pwfind_mid = document.pwfindForm.memberPhone2;	
		if( isNaN(pwfind_mid.value) ) {
			alert("숫자만 입력가능합니다!")
			pwfind_mid.value="";
		}
		
		if(pwfind_mid.value.trim().length==4) {
			document.pwfindForm.memberPhone3.focus();
		}
	}
	
	function pwfind_phone_end(){
		var pwfind_end = document.pwfindForm.memberPhone3;
		var init_end = "XXXX";
		
		if(pwfind_end.value==init_end) {
			pwfind_end.value="";		
			document.getElementById("memberPhone3").style.color="black";
		}
	}
	
	function pwfind_phone_end2(){
		var pwfind_end = document.pwfindForm.memberPhone3;
		var init_end = "XXXX";
		if(pwfind_end.value.trim().length==0) {
			document.getElementById("memberPhone3").style.color="#E3E3E3";
			pwfind_end.value = init_end;			
		}			
	}
	
	function pwfind_phone_end3(){
		var pwfind_end = document.pwfindForm.memberPhone3;
		if( isNaN(pwfind_end.value) ) {
			alert("숫자만 입력가능합니다!")
			pwfind_end.value="";
		}
	}
	
	
	