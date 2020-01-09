$(document).ready(function() {
	//获取用户登录信息
	onloadUserInfo();
	$.ajax({
		type : "post",
		url : "CollectServlet?method=queryCollectInfoByUserID",
		async : true,
		dataType : "json",
		success : function(data) {
			if (data == "null") {
				alert("查询失败");
				$(".search-null").css("display","block");
			}else{
				//加载内容
				for(var i=0;i<data.length;++i){
					var html='<div class="panel worksDisplay">'+
					'<div class="panel worksUploadAddress" style="">'+
					'<a href="worksDisplayForm.html?worksID='+data[i].worksID+'"><img src="'+data[i].uploadAddress+'" /></a>'+
					'</div>'+
					'<div class="panel worksMessage" style="float: left;margin-left: 50px;">'+
					'<div class="panel worksName">'+
					'作品名:'+data[i].worksName+'&nbsp;&#124;作品种类:'+data[i].worksCategory+'<br />'+
					'</div>'+
					'<div class="panel worksTime">'+
					'上传时间:'+data[i].uploadTime+' <br />收藏时间:'+data[i].collectTime+''+
					'</div>'+
					'</div>'+
					'<div class="panel worksBottom">'+
					'<div class="panel worksIntroduction">'+
					'作品介绍:'+data[i].worksIntroduction+
					'</div>'+
					'<div class="panel deleteCollectButton" style="float: left;">'+
					'<form action="CollectServlet" method="post">'+
					'<input type="hidden" id="method" name="method" value="" style="display: none;" />'+
					'<input type="hidden" id="worksID" name="worksID" value="'+data[i].worksID+'" style="display: none;" />'+
					'<a href="#">取消收藏</a></form></div></div></div>';
					$(".collectDisplayContent").append(html);
				}
				//加载结束
				//添加删除事件
				$(".deleteCollectButton a").click(function() {
					var worksID = $(this).parent().children("#worksID").val();
					alert(worksID);
					$.ajax({
						type: "post",
						url: "CollectServlet?method=cutoffCollectInfoByUserIDWorksID",
						async: true,
						dataType: "json",
						data: {
							"worksID": worksID
						},
						success: function(data) {
							// alert(data);
							if(data == "true") {
								alert("用户删除收藏作品成功");
								location.reload();
							} else {
								alert("用户删除收藏作品失败");
							}
						}
					});
				});
				
				//window.location.href="handleForm.jsp";
			} 
		}
	});
	
	
//	$("#alterUserInfoButton").click(function() {
//		var userName=$(".alterUserInfoContent #userName").val();			
//		if(!userName||!userSex||!userEmail||!userPhone||!userOccupation||!userIntroduction)
//		{
//			alert("用户输入的内容存在格式错误");
//		}else
//		{
//				$.ajax({
//					type : "post",
//					url : "UserServlet?method=modifyUserInfoByUserInfo",
//					async : false,
//					dataType : "json",
//					data : {
//						"userName" : userName,
//						"userSex" : userSex
//					},
//					success : function(data) {
//						// alert(data);
//						if (data == "false") {
//							alert("用户修改基本信息失败");
//						}else{
//							alert("用户修改基本信息成功");
//							localStorage.setItem("loginUserInfo",JSON.stringify(dataTemp));
//							location.reload();
//							//window.location.href="handleForm.jsp";
//						} 
//					}
//				});	
//		}
//	});
//	
	
	
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