$(function(){
	
	//获取用户登录信息
	onloadUserInfo();
	
	//加载初始化
	onloadMyWorksInfo();
	
	//上传按钮绑定事件
	$(".btnUpload").on("click",function(){
		//上传跳转界面
		onloadWindow();
	});
	
	//我的作品绑定事件
	$("a.btnMyWorks").on("click",function(){
		onloadMyWorksInfo();
	});
	
	//待审核作品绑定事件
	$("a.btnNotReview").on("click",function(){
		//查看待审核作品
		onloadReviewingWorks();
	});
	
	//加载初始化
	function onloadMyWorksInfo(){
		//ajax获取
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryMyWorksInfoByUserID",
			dataType:"Json",
			success:function(data){
				$("div.search-null").css("display","none");
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
						+"<a class=\"a-img\" href=\"#\"><img class=\"uploadimg\" src=\""+data[i].uploadAddress+"\" /></a>"
						+"<ul class=\"icon\"><li><span class=\"searchWorks\">查看</span></li>"
						+"<li><span class=\"updateWorks\">修改</span></li><li><span class=\"deleteWorks\">删除</span></li></ul></div>"
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
					//给按钮绑定事件
					//解绑
					$("div.works-list-box").off("click");
					//再绑定查看按钮
					$("div.works-list-box").on("click",".searchWorks",function(event){
						var worksID = $(this).parents("div.card-box").children("span.worksID").html();
						//跳转链接 带上worksID参数
						location.href="worksDisplayForm.html?worksID="+worksID+" ";
						
					});
					//再绑定修改按钮
					$("div.works-list-box").on("click",".updateWorks",function(event){
						var worksID = $(this).parents("div.card-box").children("span.worksID").html();
						var worksIntroduction = $(this).parents("div.card-box").children("span.worksIntroduction").html();
						var worksName = $(this).parents("div.card-box").children("div.card-info").children("p.card-info-title").children("a").html();
						var worksCategory = $(this).parents("div.card-box").children("div.card-info").children("p.card-info-type").html();
						var uploadAddress = $(this).parents("div.card-box").children("span.uploadPath").html();
						//转换json放入localStorage
						var data = {
								"worksID":worksID,
								"worksName":worksName,
								"worksIntroduction":worksIntroduction,
								"worksCategory":worksCategory,
								"uploadAddress":uploadAddress
						}
						localStorage.setItem("worksInfo", JSON.stringify(data));
						window.location.href="alterWorksInfoForm.html";
					});
					//再绑定删除按钮
					$("div.works-list-box").on("click",".deleteWorks",function(event){
						var worksID = $(this).parents("div.card-box").children("span.worksID").html();
						var dblChoseAlert = simpleAlert({
						    "title":"系统提示",
						    "content":"你确定要删除吗？",
						    "buttons":{
						        "确定":function () {
						        	//ajax调用后台删除方法
						        	$.ajax({
						            	type:"Post",
						            	url:"WorksServlet?method=cutoffWorksInfoByWorksID",
						            	data:{
						            		"worksID":worksID
						            	},
						            	dataType:"Json",
						            	success:function(data){
						            		dblChoseAlert.close();
						            		if(data == "true"){
						            			alert("删除成功！");
						            		}else {
						            			alert("删除失败！");
						            		}
						            	},
						            	error:function(error){
						            		var onlyChoseAlert2 = simpleAlert({
							                    "content":"删除失败！",
							                    "buttons":{
							                        "确定":function () {
							                            onlyChoseAlert.close();
							                        }
							                    }
							                });
						            	}
						            
						            });
//						            dblChoseAlert.close();
//						            //刷新界面
//						            javascript: location.reload();
						        },
						        "取消":function () {
						            dblChoseAlert.close();
						        }
						    }
						});
					});
				}else{
					$("div.search-null").css("display","block");
				}
				$("h3.panel-title").children("span").html("0");
				$("h3.panel-title").children("span").html(length);
			},
			error:function(error){
				//alert("error");
			}
		});
		
	}
	
	//查看待审核作品
	function onloadReviewingWorks(){
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryMyUnaditedWorksInfo",
			dataType:"Json",
			success:function(data){
				$("div.search-null").css("display","none");
				//清除原先的html代码
				$("div.works-list-box").children("div.card-box").remove();
				var i = 0;
				var length = data.length;
				if(length >= 20){
					length = 20;
				}
				if(data != null && data != "" && length > 0){
					for( i; i < length; i++){
						var html = "<div class=\"card-box\">"
						+"<div class=\"card-img-default\">"
						+"<img class=\"uploadimg2 img-responsive center-block\" src=\""+data[i].uploadAddress+"\" data-magnify=\"gallery\" data-src=\""+data[i].uploadAddress+"\" src=\"small-1.jpg\" title=\""+data[i].worksName+"\" /></div>"
						+"<div class=\"card-info\">"
						+"<p class=\"card-info-title\"><a class=\"worksName\" href=\"#\">"+data[i].worksName+"</a></p>"
						+"<p class=\"card-info-type\">"+data[i].worksCategory+"</p>"
						+"<span class=\"iconfont icon-favorite\">"+data[i].collectNum+"</span><span class=\"iconfont icon-comments\">"+data[i].commentNum+"</span><span class=\"iconfont icon-good\">"+data[i].fabulousNum+"</span></p></div>"
						+"<div class=\"card-item\">"
						+"<span class=\"avatar show-info-card\">"
						+"<a href=\"#\"><img src=\""+data[i].userHeadPhoto+"\" />"+data[i].userName+"</a></span>"
						+"<span class=\"time\"><time class=\"timeago\" datetime=\""+data[i].uploadTime+"\">0天前</time></span></div></div>";
						$("div.works-list-box").append(html);
						//显示时间初始化
						$(".timeago").timeago();
					}
				}else{
					$("div.search-null").css("display","block");
				}
				$("h3.panel-title").children("span").html("0");
				$("h3.panel-title").children("span").html(length);
			},
			error:function(error){
				
			}
		});
	}
	
	//上传跳转界面
	function onloadWindow(){
		window.location.href="uploadWorksForm.html";
	}
	//获取用户登录信息
	function onloadUserInfo(){
		//ajax获取
		/*$.ajax({
			type:"Post",
			url:"UserServlet?method=getUserLoginInfo",
			dataType:"Json",
			success:function(data){
				//alert("用户加载："+data);
				if(data !=null && data != "" && data.length > 0){
				$("div.information-headimg-box").children("img").attr("src",data.userHeadPhoto);
				$("div.information-content").children("p.user-nick-name").html(data.userName);
				$("div.information-content").children("p.user-occupation").html(data.userOccupation);
				$("div.information-content").children("p.user-introduction").html(data.userIntroduction);
				}
			},
			error:function(error){
				
			}
		});*/
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
	
});