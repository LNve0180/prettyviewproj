$(function(){
	var urlParam="searchContent";
	var searchContent=getQueryString(urlParam);
//	$("#search-word").val(searchContent);
	//获取用户登录信息
	onloadUserInfo();
	//页面上的搜索按钮绑定事件
	$(".seek-box-btn").on("click",function(){
		var content = $("#search-word").val();
		if(content != null && content != ""){
			location.href= encodeURI("userSearchResultForm.html?searchContent="+content);
		}else{
			
		}
	});
	//加载数据
	onloadData();
	//加载数据
	function onloadData(){
		$.ajax({
			type:"Post",
			url:"UserServlet?method=queryUserInfoBySearchContent",
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
							+'<div class="h-card-img">'
							+'<div class="div-head">'
							+'<a class="a-headimg" href="userAllWorksDisplayForm.html?userID='+data[i].userID+'" title="'+data[i].userName+'"><img src="'+data[i].userHeadPhoto+'" /></a>'
							+'</div></div>'
							+'<div class="u-card-info">'
							+'<p class="card-info-title p-center" >'
							+'<a class="worksName" href="userAllWorksDisplayForm.html?userID='+data[i].userID+'">'+data[i].userName+'</a></p>'
							+'<p class="card-info-type p-center">'
							+'<span class="occupation">'+data[i].userSex+'  |  '+data[i].userOccupation+'</span></p>'
							+'<p class="card-info-intro p-center">'
							+'<span class="introduction">'+data[i].userIntroduction+'</span></p>'
							+'<p class="card-info-item p-center">'
							+'<span class="s-careNum">关注数：<span style="margin-right: 0px;">'+data[i].careNum+'</span></span><span class="s-fansNum">粉丝数：<span style="margin-right: 0px;">'+data[i].fansNum+'</span></span>'
							+'</p></div>'
							+'<div class="card-item p-center">'
							+'<button class="btn btn-default careBtn" style="width: 126px; margin-left: 0px;">关注</button></div>'
							+'<span class="caredID" style="display: none;">'+data[i].userID+'</span>'
							+'</div>'
							+'<!--END 循环-->';
						$(".work-list-box").append(html);

					}
					//给按钮绑定事件
					//解绑
					$(".work-list-box").off("click");
					//再绑定关注按钮
					$("div.work-list-box").on("click",".careBtn",function(event){
						var careBtn = $(this).html();
						var $careBtn =$(this);
						var userID = $("span.userID").html();
						var caredID = $(this).parents("div.card-box").children("span.caredID").html();
						if(careBtn=="关注"){
							$.ajax({
								type:"post",
								url:"CareServlet?method=addCareInfoByUserIDAndCaredID",
								async:true,
								dataType:"json",
								data:{
									"caredID":caredID
								},
								success:function(data){
									if(data=="关注成功！"){
										$careBtn.html("已关注");
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
									"caredID":caredID
								},
								success:function(data){
									if(data=="已取消关注！"){
										$careBtn.html("关注");
										alert("已取消关注！");
									}else if(data=="取消关注失败！"){
										alert("取消关注失败！");
										}
									}
							});
						}
					});
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