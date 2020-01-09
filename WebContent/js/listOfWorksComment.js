$(function(){		
	//获取用户登录信息
	onloadUserInfo();			
	
	$.ajax({
		type:"Post",
		url:"WorksServlet?method=queryTopWorksInfoByCommentNum",
		dataType:"Json",
		success:function(data){
			if(data!="null"){
				var i = 0;
		 		for(i; i < data.length; i++){
		 			var html='<div class="panel rankingListWorksDisplay">'
		 				+'<div class="panel rankingListWorksDisplayLeft">'
		 				+'	<span>'+(i+1)+'</span>'
		 				+'	<p>评论数:'+data[i].commentNum+'</p></div>'
		 				+'<div class="panel rankingListWorksDisplayCenter">'
		 				+'	<a href="worksDisplayForm.html?worksID='+data[i].worksID+'"><img src="'+data[i].uploadAddress+'" /></a></div>'
		 				+'<div class="panel rankingListWorksDisplayRight">'
		 				+'	<div class="panel worksName">'
		 				+'		作品名:<a class="list-a-worksName" href=userAllWorksDisplayForm.html?userID='+data[i].worksID+'>'+data[i].worksName+'</a><br /> '+data[i].worksCategory+'</div>'
		 				+'	<div class="panel worksAuthor">'
		 				+'		<div class="panel worksAuthorHeadPhoto">'
		 				+'			<a href="userAllWorksDisplayForm.html?userID='+data[i].userID+'"><img src="'+data[i].userHeadPhoto+'" /></a></div>'
		 				+'		<a class="list-a-userName" href="userAllWorksDisplayForm.html?userID='+data[i].userID+'" ><span>'+data[i].userName+'</span></a></div>			</div>'
		 				+'<div class="panel rankingListWorksDisplayRightRight">'
		 				+'	<a href="#" class="seeBottomSpan"style="color:#666666;"><span >查看详情<span class="lnr lnr-chevron-down"></span></span></a>'
		 				+'	<a href="#" class="hideBottomSpan"style="color:#666666;"><span >收起详情<span class="lnr lnr-chevron-up"></span></span></a>'
		 				+'</div></div>'
		 			+'<div class="panel rankingListWorksDisplayBottom">'
		 			+'	<div class="panel worksIntroduction2">'
		 			+'		作品介绍:'+data[i].worksIntroduction+'</div>'
		 			+'	<div class="panel worksOtherInfo">'
		 			+'		<div class="panel">'
		 			+'			点赞数<br />'
		 			+'			<span>'+data[i].fabulousNum+'</span></div>'
		 			+'		<span style="float: left;font-size: 20px;">|</span>'
		 			+'		<div class="panel">'
		 			+'			收藏数<br />'
		 			+'			<span>'+data[i].collectNum+'</span></div></div></div>';

		 			$("body").append(html);
		 			
		 		}
		 		$(".rankingListWorksDisplayBottom").hide();
		 		$(".hideBottomSpan").hide();
		 		$(".seeBottomSpan").click(function(){
		 			$(this).hide();
		 			$(this).siblings(".hideBottomSpan").show();
		 			//$(this).parent().parent().next(".rankingListWorksDisplayBottom").show();
		 			$(this).parents(".rankingListWorksDisplay").next(".rankingListWorksDisplayBottom").show();
		 		});
		 		
		 		$(".hideBottomSpan").click(function(){
		 			$(this).siblings(".seeBottomSpan").show();
		 			$(this).hide();
		 			$(this).parent().parent().next(".rankingListWorksDisplayBottom").hide();
		 		});
		 		
		 		
		 		
			}else
			{
				alert("用户随机查看作品收藏排行榜失敗");
			}
	 		
	 		
		},
		error:function(error){
			alert("加载失败！");
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