$(function(){
	var urlParam="searchContent";
	var searchContent=getQueryString(urlParam);
	//获取用户登录信息
	onloadUserInfo();
	//页面上的搜索按钮绑定事件
	$(".seek-box-btn").on("click",function(){
		var content = $("#search-word").val();
		if(content != null && content != ""){
			location.href= encodeURI("worksSearchResultForm.html?searchContent="+content);
		}else{
			
		}
	});
	//加载数据
	onloadData();
	//加载数据
	function onloadData(){
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryWorksInfoBySearchContent",
			data:{
				"searchcontent":searchContent
			},
			dataType:"Json",
			success:function(data){
				var i = 0;
				var length = data.length;
				$("p.album-title").children("span").html(length);
				if(data != null && data != ""){
					for(i; i < length; i++){
						var html = '<!--循环-->'
							+'<div class="card-box">'
							+'<div class="card-img">'
							+'<a class="a-img" href="worksDisplayForm.html?worksID='+data[i].worksID+'" title="'+data[i].worksName+'"><img class="uploadimg" src="'+data[i].uploadAddress+'" /></a>'
							+'</div>'
							+'<div class="card-info">'
							+'<p class="card-info-title">'
							+'<a class="worksName" href="worksDisplayForm.html?worksID='+data[i].worksID+'">'+data[i].worksName+'</a></p>'
							+'<p class="card-info-type"></p>'
							+'<p class="card-info-item">'
							+'<span class="iconfont icon-favorite">'+data[i].collectNum+'</span><span class="iconfont icon-comments">'+data[i].commentNum+'</span><span class="iconfont icon-good">'+data[i].fabulousNum+'</span></p>'
							+'</div>'
							+'<div class="card-item">'
							+'<span class="avatar show-info-card">'
							+'<a href="userAllWorksDisplayForm.html?userID='+data[i].userID+'" title="'+data[i].userName+'"><img src="'+data[i].userHeadPhoto+'" />'+data[i].userName+'</a></span>'
							+'<span class="time"> <time class="timeago" datetime="'+data[i].uploadTime+'">0天前</time></span></div>'
							+'<span class="worksID" style="display: none;">'+data[i].worksID+'</span>'
							+'<span class="worksIntroduction" style="display: none;">'+data[i].worksIntroduction+'</span>'
							+'<span class="uploadPath" style="display: none;">'+data[i].uploadAddress+'</span>'
							+'</div>'
							+'<!--END 循环-->';
						$(".work-list-box").append(html);
						$(".timeago").timeago();
					}
				}else{
					alert("查询失败。");
					$(".search-null").css("display","block");
				}
			},
			error:function(error){
				
			}
		});
	}
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
	//获取url参数
	function getQueryString(param){
		var reg = new RegExp("(^|&)"+ param +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null){
			return decodeURI(r[2]);//若传中文 decodeURI
		}else{
			return null;
		}
	}
});