$(document).ready(function() {
	//获取用户登录信息
	onloadUserInfo();
	
	$("#alterUserPasswordButton").click(function() {
		var userOldPassword=$("#oldUserPassword").val();			
		var newUserPassword=$("#newUserPassword").val();
		var repeatNewUserPassword=$("#repeatNewUserPassword").val();
		
		if(!oldUserPassword||!newUserPassword||!repeatNewUserPassword)
		{
			alert("用户输入的内容存在格式错误");
		}else
		{
			if(newUserPassword!=repeatNewUserPassword)
				{
				alert("用户输入的两次新密码不一样");
				}
			else{
				$.ajax({
					type : "post",
					url : "UserServlet?method=checkUserOldPasswordByUserID",
					async : true,
					dataType : "json",
					data : {
						"userOldPassword" : userOldPassword
					},
					success : function(data) {
						// alert(data);
						if (data == "false") {
							alert("用户输入的旧密码不正确");
						}else{
							$.ajax({
								type : "post",
								url : "UserServlet?method=modifyUserPasswordByUserID",
								async : true,
								dataType : "json",
								data : {
									"userNewPassword" : newUserPassword
								},
								success : function(data) {
									// alert(data);
									if (data == "false") {
										alert("用户修改密码失败");
									}else{
										alert("用户修改密码成功");
										location.reload();
									} 
								}
							});	
							
							
							
							
							
						} 
					}
				});	
			}
			//else结束
		}
	});
	
	
	
	//获取用户登录信息
	function onloadUserInfo(){
		//从localStorage获取
		var data = localStorage.getItem("loginUserInfo");
		var userLoginInfo = JSON.parse(data);
		if(data !=null && data != "" && data.length > 0){
			//$("div.information-headimg-box").children("img").attr("src",userLoginInfo.userHeadPhoto);
			//$("div.information-content").children("p.user-nick-name").html(userLoginInfo.userName);
			//$("div.information-content").children("p.user-occupation").html(userLoginInfo.userOccupation);
			//$("div.information-content").children("p.user-introduction").html(userLoginInfo.userIntroduction);
			$("img.img-circle").attr("src",userLoginInfo.userHeadPhoto)
			$("img.img-circle").next("span").html(userLoginInfo.userName);
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