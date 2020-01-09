$(document).ready(function() {
	//获取用户登录信息
	onloadUserInfo();
	
	
	var data = localStorage.getItem("loginUserInfo");
	var loginUserInfo = JSON.parse(data);
	$(".alterUserInfoContent #userName").val(loginUserInfo.userName);
	if(loginUserInfo.userSex=="女"){
		$(".alterUserInfoContent #sexWomen").attr("checked","checked");
	}else{
		$(".alterUserInfoContent #sexMen").attr("checked","checked");
	}
	
	//获取性别
	//var userSex=$("input[name=userSex]:checked").val();
	$(".alterUserInfoContent #userEmail").val(loginUserInfo.userEmail);
	$(".alterUserInfoContent #userPhone").val(loginUserInfo.userPhone);
	$(".alterUserInfoContent #userOccupation").val(loginUserInfo.userOccupation);
	$(".alterUserInfoContent #userIntroduction").val(loginUserInfo.userIntroduction);
	
	
	$("#alterUserInfoButton").click(function() {
		var userName=$(".alterUserInfoContent #userName").val();			
		var userSex=$(".alterUserInfoContent input[name=userSex]:checked").val();
		var userEmail=$(".alterUserInfoContent #userEmail").val();
		var userPhone=$(".alterUserInfoContent #userPhone").val();
		var userOccupation=$(".alterUserInfoContent #userOccupation").val();
		var userIntroduction=$(".alterUserInfoContent #userIntroduction").val();
		if(!userName||!userSex||!userEmail||!userPhone||!userOccupation||!userIntroduction)
		{
			alert("用户输入的内容存在格式错误");
		}else
		{
				$.ajax({
					type : "post",
					url : "UserServlet?method=modifyUserInfoByUserInfo",
					async : false,
					dataType : "json",
					data : {
						"userName" : userName,
						"userSex" : userSex,
						"userEmail" : userEmail,
						"userPhone" : userPhone,
						"userOccupation" : userOccupation,
						"userIntroduction" : userIntroduction
					},
					success : function(data) {
						// alert(data);
						if (data == "false") {
							alert("用户修改基本信息失败");
						}else{
							alert("用户修改基本信息成功");
							var dataTemp={
									"userID" : loginUserInfo.userID,
									"userName" : userName,
									"userPassword" : loginUserInfo.userPassword,
									"userSex" : userSex,
									"userEmail" : userEmail,
									"userPhone" : userPhone,
									"userOccupation" : userOccupation,
									"userIntroduction" : userIntroduction,
									"userHeadPhoto":loginUserInfo.userHeadPhoto,
									"userIDStatus":loginUserInfo.userIDStatus,
									"creatorStatus":loginUserInfo.creatorStatus
									};
							localStorage.setItem("loginUserInfo",JSON.stringify(dataTemp));
							location.reload();
							//window.location.href="handleForm.jsp";
						} 
					}
				});	
		}
	});
	
	
	
	//获取用户登录信息
	function onloadUserInfo(){
		//从localStorage获取
		var data = localStorage.getItem("loginUserInfo");
		var userLoginInfo = JSON.parse(data);
		if(data !=null && data != "" && data.length > 0){
			$("div.information-headimg-box").children("img").attr("src",userLoginInfo.userHeadPhoto);
			$("div.information-content").children("p.user-nick-name").html(userLoginInfo.userName);
			$("div.information-content").children("p.user-occupation").html(userLoginInfo.userOccupation);
			$("div.information-content").children("p.user-introduction").html(userLoginInfo.userIntroduction);
			
			//写入导航头
			$("li.dropdown").children("a").children("img").attr("src",userLoginInfo.userHeadPhoto);
			$("li.dropdown").children("a").children("#nav-userName").html(userLoginInfo.userName);
			//写入span.userID 包含//判断左边栏
			$("span.userID").html(userLoginInfo.userID);
			if(userLoginInfo.creatorStatus == 1){
				$("li.li-myWorks").css('display','block');
				$("a.myWorks").css('display','block');
			}
			if(userLoginInfo.creatorStatus != 1){
				$("li.li-applyCreator").css('display','block');
				$("a.applyCreator").css('display','block');
			}
			
		}
	}
	
	
	
});