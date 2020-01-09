$(function(){
	//localStorage
	onloadUserInfo();
	//加载数据初始化
	onloadData();
	
	//加载数据初始化
	function onloadData(){
		$.ajax({
			type:"Post",
			url:"AnnouncementServlet?method=queryAllAnnoucementInfo",
			dataType:"Json",
			success:function(data){
				var length = data.length;
				var i = 0;
				var j = 0;
				if(data != null){
					//轮播三个最新
					for(i; i < 3; i++){
						var sliderHtml = '<!--循环体--><div class="slider-cell">'
						+'<div class="announcementPic-box ">'
						+'<div class="announcement-pic f-left">'
						+'<img src="images/gg'+i+'.jpg" /></div>'
						+'<div class="announcement-info f-left">'
						+'<div class="announcement-box">'
						+'<div class="announcement-theme ">'
						+'<span class="s-announcement-theme">'+data[i].announcementTheme+'  |  '+data[i].announcementCategory+'</span></div>'
						+'<div class="announcement-content">'
						+'<span class="s-announcement-content">'+data[i].announcementContent+'</span>'
						+'</div><div class="admin-info-box">'
						+'<div class="admin-head-img f-left">'
						+'<img src="'+data[i].adminHeadPhoto+'" /></div>'
						+'<span class="s-admin-name f-left">'+data[i].adminName+'</span>'
						+'<span class="s-timeTitle f-left">发布时间：</span>'
						+'<span class="s-time f-left">'+data[i].announcementTime+'</span>'
						+'</div></div></div></div></div><!--END 循环体-->'
						$('.slider-announcement'+i+'').append(sliderHtml);
					}
					for(j; j < length; j++){
						var html ='<!--循环公告-->'
						+'<div class="announcement-list ">'
						+'<div class="more-admin-head f-left">'
						+'<img src="'+data[j].adminHeadPhoto+'" /></div>'
						+'<div class="announcement-body clearfix">'
						+'<div class="more-announcment-theme">'
						+'<span class="s-m-theme">'+data[j].announcementTheme+'  |  '+data[j].announcementCategory+'</span>'
						+'<span class="s-m-admin">'+data[j].adminName+'</span>'
						+'<span class="s-m-time">'+data[j].announcementTime+'</span></div>'
						+'<div class="more-announcment-content ">'
						+'<span class="s-m-content ">'+data[j].announcementContent+'</span>'
						+'</div></div></div><!--END 循环公告-->'
						$(".announcement-more").append(html);
					}
				}else {
					alert("查询失败！");
					$(".search-null").css("display","block");
				}
			},
			error:function(error){
				alert("查询失败！");
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