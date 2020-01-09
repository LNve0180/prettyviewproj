$(function(){
	
	onloadUserInfo();
	var data = localStorage.getItem("loginUserInfo");
	var loginUserInfo = JSON.parse(data);
	$(".oldUserHeadPhoto img").attr("src",loginUserInfo.userHeadPhoto);
	
	
	$("#alterUserHeadPhotoButton").click(function(){
		if(!$("#userHeadPhoto").val())
		{
		alert("用户输入的内容存在格式错误");
		}
		else{
//			$.ajax({
//				type : "post",
//				url : "WorksServlet?method=addWorksInfoByWorksInfo",
//				async : true,
//				dataType : "json",
//				data : $("#form1").serialize(),
//				success : function(data) {
//					// alert(data);
//					if (data == "true") {
//						alert("添加成功");
//					} else if (data == "false") {
//						alert("添加失败");
//					}
//				}
//			});
			$("#alterUserHeadPhotoForm").ajaxSubmit({
			      url: "UserServlet?method=modifyUserHeadPhotoByUserID",
			      type: "post",
			      async : false,
			      enctype: 'multipart/form-data',
			      // iframe: true,
			      dataType:'json',
			      success: function (data)
			      {
			        //var msg = eval(data);
			        if(data=="true"){
			        	$("#alterUserHeadPhotoButton").attr("disabled","disabled")
			        	alert("用户修改头像成功,点击确定后，三秒后将自动刷新");
			        	$("#alterUserHeadPhotoButton")
			        	onloadUserInfoTwo();
			        	setTimeout(function(){location.reload();},3000);
			        	
			        }else if(data=="false"){
			        	alert("用户修改头像失败");
			        }
			        
			      },
			      error: function (data)
			      {
			        //var msg = eval(data);
			        alert("出错");//msg.errCode
			      }
			    })
		}
	});
	
	$("#userHeadPhoto").change(function(e){
		var imgBox=e.target;
		var file=imgBox.files[0];
		var imgSrc;
		if(!/image\/\w+/.test(file.type)){
			alert("请选择图片，不要选择其他类型的文件");
			return false;
		}
		var reader=new FileReader();
		reader.readAsDataURL(file);
		reader.onload=function(){
			console.log(this.result);
			imgSrc=this.result;
			$(".newUserHeadPhoto img").attr("src",imgSrc);
		}
	});
	$(".newUserHeadPhoto").click(function(){
		$("#userHeadPhoto").trigger("click");
	});
	
	
	
	//获取用户登录信息
	function onloadUserInfo(){
		//从localStorage获取
		var data = localStorage.getItem("loginUserInfo");
		var userLoginInfo = JSON.parse(data);
		
		//alert("123:"+userLoginInfo.userHeadPhoto);
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
	
	
	//获取用户登录信息
	function onloadUserInfoTwo(){
		//ajax获取
		$.ajax({
			async : false,
			type:"Post",
			url:"UserServlet?method=getUserLoginInfo",
			dataType:"Json",
			success:function(data){
				//alert(data.userHeadPhoto+"FADSFA1");
				localStorage.removeItem("loginUserInfo");
				localStorage.setItem("loginUserInfo",JSON.stringify(data));
//				if(data !=null && data != "" && data.length > 0){
//					//写入导航头
//					//存入localStorage
//					alert(data.userHeadPhoto+"FADSFA");
//					localStorage.removeItem("loginUserInfo");
//					localStorage.setItem("loginUserInfo",JSON.stringify(data));
//					
//				}
			},
			error:function(error){
				
			}
		});
	}

	
	
	
	
	
	
})
