$(function(){
	
	//用户登陆按钮操作
	$('#userLoginButton').click(function(){
		var userID=$("#userID").val();
		var userPassword=$("#userPassword").val();
		var isUserExist=false;
		if(!userID||!userPassword)
		{
			alert("用户输入的内容存在格式错误");
		}else
		{
			//判断用户是否存在
			$.ajax({
				type : "post",
				url : "UserServlet?method=searchUserInfoIsExist",
				async : false,
				dataType : "json",
				data : {
					"userID" : userID
				},
				success : function(data) {
					// alert(data);
					if (data == "false") {
						alert("用户输入的账户不存在");
						isUserExist=false;
					}else{
						isUserExist=true;
					} 
				}

			});
			if(isUserExist){
				$.ajax({
					type : "post",
					url : "UserServlet?method=checkUserPassword",
					async : false,
					dataType : "json",
					data : {
						"userID" : userID,
						"userPassword" : userPassword
					},
					success : function(data) {
						// alert(data);
						if (data == "false") {
							alert("用户密码错误");
						}else{
							if(data.userIDStatus=="0"){
								alert("该用户已被封");
							}else{
								localStorage.setItem("loginUserInfo", JSON.stringify(data));
								window.location.href="handleForm.jsp";
							}
						} 
					}

				});
			}
			
		}
	});	
})
