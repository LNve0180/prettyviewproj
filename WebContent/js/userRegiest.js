$(function(){
	
	//用户登陆按钮操作
	$('#userRegiestButton').click(function(){
		var userName=$("#userName").val();		
		var userPassword=$("#userPassword").val();
		var repeatUserPassword=$("#repeatUserPassword").val();	
		var userSex=$("input[name=userSex]:checked").val();
		var userEmail=$("#userEmail").val();
		var userPhone=$("#userPhone").val();
		var userOccupation=$("#userOccupation").val();
		var userIntroduction=$("#userIntroduction").val();
		if(!userName||!userPassword||!repeatUserPassword||!userSex||!userEmail||!userPhone||!userOccupation||!userIntroduction)
		{
			alert("用户输入的内容存在格式错误");
		}else
		{
			if(userPassword!=repeatUserPassword){
				alert("用户两次输入的密码不一致");
			}else{
				//判断用户是否存在
				$.ajax({
					type : "post",
					url : "UserServlet?method=addUserInfoByUserInfo",
					async : false,
					dataType : "json",
					data : {
						"userName" : userName,
						"userPassword" : userPassword,
						"userSex" : userSex,
						"userEmail" : userEmail,
						"userPhone" : userPhone,
						"userOccupation" : userOccupation,
						"userIntroduction" : userIntroduction,
					},
					success : function(data) {
						// alert(data);
						if (data == "null") {
							alert("用户注册失败");
						}else{
							alert("用户注册成功,你的用户ID为:"+data+",请务必记牢。");
							var dataTemp={
									"userID" : data,
									"userName" : userName,
									"userPassword" : userPassword,
									"userSex" : userSex,
									"userEmail" : userEmail,
									"userPhone" : userPhone,
									"userOccupation" : userOccupation,
									"userIntroduction" : userIntroduction,
									"userHeadPhoto":"headPhoto/head.jpg",
									"userIDStatus":"1",
									"creatorStatus":"0"
									};
							localStorage.setItem("loginUserInfo",JSON.stringify(dataTemp));
							window.location.href="handleForm.jsp";
						} 
					}
				});
			}
			
			
		}
	});	
})
