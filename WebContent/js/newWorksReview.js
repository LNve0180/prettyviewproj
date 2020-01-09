$(function(){
	var adminInfo;
	var data={};
	//初始化页面加载
	searchReviewData();
	//加载管理员信息
	onloadAdminInfo();
	//刷新按钮绑定事件
	$(".fleshBtn").on("click",function(){
		location.reload();
	});
	//初始化插件
	$('.icheck').iCheck({
		checkboxClass: 'icheckbox_minimal',
		radioClass: 'iradio_minimal',
		increaseArea: '20%' // optional
	});
	
	//模态框关闭按钮初始化
	onBtnCancle();
	
	//模态框确定按钮初始化
	onBtnOk();
	
	//模态框确定按钮
	$(".btnOk").on("click",function(){
		
	});
	//初始化页面加载
	function searchReviewData(){
		//ajax获取数据
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryUnaditedWorksInfo",
			dataType:"Json",
			success:function(data){
				var i = 0; 
				var length = data.length;
				$("span.reportNum").html(length);
				if(length >= 10){
					length = 10;
				}
				for(i; i < length ; i++){
					var html="<tr>"
					+"<th class=\"tworksInfo\">"
					+"<div class=\"\" style=\"height: 50px;width: 50px; background-color: #001C4A;\"> "
					+"<img src=\""+data[i].uploadAddress+"\" data-magnify=\"gallery\" data-src=\""+data[i].uploadAddress+"\" src=\"small-1.jpg\"class=\"timg img-responsive center-block\" style=\"width: 100%; height: 100%;\"/>"
					+"</div>"
					+"</th>"
					+"<th class=\"tworksID\">"+data[i].worksID+"</th>"
					+"<th class=\"tworksName\">"+data[i].worksName+"</th>"
					+"<th class=\"tuserID\">"+data[i].userID+"</th>"
					+"<th class=\"tusername\">"+data[i].userName+"</th>"	
					+"<th class=\"ttime\">"+data[i].uploadTime+"</th>"
					+"<th>"
					+"<button class=\"btnPass btn btn-success\">通过</button>"
					+"<button class=\"btnNotPass btn btn-danger\">不通过</button>"
					+"</th>"
					+"</tr>"
					$("table.table-hover").children("tbody").append(html);
				}
				//给按钮绑定事件
				//解绑
				$("table.table-hover").off("click");
				//再绑定通过按钮
				$("table.table-hover").on("click",".btnPass",function(event){
					var reviewStatus = 1;// 1:审核通过 0:审核不通过
					var reviewReason = "";
					var worksID = $(this).parents("tr").children("th.tworksID").html();
					var worksName = $(this).parents("tr").children("th.tworksName").html();
					var uploadTime = $(this).parents("tr").children("th.ttime").html();
					var userID = $(this).parents("tr").children("th.tuserID").html();
					var data = {
							"worksID":worksID,
							"worksName":worksName,
							"uploadTime":uploadTime,
							"reviewStatus":reviewStatus,
							"reviewReason":reviewReason,
							"userID":userID
					}
					reviewWorks(data);
				});
				//再绑定不通过按钮
				$("table.table-hover").on("click",".btnNotPass",function(event){
					var reviewStatus = 0;// 1:审核通过 0:审核不通过
					var worksID = $(this).parents("tr").children("th.tworksID").html();
					var worksName = $(this).parents("tr").children("th.tworksName").html();
					var uploadTime = $(this).parents("tr").children("th.ttime").html();
					var userID = $(this).parents("tr").children("th.tuserID").html();
					$("span.worksID").html(worksID);
					$("span.worksName").html(worksName);
					$("span.uploadTime").html(uploadTime);
					$("span.reviewStatus").html(reviewStatus);
					$("span.userID").html(userID);
					//清除模态框的提示信息
					clearModalMsg();
					$('#myModal').modal();//打开模态框
				});
			},
			error:function(error){
				alert("数据加载失败！");
			}
		});
	}
	
	//审核作品 0:不通过 1：通过
	function reviewWorks(info){
		//ajax 传送处理状态
		clearModalMsg();
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=reviewNewWorks",
			data:{
				"worksID":info.worksID,
				"worksName":info.worksName,
				"uploadTime":info.uploadTime,
				"reviewStatus":info.reviewStatus,
				"reviewReason":info.reviewReason,
				"userID":info.userID
			},
			dataType:"Json",
			success:function(data){
				if(data == "true"){
					alert("审核操作成功！");
				}else{
					alert("审核操作失败！");
				}
				$('#myModal').modal('hide');
				loaction.reload();
			},
			error:function(error){
				alert("审核操作失败！");
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
			//清除模态框的提示信息
			clearModalMsg();
		});
	}
	
	//清除模态框的提示信息
	function clearModalMsg(){
		$("div.showMsg").children().remove();
	}
	
	
	//模态框确定按钮初始化
	function onBtnOk(){
		$("button.btnOk").on("click",function(event){
			var check = checkReportResult();
			if(check == true){
				var reportResult = "";//举报结果
				//获取复选框值
				$("input.icheck").each(function(i,domEle){
					if($(this).is(':checked')){
						var  v = $(this).val();
						reportResult += v + ",";
					}
				});
				//获取输入区域值
				var reasonText =  $("textarea.reasonText").val();
				//将获取到的数据弄成一窜字
				if(reasonText != null && reasonText != ""){
					reportResult = reportResult + reasonText;
				}else{
					reportResult = reportResult.substring(0,reportResult.length-1);
				}
				//ajax 后端处理
				var data = {
						"worksID":$("span.worksID").html(),
						"worksName":$("span.worksName").html(),
						"uploadTime":$("span.uploadTime").html(),
						"reviewStatus":$("span.reviewStatus").html(),
						"reviewReason":reportResult,
						"userID":$("span.userID").html()
				}
				reviewWorks(data);
				//清空span
				clearSpanMsg();
				//确定按钮无法操作，只能关闭按钮
				//$("button.btnOk").prop('disabled', true);
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

	//清空span
	function clearSpanMsg(){
		$("span.worksID").html("");
		$("span.worksName").html("");
		$("span.uploadTime").html("");
		$("span.reviewStatus").html("");
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