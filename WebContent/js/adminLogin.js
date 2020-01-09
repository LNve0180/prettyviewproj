$(document).ready(function() {
	$("#adminLoginButton").click(function() {
		var adminID = $("#adminID").val();
		var adminPassword = $("#adminPassword").val();
		var isAdminExist=true;
		if (!adminID || !adminPassword) {
			alert("账号格式错误，请重新输入");
			return false;
		} else {
			// 判断该账户是否存在
			$.ajax({
				type : "post",
				url : "AdminServlet?method=searchAdminIsExist",
				async : false,
				dataType : "json",
				data : {

					"adminID" : adminID
				},
				success : function(data) {
					// alert(data);
					if (data == "false") {
						alert("账号不存在，请重新输入");
						isAdminExist=false;
						return false;
					} 
				}
			});
			// 判断密码是否正确
			if(isAdminExist==true){
				$.ajax({
					type : "post",
					url : "AdminServlet?method=checkAdminPassword",
					async : false,
					dataType : "json",
					data : {
						"adminID" : adminID,

						"adminPassword" : adminPassword
					},
					success : function(data) {
						// alert(data);
						if (data == "null") {
							alert("密码错误，请重新输入");
							return false;
						} else{
							localStorage.setItem("loginAdminInfo", JSON.stringify(data));
							window.location.href="adminHandleForm.jsp";
							return true;
						}

					}

				});
			}
			
		}
	});
});