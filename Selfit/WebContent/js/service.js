function checkAll() {
	var element = document.categories.cb_category;
	for (var i = 0; i < element.length; i++){
		element[i].checked = true;
	}
}

function viewMore(takeData) {
	var element = document.getElementById(takeData);
	if (element.style.display == 'none') {
		element.style.display = 'block';
	} else {
		element.style.display = 'none';
	}
}

function categoriesSubmit() {
	var element = document.categories.cb_category;
	var msg = document.getElementById('errMsg');
	for (var i = 0; i < element.length; i++){
		if (element[i].checked) {
			return true;
		}
	}
	msg.innerText = "내용을 선택한 후  조회하여 주십시요!";
	return false;
}
