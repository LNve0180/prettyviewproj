function changeIDCardFace() {
	var r = new FileReader();
	f = document.getElementById('uploadimg-face').files[0];
	r.readAsDataURL(f);
	r.onload = function(e) {
		document.getElementById('front-box').src = this.result;
	};
}

function changeIDCardBack() {
	var r = new FileReader();
	f = document.getElementById('uploadimg-back').files[0];
	r.readAsDataURL(f);
	r.onload = function(e) {
		document.getElementById('back-box').src = this.result;
	};
}
