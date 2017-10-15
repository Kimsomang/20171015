function bodyIdValue() {
	var bodyId = document.bodyForm.bodysId;
	var idCheck = document.getElementById("bodyIdCheck");
	
	if(bodyId.value.trim().length == 0) {
		idCheck.innerText = "[체형식별번호는 필수 입력사항입니다!]";
	} else {
		idCheck.innerText = "";
	}
}

function bodyNameValue() {
	var bodyName = document.bodyForm.bodysName;
	var nameCheck = document.getElementById("bodyNameCheck");
	
	if(bodyName.value.trim().length == 0) {
		nameCheck.innerText = "[삽입시 체형이름은 필수 입력사항입니다!]";
	} else {
		nameCheck.innerText = "";
	}
}

function insertBody() {
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "action");
	input.setAttribute("value", "insertBody");
	document.getElementById("bt_insert").appendChild(input);
	document.bodyForm.submit();
}

function deleteBody() {
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "action");
	input.setAttribute("value", "deleteBody");
	document.getElementById("bt_delete").appendChild(input);
	document.bodyForm.submit();
}

function brandIdValue() {
	var brandId = document.brandForm.brandsId;
	var idCheck = document.getElementById("brandIdCheck");
	
	if(brandId.value.trim().length == 0) {
		idCheck.innerText = "[브랜드식별번호는 필수 입력사항입니다!]";
	} else {
		idCheck.innerText = "";
	}
}

function brandNameValue() {
	var brandName = document.brandForm.brandsName;
	var nameCheck = document.getElementById("brandNameCheck");
	
	if(brandName.value.trim().length == 0) {
		nameCheck.innerText = "[삽입시 브랜드명은 필수 입력사항입니다!]";
	} else {
		nameCheck.innerText = "";
	}
}

function insertBrand() {
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "action");
	input.setAttribute("value", "insertBrand");
	
	document.getElementById("bt_insert").appendChild(input);
	
	document.brandForm.submit();
}

function deleteBrand() {
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "action");
	input.setAttribute("value", "deleteBrand");
	
	document.getElementById("bt_delete").appendChild(input);
	
	document.brandForm.submit();
}

function categoryIdValue() {
	var categoryId = document.categoryForm.categoriesId;
	var idCheck = document.getElementById("categoryIdCheck");
	
	if(categoryId.value.trim().length == 0) {
		idCheck.innerText = "[카테고리식별번호는 필수 입력사항입니다!]";
	} else {
		idCheck.innerText = "";
	}
}

function categoryNameValue() {
	var categoryName = document.categoryForm.categoriesName;
	var nameCheck = document.getElementById("categoryNameCheck");
	
	if(categoryName.value.trim().length == 0) {
		nameCheck.innerText = "[삽입시 카테고리명은 필수 입력사항입니다!]";
	} else {
		nameCheck.innerText = "";
	}
}

function insertCategory() {
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "action");
	input.setAttribute("value", "insertCategory");
	
	document.getElementById("bt_insert").appendChild(input);
	
	document.categoryForm.submit();
}

function deleteCategory() {
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "action");
	input.setAttribute("value", "deleteCategory");
	
	document.getElementById("bt_delete").appendChild(input);
	
	document.categoryForm.submit();
}