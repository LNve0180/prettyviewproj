$(function(){
	var reportWorksFlag = 1;
	var reportCommentFlag = 2;
	var urlParam="worksID";
	var worksID = getQueryString(urlParam);

	//localStorage
	onloadUserInfo();
	
	//加载数据初始化
	onloadData();
	
	//初始化插件
	$('.icheck').iCheck({
		checkboxClass: 'icheckbox_minimal',
		radioClass: 'iradio_minimal',
		increaseArea: '20%' // optional
	});
	
	//模态框关闭按钮初始化
	onBtnCancle();
	
/*	//模态框确定按钮初始化
	onBtnOk();*/
	
	//判断点赞，收藏，关注是否
	isDataClick();
	
	
	//显示时间初始化
	$(".t-uploadTime").timeago();
	
	//举报作品按钮绑定事件
	$(".reportWorksBtn").on("click",function(){
		clearModalMsg();
		//模态框确定按钮初始化
		onBtnOk(reportWorksFlag);
		$('#myModal').modal();
	});
	
	//关注按钮绑定事件
	$(".btnCare").on("click",function(){
		saveCareInfo();
	});
	
	//私信按钮绑定事件
	$(".btnPM").on("click",function(){
		alert("私信按钮启动");
		var caredID = $("span.s-authorID").html();
		alert(caredID);
		//写入pmModal;
		$("span.pm-userID").html(caredID);
		//打开modal
		$('#pmModal').modal();
	});
	
	//私信模态框发送按钮
	$(".pmCommentBtn").on("click",function(){
		var pmUserID = $(".pm-userID").html();
		var pmContent = $(".pmContent").val();
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
	
	
	//点赞按钮绑定事件
	$(".btnLike").on("click",function(){
		var userID = $("span.userID").html();
		var btnVal = $(".btnLike").html();
		if(btnVal=="点赞"){
			$.ajax({
				type:"post",
				url:"WorksServlet?method=addFabulousInfo",
				async:true,
				dataType:"json",
				data:{
					"worksID":worksID
				},
				success:function(data){
					//alert(data);
					if(data=="点赞成功！"){
						$(".btnLike").html("已点赞");
						$(".btnLike").attr("disabled",true);
						var onlyChoseAlert = simpleAlert({
		                    "content":data,
		                    "buttons":{
		                        "确定":function () {
		                        	location.reload();
		                            onlyChoseAlert.close();
		                        }
		                    }
		                });
					}else {
						var onlyChoseAlert = simpleAlert({
		                    "content":data,
		                    "buttons":{
		                        "确定":function () {
		                        	location.reload();
		                            onlyChoseAlert.close();
		                        }
		                    }
		                });
					}
				}
			});
		}
	});
	
	//回复评论模态框回复按钮
	$(".replyCommentBtn").on("click",function(){
		var commentID = $(".reply-to-commentID").html();
		var replyCommentContent = $(".replyCommentContent").val();
		//AJAX 调用
		$.ajax({
			type:"Post",
			url:"CommentServlet?method=addReplyInfo",
			dataType:"Json",
			data:{
				"commentID":commentID,
				"replyCommentContent":replyCommentContent
			},
			success:function(data){
				$("#replyCommentModal").modal('hide');
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
	});
	//回复评论模态框关闭按钮
	$(".replyCommentClose").on("click",function(){
		$(".reply-to-commentID").html("");
		$(".replyCommentContent").val("");
		
	});
	
	//发表评论按钮绑定事件
	$(".commentBtn").on("click",function(){
		var commentContent = $(".commentContent").val();
		var userID = $("span.userID").html();
		if(commentContent != "" && commentContent != null){
			$.ajax({
				type:"Post",
				url:"CommentServlet?method=addCommentInfo",
				data:{
					"worksID":worksID,
					"commentcontent":commentContent
				},
				dataType:"json",
				success:function(data){
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
			alert("您输入的内容不符合格式。");
		}

	});
	
	//收藏按钮绑定事件
	$(".btnCollect").on("click",function(){
		var collectBtn = $(".btnCollect").html();
		if(collectBtn=="收藏"){
			$.ajax({
				type:"post",
				url:"CollectServlet?method=addCollectInfoByCollectInfo",
				async:true,
				dataType:"json",
				data:"&worksID="+worksID,
				success:function(data){
					//alert(data);
					if(data=="收藏成功"){
						$(".btnCollect").html("已收藏");
						alert("用户添加收藏成功");
					}else if(data=="收藏失败"){
						alert("用户添加收藏失败");
					}
				}
			});
		}else if(collectBtn == "已收藏"){
			$.ajax({
				type: "post",
				url: "CollectServlet?method=cutoffCollectInfoByUserIDWorksID",
				async: true,
				dataType: "json",
				data: {
					"worksID": worksID
				},
				success: function(data) {
					// alert(data);
					if(data == "true") {
						$(".btnCollect").html("收藏");
						alert("用户删除收藏作品成功");
					} else {
						alert("用户删除收藏作品失败");
					}
				}
			});

		}
	});
	
	//加载数据初始化
	function onloadData(){
		//ajax 查询作品信息
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryWorksInfoByWorksID",
			data:{
				"worksID":worksID
			},
			dataType:"json",
			success:function(data){
				if(data != null && data !="null" ){
					var userUrl="userAllWorksDisplayForm.html?userID="+data.userID+"";
					var worksUrl="worksDisplayForm.html?worksID="+data.worksID+"";
					$(".h-worksName").html(data.worksName);
					$(".t-uploadTime").attr("dateTime",data.uploadTime);
					$(".collectNum").html(data.collectNum);
					$(".likeNum").html(data.fabulousNum);
					$(".commentNum").html(data.commentNum);
					$(".img-user-head").attr("src",data.userHeadPhoto);
					$(".a-author").attr("href",userUrl);
					$(".a-userName").html(data.userName);
					$(".a-userName").attr("href",userUrl);
					$(".works-intruduction").html(data.worksIntroduction);
					$(".img-uploadAddress").attr("src",data.uploadAddress);
					$(".div-name").children("a").html(data.userName);
					$("span.s-authorID").html(data.userID);
					
					//判断是否关注
					var userID = $("span.userID").html();
					var caredID = $("span.s-authorID").html();
					$.ajax({
						type:"post",
						url:"CareServlet?method=searchCareInfoIsExist",
						async:true,
						dataType:"json",
						data:{
							"caredID":caredID
						},
						success:function(data){
							if(data=="存在"){
								$(".btnCare").html("已关注");	
							}else if(data=="不存在"){
								$(".btnCare").html("关注");
							}
						}
					});
				}
			},
			error:function(error){
				
			}
			
		});

		//ajax 查询评论信息
		$.ajax({
			type:"Post",
			url:"CommentServlet?method=queryCommentReplyInfoByWorksID",
			data:{
				"worksID":worksID
			},
			dataType:"json",
			success:function(data){
				if(data!=null){
					//循环加载评论
					var i = 0;
					for(i; i < data.length; i++){
						var commentHtml='<!--x循环评论-->'
							+'<div class="comment-info-box">'
							+'<span class="commentID" style="display: none;">'+data[i].commentID+'</span>'
							+'<div class="comment-box clearfix">'
							+'<!--头像--><div class="div-commment-head f-left">'
							+'<a href="userAllWorksDisplayForm.html?userID='+data[i].userID+'" class="a-comment-head"><img  src="'+data[i].userHeadPhoto+'"/></a></div>'
							+'<!--END 头像-->'
							+'<!--信息+内容--><div class="div-comment-info f-left">'
							+'<!--用户--><div class=""><a href="userAllWorksDisplayForm.html?userID='+data[i].userID+'" class="a-comment-userName">'+data[i].userName+'</a>'
							+'<span class="s-comment-time">'+data[i].commentTime+'</span>'
							+'<span class="reportCommentBtn lnr lnr-warning f-right" style="font-size: 12px; margin-right: 20px;" title="举报评论">举报</span>'
							+'</div>'
							+'<div class="div-commentContent">'
							+'<span class="commentContent" style="margin-left: 20px;">'+data[i].commentContent+'</span></div>'
							+'<div class="c-btnItem">'
							+'<span class="likeBtn f-right iconfont icon-good" title="点赞">'+data[i].CommentFabulousNum+'</span>'
							+'<span class="replyCommentBtn f-right iconfont icon-comments"title="回复评论"></span></div></div>'
							+'<!--END 信息+内容-->'
							+'</div></div><!--END 评论-->';
						$(".commentwrap").append(commentHtml);
						if(data[i].replyUserID != null){
							var replyUserID = data[i].replyUserID.split("&");
							var replyContent = data[i].replyContent.split("&");
							var replyUserName = data[i].replyUserName.split("&");
							var replyTime = data[i].replyTime.split("&");
							var replyUserHeadPhoto = data[i].replyUserHeadPhoto.split("&");
							var j = 0;
							for(j; j < replyUserID.length; j++){
								var replyHtml='<!--回复评论显示区域 循环-->'
									+'<div class="reply-comment-area f-left">'
									+'<div class="r-head-photo f-left">'
									+'<a href="userAllWorksDisplayForm.html?userID='+replyUserID[j]+'" class="a-r-head-photo"><img src="'+replyUserHeadPhoto[j]+'" /></a>'
									+'</div>'
									+'<div class="r-info-box f-left">'
									+'<span class="s-r-userName"><a href="userAllWorksDisplayForm.html?userID='+replyUserID[j]+'" class="a-r-name a-hover">'+replyUserName[j]+'</a></span>'
									+'<span class="s-r-replyTime">'+replyTime[j]+'</span>'
									+'<div class="div-r-content">'
									+'<span class="s-r-content">'+replyContent[j]+'</span>'
									+'</div>'
									+'</div></div><!--END 回复评论显示区域 循环-->';
								$(".comment-box:eq("+i+")").append(replyHtml);
							}
						}
					}
					//给按钮绑定事件
					//解绑
					$("div.commentwrap").off("click");
					//再绑定回复评论按钮
					$("div.commentwrap").on("click","span.replyCommentBtn",function(event){
						var commentID = $(this).parents("div.comment-info-box").children("span.commentID").html();
						var userID = $("span.userID").html();
						//把评论ID写入模态框;
						$(".reply-to-commentID").html(commentID);
						//显示模态框
						$('#replyCommentModal').modal();
					});
					//再绑定举报评论按钮
					$("div.commentwrap").on("click","span.reportCommentBtn",function(event){
						var commentID = $(this).parents("div.comment-info-box").children("span.commentID").html();
						//写入modal某个位置
						$("span.report-commentID").html(commentID);
						clearModalMsg();
						//初始化模态框确认按钮
						onBtnOk(reportCommentFlag);
						$('#myModal').modal();//打开模态框
					});
					//再绑定点赞评论按钮
					$("div.commentwrap").on("click","span.likeBtn",function(event){
						var commentID = $(this).parents("div.comment-info-box").children("span.commentID").html();
						$.ajax({
							type:"post",
							url:"CommentServlet?method=addCommentFabulousInfo",
							async:true,
							dataType:"json",
							data:{
								"commentID":commentID
							},
							success:function(data){
								//alert(data);
								if(data=="点赞成功！"){
									$(this).css('color','#ffe300');
									var onlyChoseAlert = simpleAlert({
					                    "content":data,
					                    "buttons":{
					                        "确定":function () {
					                        	location.reload();
					                            onlyChoseAlert.close();
					                        }
					                    }
					                });
								}else if(data=="点赞失败！"){
									var onlyChoseAlert = simpleAlert({
					                    "content":data,
					                    "buttons":{
					                        "确定":function () {
					                        	location.reload();
					                            onlyChoseAlert.close();
					                        }
					                    }
					                });
								}
							}
						});
					});
				}else{
					
				}
				
			},
			error:function(error){
				
			}
		});
	}
	
	//判断点赞，收藏，关注是否
	function isDataClick(){
		//添加历史记录
		$.ajax({
			type:"post",
			url:"HistoryServlet?method=addHistoryInfo",	
			async:true,
			dataType:"json",
			data:{
				"worksID":worksID
			},
			success:function(data){
				//alert(data);
			}
		});
		
		//判断是否点赞
		$.ajax({
			type:"post",
			url:"WorksServlet?method=searchFabulousInfoIsExist",
			async:true,
			dataType:"json",
			data:{
				"worksID":worksID
			},
			success:function(data){
				//alert(data);
				if(data=="存在"){
					$(".btnLike").html("已点赞");
					$(".btnLike").attr("disabled",true);
				}
			}
		});
		
		//判断是否收藏
		$.ajax({
			type:"post",
			url:"CollectServlet?method=searchCollectInfoIsExist",
			async:true,
			dataType:"json",
			data:"&worksID="+worksID,
			success:function(data){
				if(data=="已收藏"){
					$(".btnCollect").html("已收藏");
				}else{
					$(".btnCollect").html("收藏");
				}
			}
		});
		
		

	}
	
	//模态框关闭按钮初始化
	function onBtnCancle(){
		$("#myModal").on("hide.bs.modal",function(){
			//清空复选框
			$("input.icheck").each(function(i,domEle){
				if($(this).is(':checked')){
					$(this).iCheck("uncheck");
				}
			});
			//清空输入区域
			$(".reasonText").val("");
			$("span.report-commentID").html("");
			//清除模态框的提示信息
			clearModalMsg();
		});
	}
	
	//模态框确定按钮初始化
	function onBtnOk(flag){
		$("button.btnOk").on("click",function(event){
			var check = checkReportResult();
			if(check == true){
				var reportReason = "";//举报原因
				//获取复选框值
				$("input.icheck").each(function(i,domEle){
					if($(this).is(':checked')){
						var  v = $(this).val();
						reportReason += v + ",";
					}
				});
				//获取输入区域值
				var reasonText =  $("textarea.reasonText").val();
				//将获取到的数据弄成一窜字
				if(reasonText != null && reasonText != ""){
					reportReason = reportReason + reasonText;
				}else{
					reportReason = reportReason.substring(0,reportReason.length-1);
				}
				reportMehod(reportReason,flag);
				/*//关闭模态框
				$("#myModal").modal('hide');*/
			}
			event.stopPropagation();
		});
	}
	
	//检查拒绝理由
	function checkReportResult(){
		var resultTemp = "";
		$("input.icheck").each(function(i,domEle){
			if($(this).is(':checked')){
				var  v = $(this).val();
				resultTemp += v ;
			}
		});
		if(resultTemp != "" && resultTemp != null){
			return true;
		}else {
			//模态框中显示提示
			var html = "<span style=\"color:red\">提示：请选择拒绝理由</span>";
			$("div.showMsg").append(html);
			return false;
		}
	}
	
	//清除模态框的提示信息
	function clearModalMsg(){
		$("div.showMsg").children().remove();
	}
	
	/*举报作品、评论二合一
	 * param : 举报原因，举报方式  1:举报作品 2:举报评论
	 * */
	function reportMehod(reportReason,flag){
		if(flag == 1){
			//举报作品
			$.ajax({
				type:"post",
				url:"WorksServlet?method=addReportWorksInfo",
				async:true,
				dataType:"json",
				data:{
					"reportContent":reportReason,
					"worksID":worksID
				},
				success:function(data){
					$("#myModal").modal('hide');
					alert(data);
					location.reload();
				},
				error:function(error){
					
				}
			})
		}else if(flag == 2){
			//举报评论
			var commentID = $("span.report-commentID").html();
			$.ajax({
				type:"post",
				url:"CommentServlet?method=addReportCommentInfo",
				async:true,
				dataType:"json",
				data:{
					"commentID":commentID,
					"reportCommentContent":reportReason
				},
				success:function(data){
					$("#myModal").modal('hide');
					alert(data);
					location.reload();
				},
				error:function(error){
					
				}
			});
		}
	}
	
	//关注按钮初始化
	function saveCareInfo(){
		var careBtn = $(".btnCare").html();
		var userID = $("span.userID").html();
		var caredID = $("span.s-authorID").html();
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
						$(".btnCare").html("已关注");
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
						$(".btnCare").html("关注");
						alert("已取消关注！");
					}else if(data=="取消关注失败！"){
						alert("取消关注失败！");
						}
					}
			});
		}
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
	
	//获取url参数方法
	function getQueryString(param){
		var reg = new RegExp("(^|&)"+ param +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null){
			return unescape(r[2]);//若传中文 decodeURI
		}else{
			return null;
		}
	}

});