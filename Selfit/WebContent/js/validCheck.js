//==================================================================================================
	//로그인 유효성 검사
	function checkLogin(){
			var login_id = document.loginForm.loginId;
			var login_pw = document.loginForm.loginPw;
			var idMsg = document.getElementById("idCheck");
			var pwMsg = document.getElementById("pwCheck");
			if(login_id==null || login_id.value.trim().length==0 || login_id.value=="아 이 디(이메일 주소)"){
				idMsg.innerText = "아이디 필수 입력!";
			}else {
				idMsg.innerText = "";
			}
			
			if(login_pw==null || login_pw.value.trim().length==0 || login_pw.value=="비 밀 번 호"){
				pwMsg.innerText = "비밀번호 필수 입력!";
			}else {
				pwMsg.innerText = "";
			}
			
			if(idMsg.innerText.length>0 || pwMsg.innerText.length>0){
				return false;
			}
	}
	
//==================================================================================================
	//회원가입 유효성 검사(필수항목 및 길이 제한)
	function essCheck(){
		var signin_id = document.signinForm.memberId1;
		var signin_email = document.signinForm.memberId2;
		var signin_pw = document.signinForm.memberPw;
		var signin_name = document.signinForm.memberName;
		var signin_year = document.signinForm.memberBirth1;
		var signin_mth = document.signinForm.memberBirth2;
		var signin_date = document.signinForm.memberBirth3;
		var signin_sex = document.signinForm.memberSex;
		var signin_phone_fst = document.signinForm.memberPhone1;
		var signin_phone_mid = document.signinForm.memberPhone2;
		var signin_Phone_end = document.signinForm.memberPhone3;
		var signin_post = document.signinForm.memberPost;
		var signin_address1 = document.signinForm.memberAddress1;
		var signin_address2 = document.signinForm.memberAddress2;
		var signin_body = document.signinForm.memberBody;
		var signMsg = document.getElementById("essMsg");
		var testMsg = "";
		
		if(signin_id!=null && signin_id.value.trim().length>0 && signin_id.value!="아 이 디" &&
		   signin_email!=null && signin_email.value.trim().length>0 && signin_email.value!="이메일 주소"){
			testMsg = testMsg + "";
		}else{
			testMsg = testMsg + "아이디 ";
		}
		
		if(signin_pw!=null && signin_pw.value.trim().length>0 && signin_pw.value!="비 밀 번 호"){
			testMsg = testMsg + "";
		}else{			
			testMsg = testMsg + "비밀번호 ";
		}
		
		if(signin_name!=null && signin_name.value.trim().length>0 && signin_name.value!="이  름"){
			testMsg = testMsg + "";
		}else{			
			testMsg = testMsg + "이름 ";
		}
		
		if(signin_year!=null && signin_year.value.trim().length>0 && signin_year.value!="'YYYY'" &&
		   signin_mth!=null && signin_mth.value.trim().length>0 && signin_mth.value!="'MM'" &&
		   signin_date!=null && signin_date.value.trim().length>0 && signin_date.value!="'DD'"){
			testMsg = testMsg + "";			
		}else{
			testMsg = testMsg + "생년월일 ";
		}
		
		if(signin_sex!=null && signin_sex.value.length!=0){
			testMsg = testMsg + "";
		}else{			
			testMsg = testMsg + "성별 ";
		}
		
		if(signin_phone_fst!=null && signin_phone_fst.value.trim().length>0 && signin_phone_fst.value!="01X" &&
		   signin_phone_mid!=null && signin_phone_mid.value.trim().length>0 && signin_phone_mid.value!="XXXX" &&
		   signin_Phone_end!=null && signin_Phone_end.value.trim().length>0 && signin_Phone_end.value!="XXXX"){
			testMsg = testMsg + "";			
		}else{
			testMsg = testMsg + "전화번호 ";
		}
		
		if(signin_post!=null && signin_post.value.trim().length>0 && signin_post.value!="우편번호" &&
				signin_address1!=null && signin_address1.value.trim().length>0 && signin_address1.value!="우편번호 포함된 주소" &&
				signin_address2!=null && signin_address2.value.trim().length>0 && signin_address2.value!="상세주소(직접입력)"){
			testMsg = testMsg + "";			
		}else{
			testMsg = testMsg + "주소 ";
		}
		
		if(signin_body!=null && signin_body.value.length!=0){
			testMsg = testMsg + "";
		}else{			
			testMsg = testMsg + "체형 ";
		}
				
		if(testMsg.trim().length>0){
			testMsg = testMsg + "(은)는 필수 입력 항목입니다!"
			signMsg.innerText = testMsg;
			return false;
		}else{
			alert('회원가입되셨습니다.');
			return true;
		}
		
		var msgToId = document.getElementById("idCheck");
		var msgToPw = document.getElementById("pwCheck");
		var msgToName = document.getElementById("nameCheck");
		var msgToBirth = document.getElementById("birthCheck");
		var msgToPhone = document.getElementById("phoneCheck");
		var valMsg = document.getElementById("validMsg");
		
		if(msgToId.innerText.length>0 || msgToPw.innerText.length>0 || msgToName.innerText.length>0
				|| msgToBirth.innerText.length>0 || msgToPhone.innerText.length>0){
			valMsg.innerText = "[각 항목 형식을 확인해주시기 바랍니다!]";
			return false;
		}
		
		return false;
	}

