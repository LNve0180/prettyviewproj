$(function(){
	
	//加载管理员信息
	onloadAdminInfo();
	//加载数据
	onloadData();
	//绑定审核按钮事件
	$(".commentReviewBtn").on("click",function(){
		$.ajax({
			type:"post",
			url:"CommentServlet?method=automaticAuditCommentReport",
			dataType:"Json",
			success:function(data){
				if(data=="true"){
					alert("审核操作成功！");
				}else{
					alert("审核操作失败！");
				}
			},
			error:function(error){
				alert("审核操作失败！");
			}
		});
	});
	//绑定刷新按钮事件
	$(".refleshBtn").on("click",function(){
		loaction.reload();
	});
	//加载数据
	function onloadData(){
		$.ajax({
			type:"post",
			url:"CommentServlet?method=queryAllReportCommentInfo",
			dataType:"Json",
			success:function(data){
				var i = 0;
				var length = data.length;
				$("span.reportNum").html(length);
				if(data != null && data != ""){
					for(i; i < length ; i++){
						var html = '<tr>'
							+'<th class="userID">'+data[i].userID+'</th>'
							+'<th class="commentID">'+data[i].commentID+'</th>'
							+'<th class="reportReason">'+data[i].reportCommentReason+'</th>'
							+'<th class="reportTime">'+data[i].reportCommentTime+'</th>'
							+'</tr>';
						$("table.table-hover").children("tbody").append(html);
					}
				}else{
					$(".commentReviewBtn").attr('disabled', true);
//					alert("暂无举报。");
				}
			},
			error:function(error){
				alert("查询失败");
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