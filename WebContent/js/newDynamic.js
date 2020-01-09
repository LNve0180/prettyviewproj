$(function(){
	//localStorage
	onloadUserInfo();
	//加载数据初始化
	onloadData();
	//上传按钮绑定事件
	$(".btnUpload").on("click",function(){
		//上传跳转界面
		onloadWindow();
	});
	//上传跳转界面
	function onloadWindow(){
		window.location.href="uploadWorksForm.html";
	}
	//加载数据初始化
	function onloadData(){
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryWorksCareInfoByUserID",
			dataType:"Json",
			success:function(data){
				//清除原先的html代码
				$("div.works-list-box").children("div.card-box").remove();
				var i = 0;
				var length = data.length;
				if(length >= 20){
					length = 20;
				}
				if(data != null && data != "" && length > 0){
					for( i; i < length; i++){
						var html="<div class=\"card-box\">"
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
						$("div.works-list-box").append(html);
						//显示时间初始化
						$(".timeago").timeago();
					}
				}else{
//					alert("没有找到关注的新作品。");
					$("div.search-null").css("display","block");
				}
				$("h3.panel-title").children("span").html("0");
				$("h3.panel-title").children("span").html(length);
			},
			error:function(error){
				alert("查询失败!");
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