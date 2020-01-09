$(function(){

	//localStorage
	onloadUserInfo();
	
	//加载数据初始化
	onloadData();
	
	//加载数据初始化
	function onloadData(){
		$.ajax({
			type:"Post",
			url:"PersonalMessageServlet?method=queryPersonalMessageInfoByUserID",
			dataType:"Json",
			success:function(data){
				var length = data.length;
				var i = 0;
				if(data != null){
					for(i; i < length; i++){
						var html ='<!--循环部位-->'
						+'<div class="notice-box clearfix">'
						+'<div class="notice-title">'
						+'<span class="s-theme">'+data[i].whisperedName+' 私信与你</span>'
						+'<span class="s-type"><time class="timeago" datetime="'+data[i].whisperTime+'">0天前</time></span>'
						+'</div>'
						+'<div class="notice-content clearfix">'
						+'<p class="p-content">'+data[i].whisperContent+'</p>'
						+'</div></div><!--END 循环部位-->'
						$(".noticeContent").append(html);
						$(".timeago").timeago();
					}
				}else {
					alert("else" +
							"查询失败！");
					$(".search-null").css("display","block");
				}
			},
			error:function(error){
				console.log(error);
				alert(error.statusText);
				alert(error.status);
				alert(error.readyState);
			}
		});
	}
	
	//localStorage
	function onloadUserInfo(){
		//从localStorage获取
		var data = localStorage.getItem("loginUserInfo");
		var userLoginInfo = JSON.parse(data);
		if(data !=null && data != "" && data.length > 0){
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
});