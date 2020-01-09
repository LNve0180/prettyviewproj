$(function(){
	//localStorage
	onloadUserInfo();
	
	//加载数据初始化
	onloadData();
	//加载数据初始化
	function onloadData(){
		$.ajax({
			type:"Post",
			url:"CareServlet?method=queryCareInfoByUserID",
			dataType:"Json",
			success:function(data){
				$(".care-info-area").children("div.care-list").remove();
				var i = 0;
				var length = data.length;
				if(data != null){
					for(i; i < length; i++){
						var html = '<!--循环-->'
							+'<div class="care-list ">'
							+'<span class="caredID" style="display: none;">'+data[i].userID+'</span>'
							+'<div class="cared-head f-left">'
							+'<a href=userAllWorksDisplayForm.html?userID='+data[i].userID+'><img src="'+data[i].userHeadPhoto+'" /></a></div>'
							+'<div class="care-body clearfix">'
							+'<div class="cared-theme">'
							+'<a href="userAllWorksDisplayForm.html?userID='+data[i].userID+'" class="s-m-theme">'+data[i].userName+'</a></div>'
							+'<div class="cared-content ">'
							+'<span class="s-m-content ">'+data[i].userIntroduction+'</span>'
							+'</div>'
							+'<div class="cared-btn-item ">'
							+'<button class="btnCare btn btn-default" style="width: 110px;">已关注</button>'
							+'<button class="btnPM btn btn-default" style="width: 110px;margin-left: 10px;">私信</button></div>'
							+'</div></div><!--END 循环-->'
						$(".care-info-area").append(html);
					}
					//给按钮绑定事件
					//解绑
					$("div.care-info-area").off("click");
					//再绑定关注按钮
					$("div.care-info-area").on("click",".btnCare",function(event){
						var caredID = $(this).parents("div.care-list").children("span.caredID").html();
						var careBtn = $(this).html();
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
										$(this).html("已关注");
										alert("关注成功！");
										location.reload();
									}else if(data=="关注失败！"){
										alert("关注失败！");
										location.reload();
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
										$(this).html("关注");
										alert("已取消关注！");
										location.reload();
									}else if(data=="取消关注失败！"){
										alert("取消关注失败！");
										location.reload();
									}
								}
							});
						}
					});
					//再绑定私信按钮
					$("div.care-info-area").on("click",".btnPM",function(event){
						var caredID = $(this).parents("div.care-list").children("span.caredID").html();
						//写入pmModal;
						$("span.pm-userID").html(caredID);
						//打开modal
						$('#pmModal').modal();
					});
				}else{
					alert("查询失败！");
					$(".search-null").css("display","block");
				}
			},
			error:function(error){
				alert("查询失败！");
			}
		});
	}
	//私信模态框发送按钮
	$(".pmCommentBtn").on("click",function(){
		var pmUserID = $(".pm-userID").html();
		var pmContent = $(".pmContent").val();
		alert(pmUserID);
		if(pmContent != null && pmContent != ""){
			//AJAX 调用
			$.ajax({
				type:"Post",
				url:"PersonalMessageServlet?method=addPersonalMessageInfo",
				dataType:"Json",
				data:{
					"whisperedID":pmUserID,
					"pmContent":pmContent
				},
				success:function(data){
					$("#pmModal").modal('hide');
					var onlyChoseAlert = simpleAlert({
	                    "content":data,
	                    "buttons":{
	                        "确定":function () {
	                        	location.reload();
	                            onlyChoseAlert.close();
	                        }
	                    }
	                });
					
				},
				error:function(error){
					
				}
			});
		}else{
			alert("输入内容不能为空。");
		}
		
	});
	//私信模态框关闭按钮
	$(".replyCommentClose").on("click",function(){
		$(".pm-userID").html("");
		$(".pmContent").val("");
		
	});
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
			//写入span.userID 包含//判断左边栏
			$("span.userID").html(userLoginInfo.userID);
			if(userLoginInfo.creatorStatus == 1){
				$("li.li-myWorks").css('display','block');
				$("a.myWorks").css('display','block');
			}
			if(userLoginInfo.creatorStatus != 1){
				$("li.li-applyCreator").css('display','block');
				$("a.applyCreator").css('display','block');
			}
		}
	}
});