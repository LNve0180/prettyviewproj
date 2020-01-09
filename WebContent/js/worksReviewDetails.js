$(function(){
	var urlParam="worksID";//地址参数名字
	var adminInfo;//admin信息
	var worksID = getQueryString(urlParam);
	//通过session获取login信息；
	onloadAdminInfo();
	
	//加载数据
	onloadReviewDetails();
	
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
	
	//pass按钮
	$(".btnPass").on("click",function(){
		var reportStatus = 1;
		var reportResult = null;
		reviewWorks(reportStatus,reportResult);
	});
	
	//not pass 按钮
	$(".btnNotPass").on("click",function(){
		//取消确定按钮的不可点击
		$("button.btnOk").prop('disabled', false);
		//清除模态框的提示信息
		clearModalMsg();
		$('#myModal').modal();//打开模态框
	});
	
	//模态框确定按钮
	$(".btnOk").on("click",function(){
		
	});
	
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
	
	//加载数据
	function onloadReviewDetails(){
		//得到url的参数worksID
		//var worksID = getQueryString(urlParam);
		//ajax 获取Details
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryWorksReviewDetails",
			data:{
				"worksID":worksID
			},
			dataType:"Json",
			success:function(data){
				//success map list WorksShowInfo list reportInfo
				//写在html里
				$(".lblWorksID").html(data.WorksShowInfo.worksID);
				$(".lblWorksName").html(data.WorksShowInfo.worksName);
				$(".lblWorksUpdate").html(data.WorksShowInfo.uploadTime);
				$(".lblWorksIntroduction").html(data.WorksShowInfo.worksIntroduction);
				$(".lblAuthorID").html(data.WorksShowInfo.userID);
				$(".lblAuthorName").html(data.WorksShowInfo.userName);
				$(".lblCollectionNum").html(data.WorksShowInfo.collectNum);
				$(".lblLikeNum").html(data.WorksShowInfo.fabulousNum);
				$(".lblCommentNum").html(data.WorksShowInfo.commentNum);
				var imgHtml = "<img src=\" "+data.WorksShowInfo.uploadAddress+" \" data-magnify=\"gallery\" data-src=\" "+data.WorksShowInfo.uploadAddress+" \" src=\"small-1.jpg\"class=\"worksShow img-responsive center-block\" />";
				$(".img-box").children(".img-area").html(imgHtml);
				//写入举报原因
				var i = 0;;
				for( i; i < data.ReportWorksInfo.length; i++){
					var html = "<tr>"
					//+"<th class=\"tReportID\">"+i+"</th>"
					+"<th class=\"tReporterID\">"+data.ReportWorksInfo[i].userID+"</th>"
					+"<th class=\"tReason\">"+data.ReportWorksInfo[i].reportReason+"</th>"
					+"<th class=\"tTime\">"+data.ReportWorksInfo[i].reportTime+"</th>"
					+"</tr>"
					$("table.table-hover").children("tbody").append(html);
				}
				//显示总共条数
				$("label.title").children(".reportNum").html(data.ReportWorksInfo.length);
				//存入变量
				localStorage.setItem("reviewWorksShowInfo",JSON.stringify(data.WorksShowInfo));
				localStorage.setItem("reportWorksInfo",JSON.stringify(data.ReportWorksInfo));
			},
			error:function(error){
				alert("加载失败！");
			}
		});
//		//在相应的地方加上提示
//		$("span.reportBadge").html(i-1);
	}
	
	//0:拒绝 1:通过
	function reviewWorks(reportStatus,reportResult){
		//取出变量
		var worksShowInfo =localStorage.getItem("reviewWorksShowInfo");
		var reportWorksInfos =localStorage.getItem("reportWorksInfo");
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=modifyReportWorksInfo",
			dataType:"Json",
			data:{
				"worksID":worksID,
				"reportStatus":reportStatus,
				"reportResult":reportResult,
				"worksShowInfo":worksShowInfo,
				"reportWorksInfos":reportWorksInfos
			},
			success:function(data){
				//清除模态框的提示信息
				clearModalMsg();
				if(reportStatus == "1"){
					if(data == "true"){
						$(".btnPass").html("已通过");
						$(".btnNotPass").html("拒绝");
						$(".btnPass").prop('disabled', true);
						$(".btnNotPass").prop('disabled', false);
						alert("审核操作成功！");
						//模态框中显示提示
						var html = "<span style=\"color:green\">系统提示：操作成功，请点击关闭按钮。</span>";
						$("div.showMsg").append(html);
					}else if(data == "false"){
						alert("审核操作失败！");
						//模态框中显示提示
						var html = "<span style=\"color:red\">系统提示：操作失败，请点击关闭按钮。</span>";
						$("div.showMsg").append(html);
					}
					$('#myModal').modal('hide');
				}else if(reportStatus == "0"){
					if(data == "true"){
						$(".btnNotPass").html("已拒绝");
						$(".btnPass").html("通过");
						$(".btnNotPass").prop('disabled', true);
						$(".btnPass").prop('disabled', false);
						alert("审核操作成功！");
						//模态框中显示提示
						var html = "<span style=\"color:green\">系统提示：操作成功，请点击关闭按钮。</span>";
						$("div.showMsg").append(html);
						
					}else if(data == "false"){
						alert("审核操作失败！");
						//模态框中显示提示
						var html = "<span style=\"color:red\">系统提示：操作失败，请点击关闭按钮。</span>";
						$("div.showMsg").append(html);
					}
					$('#myModal').modal('hide');
				}
			},
			error:function(error){
				alert("操作失败！");
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
				var reportStatus = 0;
				reviewWorks(reportStatus,reportResult);
				//确定按钮无法操作，只能关闭按钮
				$("button.btnOk").prop('disabled', true);
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
	
	
	//加载管理员信息
	function onloadAdminInfo(){
		$.ajax({
			type:"Post",
			url:"AdminServlet?method=getAdminInfo",
			dataType:"Json",
			success:function(data){
				adminInfo = data;
			},
			error:function(error){
				alert("管理员信息加载失败!");
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