//==================================================================================================
	//아이디 찾기 필수항목 체크
	function searchId(){
		var idfind_name = document.idfindForm.memberName;
		var idfind_year = document.idfindForm.memberBirth1;
		var idfind_mth = document.idfindForm.memberBirth2;
		var idfind_date = document.idfindForm.memberBirth3;
		var nameMsg = document.getElementById("nameCheck");
		var birthMsg = document.getElementById("birthCheck");
		
		if(idfind_name!=null && idfind_name.value.trim().length>0 && idfind_name.value!="이  름"){
			nameMsg.innerText = "";
		}else{			
			nameMsg.innerText = "이름 필수 입력!";
		}
		
		if(idfind_year!=null && idfind_year.value.trim().length>0 && idfind_year.value!="'YYYY'" &&
		   idfind_mth!=null && idfind_mth.value.trim().length>0 && idfind_mth.value!="'MM'" &&
		   idfind_date!=null && idfind_date.value.trim().length>0 && idfind_date.value!="'DD'"){
			birthMsg.innerText = "";			
		}else{
			birthMsg.innerText = "생년월일 필수 입력!";
		}
		
		if(nameMsg.innerText.length>0 || birthMsg.innerText.length>0){
			return false;
		}
	}
	
//==================================================================================================
	//비밀번호 찾기 필수항목 체크
	function searchPw(){
		var pwfind_id = document.pwfindForm.memberId;
		var pwfind_email = document.pwfindForm.memberId2;
		var pwfind_year = document.pwfindForm.memberBirth1;
		var pwfind_mth = document.pwfindForm.memberBirth2;
		var pwfind_date = document.pwfindForm.memberBirth3;
		var pwfind_phone_fst = document.pwfindForm.memberPhone1;
		var pwfind_phone_mid = document.pwfindForm.memberPhone2;
		var pwfind_Phone_end = document.pwfindForm.memberPhone3;
		var idMsg = document.getElementById("idCheck");
		var birthMsg = document.getElementById("birthCheck");
		var phoneMsg = document.getElementById("phoneCheck");
		
		if(pwfind_id!=null && pwfind_id.value.trim().length>0 && pwfind_id.value!="아 이 디" &&
		   pwfind_email!=null && pwfind_email.value.trim().length>0 && pwfind_email.value!="이메일 주소"){
			idMsg.innerText = "";
		}else{			
			idMsg.innerText = "아이디 필수 입력!";
		}
		
		if(pwfind_year!=null && pwfind_year.value.trim().length>0 && pwfind_year.value!="'YYYY'" &&
		   pwfind_mth!=null && pwfind_mth.value.trim().length>0 && pwfind_mth.value!="'MM'" &&
		   pwfind_date!=null && pwfind_date.value.trim().length>0 && pwfind_date.value!="'DD'"){
			birthMsg.innerText = "";			
		}else{
			birthMsg.innerText = "생년월일 필수 입력!";
		}
		
		if(pwfind_phone_fst!=null && pwfind_phone_fst.value.trim().length>0 && pwfind_phone_fst.value!="01X" &&
		   pwfind_phone_mid!=null && pwfind_phone_mid.value.trim().length>0 && pwfind_phone_mid.value!="XXXX" &&
		   pwfind_Phone_end!=null && pwfind_Phone_end.value.trim().length>0 && pwfind_Phone_end.value!="XXXX"){
			phoneMsg.innerText = "";			
		}else{
			phoneMsg.innerText = "전화번호 필수 입력!";
		}
		
		if(idMsg.innerText.length>0 || birthMsg.innerText.length>0 || phoneMsg.innerText.length>0){
			return false;
		}
	}
	
	
	