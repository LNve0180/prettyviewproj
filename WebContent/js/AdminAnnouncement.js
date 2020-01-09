$(function(){
	//加载管理员信息
	onloadAdminInfo();
	//页面初始化
	onloadInfo();
	
	function onloadInfo(){
		//加载数据
		$.ajax({
			type:"Post",
			url:"AnnouncementServlet?method=queryAnnouncementInfo",
			dataType:"Json",
			success:function(data){
				//将data写入Html
				//将后台返回字符串转换成javascript能识别的json对象
				//var data = eval('(' + data + ')');
				if(data!="1"){
					var i;
					for(i = 0; i < data.length; i++) {
						var html = "<div class=\"panel panel-headline\"> "
							+" <div class=\"panel-heading\"> "
							+" <div class=\"img-box\"> "
							+" <img src=\" "+data[i].adminHeadPhoto+" \" class=\"img-circle\" /> "
							+" </div> "
							+" <div class=\"info-box\"> "
							+" <div class=\"info-details\"> "
							+" <label >"+data[i].announcementTheme+"</label> "
							+" <label >|</label> "
							+" <label >"+data[i].announcementCategory+"</label> "
							+" </div> "
							+" <div class=\"info-details\"> "
							+" <label >"+data[i].adminName+"</label> "
							+" </div> "
							+" </div> "
							+" </div> "
							+" <div class=\"panel-body\">"+data[i].announcementContent+"</div>"
							+" <div class=\"info-details\"> "
							+" <span class=\"announcement-id\" style=\"display: none;\">"+data[i].announcementID+"</span> "
							+" <label style=\"float: right;margin-right: 25px;\">"+data[i].announcementTime+"</label> "
							+" </div> "
							+" <div class=\"panel-body\"> "
							+" <div style=\"float:right;\"> "
							+" <button class=\"btn btn-danger\">Delete</button> </div></div></div>";
						$("div.main-content").children("div.container-fluid").append(html);
					}
				}else{
					alert("查询失败！");
				}
				//给按钮绑定事件
				//解绑
				$("div.main-content").off("click");
				//再绑定
				$("div.main-content").on("click","button.btn-danger",function(event){
					var announcementID = $(this).parents("div.panel-headline").children("div.info-details").children("span.announcement-id").html();
					//ajax调用后台方法修改status
					updateAnnouncement(announcementID);
					event.stopPropagation();
				});
			},
			error:function(error){
				alert("查询失败！");
			}
		});
	}
	
	/*
	*删除公告
	*author:huangyulun
	* data:2019/04/01
	*/
	function updateAnnouncement(announcementID){
		$.ajax({
			type:"Post",
			url:"AnnouncementServlet?method=modifyAnnouncementStatusByID",
			data:{
				"announcementID":announcementID
			},
			//dataType:"Json",
			success:function(data){
				if(data=="true"){
					alert("删除成功！");
				}else{
					alert("删除失败！");
				}
				//刷新界面
				window.location.reload();
			},
			error:function(error){
				alert("删除失败！");
			}
		});
	}
	//加载管理员信息
	function onloadAdminInfo(){
		var data = localStorage.getItem("loginAdminInfo");
		var adminLoginInfo = JSON.parse(data);
		//写入导航头
		$("img.img-circle").attr("src",adminLoginInfo.adminHeadPhoto);
		$(".admin").children("span").html(adminLoginInfo.adminName);
	}
});