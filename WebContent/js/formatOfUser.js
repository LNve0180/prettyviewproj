/**
 * 
 */

function checkUserOldPassword() {
	var userOldPassword=document.getElementById("userOldPassword").value;
	var xmlHttpRequest = null;
	var url="userOldPassword="+userOldPassword+"&method=checkUserOldPasswordByUserID";
	if(userOldPassword==""){
		return false;
	}else{
		if (window.XMLHttpRequest) {
			xmlHttpRequest = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttpRequest.open("post","UserServlet", true);
		xmlHttpRequest.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttpRequest.send(url);
		xmlHttpRequest.onreadystatechange = function() {
			if (xmlHttpRequest.readyState == 4) {
				if (xmlHttpRequest.status == 200) {
					if (xmlHttpRequest.responseText=="1") {
						document.getElementById("alterUserPasswordButton").disabled=false;
					} else {
						alert("用户输入的旧密码不正确");
					}
				}
			}
		};
	}
	
}


function checkUserIsExist() {
	var userID=document.getElementById("userID").value;
	var xmlHttpRequest = null;
	var url="userID="+userID+"&method=searchUserInfoIsExist";
	if(userID==""){
		return false;
	}else{
		if (window.XMLHttpRequest) {
			xmlHttpRequest = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlHttpRequest.open("post","UserServlet", true);
		xmlHttpRequest.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttpRequest.send(url);
		xmlHttpRequest.onreadystatechange = function() {
			if (xmlHttpRequest.readyState == 4) {
				if (xmlHttpRequest.status == 200) {
					if (xmlHttpRequest.responseText=="1") {
						document.getElementById("userLoginBtn").disabled=false;
					} else {
						alert("输入的账户不存在");
					}
				}
			}
		};
	}
	
}



function checkUserID(){
		
	var userID=document.getElementById('userID').value;
	
	var len = userID.length;
	
	alert(len);
	if(userID==null||userID.length==0 || len>=12)
	{
		if(len>=12){
			
			
			
			return false;
		} else{
			
			
			return false;
		}

	}
	else
	{
		var reg = new RegExp("^[0-9]*$");
		if(reg.test(userID))
	return true;
		else
		{
			
		return false;
		}
	}

		
}



function checkPassword(){
	
	var pwd =document.getElementById('userPassword').value;
	
	var len = pwd.length;
	
	alert(len);
	
	if(pwd==null||pwd.length==0 || len>=16)
	{
		
		if(len>=16){
			
		
			
			return false;
		}else{
			
			
			
			return false;
			
		}
		
	}else{
		
		var reg = new RegExp("^[A-Za-z0-9]+$");
		
		if(reg.test(pwd))
		
		return true
		
		else
		
		{
		
			return false;
		}
	}
	
}






function checkUserName(){
	
	var name =document.getElementById('userName').value;
	
	var len = name.length;
	
	alert(len);
	 
	if(name==null||name.length==0 || len>=11){
		
		if(len>=11){
			
			
			
			return false;
			
		}else{
			
			
			
			return false;
			
		}
		
		
	}else{
		
		var reg = new RegExp("^[A-Za-z0-9]+$");
		
		if(reg.test(name)){
			
			return true;
			
		}else{
			
			
			
			return false;
			
		}
		
	}
	
	
}


function checkEmail(){
	
	
	var email =document.getElementById('userEmail').value;
	
	var len = email.length;
	

	 
	if(email==null||email.length==0 || len>=26){
		
		if(len>=26){
			
		
			
			return false;
			
		}else{
			
		
			
			return false;
			
		}
		
		
	}else{
		
		var reg=/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
		
		if(reg.test(email)){
			
		
			
			return true;
		} else {
			
		
			return false;
			
		}
		
	}
	
	
}


function checkPhone(){
	
	var phone = document.getElementById('userPhone').value;
	
	var len = phone.length;
	
	alert(len);
	
	if(phone==null||phone.length==0 || len>=12){
		
		if(len>=12){
			
			
			
			return false;
			
		}else{
			
			
			
			return false;
			
		}
		
		
	} else{
		
		var reg = /^1[3|4|5|6|7|8][0-9]{9}$/i ;
		
		if(reg.test(phone)){
			
			
			
			return true;
			
		}else{
			
			
			
			return false;
			
		}
		
		
		
	}
	
	
	
	
	
}


function checkInroduction(){
	
	var inroduction = document.getElementById('userIntroduction').value; 
	
	var len = inroduction.length;
	
	
	if(inroduction==null||inroduction.length==0 || len>=101){
		
		if(len>=101){
			
		
			
			return false;
			
		}else{
			
		
			
			return false;
			
		}
	
	}else{

		return true;
		
	}
	
}



function userLoginCheck(){
	if(checkUserID()&&checkPassword()){
		return true;
	}
	else
	{
		alert("输入内容存在格式错误");
		return false;
	}
}

function alterUserInfocheck(){
	if(checkUserName()&&checkEmail()&&checkPhone()&&checkInroduction())
		{
		return true;
		}
	else{
		return false;
	}
}

