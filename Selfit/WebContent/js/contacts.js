function init() {
	document.getElementById("corpName").focus();
}

function corpNameValue() {
	var corpName = document.contactForm.corpName;
	var nameCheck = document.getElementById("corpNameCheck");
	
	if(corpName.value.trim().length == 0) {
		nameCheck.innerText = "[업체명은 필수 입력사항입니다!]";
	} else {
		nameCheck.innerText = "";
	}
}

function corpManagerValue() {
	var corpManager = document.contactForm.corpManager;
	var managerCheck = document.getElementById("corpManagerCheck");
	
	if(corpManager.value.trim().length == 0) {
		managerCheck.innerText = "[담당자는 필수 입력사항입니다!]";
	} else {
		managerCheck.innerText = "";
	}
}

function emailValue() {
	var email = document.contactForm.email;
	var emailCheck = document.getElementById("emailCheck");
	
	if(email.value.trim().length == 0) {
		emailCheck.innerText = "[이메일은 필수 입력사항입니다!]";
	} else {
		emailCheck.innerText = "";
	}
}

function phone_fst() {
	var phone1 = document.contactForm.phone1;
	var init_fst = "01X";
	
	if(phone1.value==init_fst) {
		phone1.value="";		
		document.getElementById("phone1").style.color="black";
	}
}

function phone_fst2() {
	var phone1 = document.contactForm.phone1;
	var init_fst = "01X";
	if(phone1.value.trim().length==0) {
		document.getElementById("phone1").style.color="#E3E3E3";
		phone1.value = init_fst;			
	}		
	
	var msgToPhone1 = document.getElementById("phoneCheck1");
	var phone1 = document.contactForm.phone1.value;
	
	if(phone1.trim().length<3 || phone1>20){
		msgToPhone1.innerText = "[01X 형태로 입력하세요!]";
	}else{
		msgToPhone1.innerText = "";
	}
}

function phone_fst3() {
	var phone1 = document.contactForm.phone1;	
	if( isNaN(phone1.value) ) {
		alert("숫자만 입력가능합니다!");
		phone1.value="";
	}
	
	if(phone1.value.trim().length==3) {
		document.contactForm.phone2.focus();
	}
}

function phone_mid() {
	var phone2 = document.contactForm.phone2;
	var init_mid = "XXXX";
	
	if(phone2.value==init_mid) {
		phone2.value="";		
		document.getElementById("phone2").style.color="black";
	}
}

function phone_mid2() {
	var phone2 = document.contactForm.phone2;
	var init_mid = "XXXX";
	if(phone2.value.trim().length==0) {
		document.getElementById("phone2").style.color="#E3E3E3";
		phone2.value = init_mid;			
	}	
	
	var msgToPhone2 = document.getElementById("phoneCheck2");
	var phone2 = document.contactForm.phone2.value;
	
	if(phone2.trim().length<3 || phone2.trim().length>4){
		msgToPhone2.innerText = "[가운데자리 길이를 확인해주세요!]";
	}else{
		msgToPhone2.innerText = "";
	}
}

function phone_mid3() {
	var phone2 = document.contactForm.phone2;	
	if( isNaN(phone2.value) ) {
		alert("숫자만 입력가능합니다!");
		phone2.value="";
	}
	
	if(phone2.value.trim().length==4) {
		document.contactForm.phone3.focus();
	}
}

function phone_end() {
	var phone3 = document.contactForm.phone3;
	var init_end = "XXXX";
	
	if(phone3.value==init_end) {
		phone3.value="";		
		document.getElementById("phone3").style.color="black";
	}
}

function phone_end2() {
	var phone3 = document.contactForm.phone3;
	var init_end = "XXXX";
	if(phone3.value.trim().length==0) {
		document.getElementById("phone3").style.color="#E3E3E3";
		phone3.value = init_end;			
	}		
	
	var msgToPhone3 = document.getElementById("phoneCheck3");
	var phone3 = document.contactForm.phone3.value;
	
	if(phone3.trim().length<4 || phone3.trim().length>4){
		msgToPhone3.innerText = "[끝자리 길이를 확인해주세요!]";
	}else{
		msgToPhone3.innerText = "";
	}
}

function phone_end3() {
	var phone3 = document.contactForm.phone3;
	if( isNaN(phone3.value) ) {
		alert("숫자만 입력가능합니다!");
		phone3.value="";
	}
	
	if(phone3.value.trim().length==4) {
		document.contactForm.email.focus();
	}
}

function enroll() {
	var corpName = document.contactForm.corpName;
	var corpManager = document.contactForm.corpManager;
	var email = document.contactForm.email;
	var phone1 = document.contactForm.phone1;
	var phone2 = document.contactForm.phone2;
	var phone3 = document.contactForm.phone3;
	
	if(corpName.value.trim().length == 0) {
		var nameCheck = document.getElementById("corpNameCheck");
		nameCheck.innerText = "[업체명은 필수 입력사항입니다!]";
		corpName.focus();
		return false;
	}
	
	if(corpManager.value.trim().length == 0) {
		var managerCheck = document.getElementById("corpManagerCheck");
		managerCheck.innerText = "[담당자는 필수 입력사항입니다!]";
		corpManager.focus();
		return false;
	}
	
	if(email.value.trim().length == 0) {
		var emailCheck = document.getElementById("emailCheck");
		emailCheck.innerText = "[이메일은 필수 입력사항입니다!]";
		email.focus();
		return false;
	}
	
	alert("문의 등록이 완료되었습니다!");
	return true;
	
}