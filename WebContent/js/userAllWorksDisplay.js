$(function(){
	var urlParam="userID";
	var clickedUserID = getQueryString(urlParam);
	
	onloadUserInfo();
	
	//私信按钮绑定事件
	$(".btnPM").on("click",function(){
		alert("私信按钮启动");
		var caredID = clickedUserID;
		alert(caredID);
		//写入pmModal;
		$("span.pm-userID").html(caredID);
		//打开modal
		$('#pmModal').modal();
	});
	
	//私信模态框发送按钮
	$(".pmCommentBtn").on("click",function(){
		var pmUserID = $(".pm-userID").html();
		var pmContent = $(".pmContent").val();
		if(pmContent != null && pmContent != ""){
			//AJAX 调用
			$.ajax({
				type:"Post",
				url:"PersonalMessageServlet?method=addPersonalMessageInfo",
				dataType:"Json",
				data:{
					"whisperedID":pmUserID,
					"pmContent":pmContent
				},
				success:function(data){
					$("#pmModal").modal('hide');
					var onlyChoseAlert = simpleAlert({
	                    "content":data,
	                    "buttons":{
	                        "确定":function () {
	                            onlyChoseAlert.close();
	                        }
	                    }
	                });
					
				},
				error:function(error){
					
				}
			});
		}else{
			alert("输入内容不能为空。");
		}
		
	});
	//私信模态框关闭按钮
	$(".replyCommentClose").on("click",function(){
		$(".pm-userID").html("");
		$(".pmContent").val("");
		
	});
	$.ajax({
		type:"post",
		url:"CareServlet?method=searchCareInfoIsExist",
		async:true,
		dataType:"json",
		data:{
			"caredID":clickedUserID
		},
		success:function(data){
			if(data=="存在"){
				$("#careBtn").html("已关注");	
			}else if(data=="不存在"){
				$("#careBtn").html("关注");
			}
		}
	});
	
	$("#careBtn").click(function(){
		saveCareInfo();
	});
	
	
	$.ajax({
		type:"Post",
		url:"UserServlet?method=queryUserInfoByUserID",
		dataType:"Json",
		data : {
			"userID" : clickedUserID
		},
		success:function(data){
			if(data!="null"){
				$("div.information-headimg-box").children("img").attr("src",data.userHeadPhoto);
				$("div.information-content").children("p.user-nick-name").html(data.userName);
				$("div.information-content").children("p.user-occupation").html(data.userOccupation);
				$("div.information-content").children("p.user-introduction").html(data.userIntroduction);
				$("#data-number-care").html("关注数："+data.careNum);
				$("#data-number-fans").html("粉丝数："+data.fansNum);		
			}else
			{
				alert("查询用户信息失败");
			}
	 		
	 		
		},
		error:function(error){
			alert("加载失败！");
		}
	});

	$.ajax({
		type:"Post",
		url:"WorksServlet?method=queryWorksInfoByUserID",
		dataType:"Json",
		data : {
			"userID" : clickedUserID
		},
		success:function(data){
			if(data!="null"){
				var i = 0;
				$(".panel-heading span").html(data.length);
				$("#data-number-works").html("作品数："+data.length);
		 		for(i; i < data.length; i++){
		 			var html="<!-- BEGIN BOX -->"
		 				+"<div class=\"card-box\">"
						+"<div class=\"card-img\">"
						+"<a class=\"a-img\" href=\"worksDisplayForm.html?worksID="+data[i].worksID+"\" title=\""+data[i].worksName+"\"><img class=\"uploadimg\" src=\""+data[i].uploadAddress+"\" /></a>"
						+"</div>"
						+"<div class=\"card-info\">"
						+"<p class=\"card-info-title\">"
						+"<a class=\"worksName\" href=\"worksDisplayForm.html?worksID="+data[i].worksID+"\">"+data[i].worksName+"</a></p>"
						+"<p class=\"card-info-type\">"+data[i].worksCategory+"</p>"
						+"<p class=\"card-info-item\">"
						+"<span class=\"iconfont icon-favorite\">"+data[i].collectNum+"</span><span class=\"iconfont icon-comments\">"+data[i].commentNum+"</span><span class=\"iconfont icon-good\">"+data[i].fabulousNum+"</span></p></div>"
						+"<div class=\"card-item\">"
						+"<span class=\"avatar show-info-card\">"
						+"<a href=\"userAllWorksDisplayForm.html?userID="+data[i].userID+"\"><img src=\""+data[i].userHeadPhoto+"\" />"+data[i].userName+"</a></span>"
						+"<span class=\"time\"> <time class=\"timeago\" datetime=\""+data[i].uploadTime+"\">0天前</time></span></div>"
						+"<span class=\"worksID\" style=\"display: none;\">"+data[i].worksID+"</span>"
						+"<span class=\"worksIntroduction\" style=\"display: none;\">"+data[i].worksIntroduction+"</span>"
						+"<span class=\"uploadPath\" style=\"display: none;\">"+data[i].uploadAddress+"</span></div>";
		 				+"<!-- END BOX -->";

//		 			$(".works-area").append(html);
		 			$("div.works-list-box").append(html);
		 			//显示时间初始化
					$(".timeago").timeago();
		 		}
			}else
			{
				alert("用户按分类查看作品失败");
			}
		},
		error:function(error){
			alert("加载失败！");
		}
	});
	
	//关注按钮初始化
	function saveCareInfo(){
		alert("11");
		var careBtn = $("#careBtn").html();	
		var caredID = $("span.s-authorID").html();
		if(careBtn=="关注"){
			$.ajax({
				type:"post",
				url:"CareServlet?method=addCareInfoByUserIDAndCaredID",
				async:true,
				dataType:"json",
				data:{
					"caredID":clickedUserID
				},
				success:function(data){
					if(data=="关注成功！"){
						$("#careBtn").html("已关注");
						alert("关注成功！");
					}else if(data=="关注失败！"){
						alert("关注失败！");
					}
				}
			});
		}else if(careBtn=="已关注"){
			//调用取消关注方法
			$.ajax({
				type:"post",
				url:"CareServlet?method=cutoffCareInfoByUserIDAndCaredID",		
				async:true,
				dataType:"json",
				data:{
					"caredID":clickedUserID
				},
				success:function(data){
					if(data=="已取消关注！"){
						$("#careBtn").html("关注");
						alert("已取消关注！");
					}else if(data=="取消关注失败！"){
						alert("取消关注失败！");
						}
					}
			});
		}
	}

	//获取用户登录信息
	function onloadUserInfo(){
		//从localStorage获取
		var data = localStorage.getItem("loginUserInfo");
		var userLoginInfo = JSON.parse(data);
		if(data !=null && data != "" && data.length > 0){
			$("img.img-circle").attr("src",userLoginInfo.userHeadPhoto)
			$("img.img-circle").next("span").html(userLoginInfo.userName);
			
			//写入导航头
			$("li.dropdown").children("a").children("img").attr("src",userLoginInfo.userHeadPhoto);
			$("li.dropdown").children("a").children("#nav-userName").html(userLoginInfo.userName);
			$("div.information-headimg-box").children("img").attr("src",userLoginInfo.userHeadPhoto);
			
			$("div.information-content").children("p.user-nick-name").html(userLoginInfo.userName);
			$("div.information-content").children("p.user-occupation").html(userLoginInfo.userOccupation);
			$("div.information-content").children("p.user-introduction").html(userLoginInfo.userIntroduction);
			//写入span.userID
			$("span.userID").html(userLoginInfo.userID);
			if(userLoginInfo.creatorStatus == 1){
				$("a.myWorks").css('display','block');
			}
			if(userLoginInfo.creatorStatus != 1){
				$("a.applyCreator").css('display','block');
			}
		}
	}
	
	//获取url参数方法
	function getQueryString(param){
		var reg = new RegExp("(^|&)"+ param +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null){
			return unescape(r[2]);//若传中文 decodeURI
		}else{
			return null;
		}
	}
	
});
