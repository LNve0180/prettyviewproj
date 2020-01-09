$(function(){
	onloadUserInfo();
	
	$.ajax({
		type:"Post",
		url:"WorksServlet?method=queryLatestWorksInfo",
		dataType:"Json",
		success:function(data){
			if(data!="null"){
				var i = data.length-1;
		 		for(i; i >-1; --i){
		 			var html="<!-- BEGIN BOX -->"
		 			+"<div class=\"card-box\">"
		 			+"<div class=\"card-img\"><a class=\"a-img\" href=\"worksDisplayForm.html?worksID="+data[i].worksID+"\"><img class=\"uploadimg\" src=\""+data[i].uploadAddress+"\" /></a></div>"
		 			+"<div class=\"card-info\"><p class=\"card-info-title\"><a class=\"worksName\" href=\"#\">"+data[i].worksName+"</a></p>"
		 			+"<p class=\"card-info-type\">"+data[i].worksCategory+"</p>"
		 			+"<p class=\"card-info-item\">"
		 			+"<span class=\"iconfont icon-favorite\">"+data[i].collectNum+"</span>"
		 			+"<span class=\"iconfont icon-comments\">"+data[i].commentNum+"</span>"
		 			+"<span class=\"iconfont icon-good\">"+data[i].fabulousNum+"</span></p></div>"
		 			+"<div class=\"card-item\">"
		 			+"<span class=\"avatar show-info-card\">"
		 			+"<a href=\"userAllWorksDisplayForm.html?userID="+data[i].userID+"\"><img src=\""+data[i].userHeadPhoto+"\" />"+data[i].userName+"</a></span>"
		 			+"<span class=\"time\"><time class=\"timeago\" datetime=\""+data[i].uploadTime+"\">0天前</time></span></div>"
		 			+"<span class=\"worksID\" style=\"display: none;\">"+data[i].worksID+"</span></div>"
		 			+"<!-- END BOX -->";

		 			$(".works-list-box .seeWorksDisplayTop").after(html);
		 			//$("div.works-list-box").append(html);
		 			//显示时间初始化
					$(".timeago").timeago();
		 		}
			}else
			{
				alert("用户查看最新作品失败");
			}
	 		
	 		
		},
		error:function(error){
			alert("加载失败！");
		}
	});
	
	$("#viewLatestWorksA").click(function(){
		var allNum=$(".works-list-box .card-box").length;
		for(var i=0;i<allNum;++i){
			$(".works-list-box .card-box:eq(0)").remove();
		}
		//sleep(this,1000);
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryLatestWorksInfo",
			dataType:"Json",
			success:function(data){
				if(data!="null"){
					var i = data.length-1;
			 		for(i; i >-1; --i){
			 			var html="<!-- BEGIN BOX -->"
			 			+"<div class=\"card-box\">"
			 			+"<div class=\"card-img\"><a class=\"a-img\" href=\"worksDisplayForm.html?worksID="+data[i].worksID+"\"><img class=\"uploadimg\" src=\""+data[i].uploadAddress+"\" /></a></div>"
			 			+"<div class=\"card-info\"><p class=\"card-info-title\"><a class=\"worksName\" href=\"#\">"+data[i].worksName+"</a></p>"
			 			+"<p class=\"card-info-type\">"+data[i].worksCategory+"</p>"
			 			+"<p class=\"card-info-item\">"
			 			+"<span class=\"iconfont icon-favorite\">"+data[i].collectNum+"</span>"
			 			+"<span class=\"iconfont icon-comments\">"+data[i].commentNum+"</span>"
			 			+"<span class=\"iconfont icon-good\">"+data[i].fabulousNum+"</span></p></div>"
			 			+"<div class=\"card-item\">"
			 			+"<span class=\"avatar show-info-card\">"
			 			+"<a href=\"userAllWorksDisplayForm.html?userID="+data[i].userID+"\"><img src=\""+data[i].userHeadPhoto+"\" />"+data[i].userName+"</a></span>"
			 			+"<span class=\"time\"><time class=\"timeago\" datetime=\""+data[i].uploadTime+"\">0天前</time></span></div>"
			 			+"<span class=\"worksID\" style=\"display: none;\">"+data[i].worksID+"</span></div>"
			 			+"<!-- END BOX -->";

			 			$(".works-list-box .seeWorksDisplayTop").after(html);
			 			//$("div.works-list-box").append(html);
			 			//显示时间初始化
						$(".timeago").timeago();
			 		}
				}else
				{
					alert("用户查看最新作品失败");
				}
		 		
		 		
			},
			error:function(error){
				alert("加载失败！");
			}
		});
		
		
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
	
	
	
	
});
