$(function(){
	
	//获取用户登录信息
	onloadUserInfo();
	
	//初始化拖拽
	$('.dropify').dropify({
		 messages:{
			default:'请将图片拽入此区域或者点击切换图片',
			replace:'请将图片拽入此区域或者点击切换图片',
			remove:'移除'
		  }
	});
	
/*	$("#picSearchBtn").on("click",function(){
		$("#searchform").ajaxSubmit({
		      url: "WorksServlet?method=compareSimilarWorks",
		      type: "post",
		      enctype: 'multipart/form-data',
		      dataType:'json',
		      success: function (data){
		    	  console.log(data);
		    	  alert(data);
		      },
		      error: function (data)
		      {
		        //var msg = eval(data);
		        alert("出错");//msg.errCode
		      }
		    });
		
	});*/
	
	$("#uploadAddress").on("change",function(e){
		var imgBox=e.target;
		var file=imgBox.files[0];
		var imgSrc;
		if(!/image\/\w+/.test(file.type)){
			alert("文件格式不符。");
			return false;
		}
		var size = $("#uploadAddress")[0].files[0].size;
		if((size / 1024) >= 2 * 1024){
			alert("请选择不大于2M的图片");
			return false;
		}
		$("body").mLoading("show");
		$("#searchform").ajaxSubmit({
		      url: "WorksServlet?method=compareSimilarWorks",
		      type: "post",
		      enctype: 'multipart/form-data',
		      dataType:'json',
		      success: function (data){
		    	  $("body").mLoading("hide");
		    	  if(data != null && data != ""){
		    		  $(".search-null").css("display","none");
		    		  $(".works-show-area").children(".card-box").remove();
		    		  $(".searchNum").html(data.length);
			    	  var i = 0;
			    	  for( i; i < data.length; i++){
							var html="<div class=\"card-box\">"
							+"<div class=\"card-img\">"
							+"<a class=\"a-img\" href=\"worksDisplayForm.html?worksID="+data[i].worksID+"\"><img class=\"uploadimg\" src=\""+data[i].uploadAddress+"\" /></a>"
							+"</div>"
							+"<div class=\"card-info\">"
							+"<p class=\"card-info-title\">"
							+"<a class=\"worksName\" href=\"#\">"+data[i].worksName+"</a></p>"
							+"<p class=\"card-info-type\">"+data[i].worksCategory+"</p>"
							+"<p class=\"card-info-item\">"
							+"<span class=\"iconfont icon-favorite\">"+data[i].collectNum+"</span><span class=\"iconfont icon-comments\">"+data[i].commentNum+"</span><span class=\"iconfont icon-good\">"+data[i].fabulousNum+"</span></p></div>"
							+"<div class=\"card-item\">"
							+"<span class=\"avatar show-info-card\">"
							+"<a href=\"worksDisplayForm?worksID="+data[i].worksID+"\"><img src=\""+data[i].userHeadPhoto+"\" />"+data[i].userName+"</a></span>"
							+"<span class=\"time\"> <time class=\"timeago\" datetime=\""+data[i].uploadTime+"\">0天前</time></span></div>"
							+"<span class=\"worksID\" style=\"display: none;\">"+data[i].worksID+"</span>"
							+"<span class=\"worksIntroduction\" style=\"display: none;\">"+data[i].worksIntroduction+"</span>"
							+"<span class=\"uploadPath\" style=\"display: none;\">"+data[i].uploadAddress+"</span></div>";
							$("div.works-show-area").append(html);
							//显示时间初始化
							$(".timeago").timeago();
						}
		    	  }else{
		    		  $(".works-show-area").children(".card-box").remove();
		    		  $(".search-null").css("display","block");
		    		  $(".searchNum").html("0");
		    		  $("body").mLoading("hide");
		    		  alert("无相似作品。");
		    	  }
		      },
		      error: function (data)
		      {
		    	  $("body").mLoading("hide");
		        //var msg = eval(data);
		        alert("查询失败。");//msg.errCode
		      }
		    });
		
	});

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