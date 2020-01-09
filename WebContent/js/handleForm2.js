$(function(){
	//轮播图初始化
	$(".slider-area").flickity({
		autoPlay: 3000,//自动播放
		//wrapAround: true//循环播放
		contain: true,
		
	});
	
	//获取用户登录信息
	onloadUserInfo();
	
	//数据初始化
	onLoadData(1);//表示第一页
	
	//点击作品查询按钮事件
//	$("#worksSearch").on("click",function(){
//		searchWorks();
//	});
	//查询作品
//	function searchWorks(){
//		var searchWorks = $("#searchContent").val();
//		document.searchForm.action="WorksServlet?method=queryWorksInfoBySearchContent";
//		document.searchForm.submit();
//	}
	
	
	//数据初始化
	function onLoadData(pageNum){
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=getPageInfomation",
			data:{
				"pageNum":pageNum
			},
			dataType:"Json",
			success:function(data){
		 		var i = 0;
		 		for(i; i < data.arrayWorksShowInfo.length; i ++){
		 			var html="<!-- BEGIN BOX -->"
		 			+"<div class=\"card-box\">"
		 			+"<div class=\"card-img\"><a class=\"a-img\" href=\"worksDisplayForm.html?worksID="+data.arrayWorksShowInfo[i].worksID+"\"><img class=\"uploadimg\" src=\""+data.arrayWorksShowInfo[i].uploadAddress+"\" /></a></div>"
		 			+"<div class=\"card-info\"><p class=\"card-info-title\"><a class=\"worksName\" href=\"worksDisplayForm.html?worksID="+data.arrayWorksShowInfo[i].worksID+"\">"+data.arrayWorksShowInfo[i].worksName+"</a></p>"
		 			+"<p class=\"card-info-type\">"+data.arrayWorksShowInfo[i].worksCategory+"</p>"
		 			+"<p class=\"card-info-item\">"
		 			+"<span class=\"iconfont icon-favorite\">"+data.arrayWorksShowInfo[i].collectNum+"</span>"
		 			+"<span class=\"iconfont icon-comments\">"+data.arrayWorksShowInfo[i].commentNum+"</span>"
		 			+"<span class=\"iconfont icon-good\">"+data.arrayWorksShowInfo[i].fabulousNum+"</span></p></div>"
		 			+"<div class=\"card-item\">"
		 			+"<span class=\"avatar show-info-card\">"
		 			+"<a href=\"userAllWorksDisplayForm.html?userID="+data.arrayWorksShowInfo[i].userID+"\"><img src=\""+data.arrayWorksShowInfo[i].userHeadPhoto+"\" />"+data.arrayWorksShowInfo[i].userName+"</a></span>"
		 			+"<span class=\"time\">28天前</span></div>"
		 			+"<span class=\"worksID\" style=\"display: none;\">"+data.arrayWorksShowInfo[i].worksID+"</span></div>"
		 			+"<!-- END BOX -->";
		 			$("div.works-list-box").append(html);
		 			//显示时间初始化
					$(".timeago").timeago();
		 		}
		 		//显示分页
		 		$("#page").paging({
					pageNo: data.page.pageNum,//当前页码高亮
					totalPage: data.page.totalPage,//总页数
					totalSize: data.page.totalRecord,//总纪录数
					callback: function(pageNum) {
						//清除上一页的数据
						clearWorksSHowInfo();
						onLoadData(pageNum);
					}
				})
				
			},
			error:function(error){
				alert("加载失败！");
			}
		});
	}
	
	//清除上一页的数据
	function clearWorksSHowInfo(){
		$("div.works-list-box").children().remove();
	}

	//获取用户登录信息
	function onloadUserInfo(){
		//从localStorage获取
		var data = localStorage.getItem("loginUserInfo");
		var userLoginInfo = JSON.parse(data);
		if(data !=null && data != "" && data.length > 0){
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