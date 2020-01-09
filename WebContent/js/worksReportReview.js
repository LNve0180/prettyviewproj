$(function(){
	var adminInfo="";
	var urlParam="";
	//获取session
	onloadAdminInfo();
	//加载数据
	onloadInfo();
	
	//刷新按钮
	$("button.btn-info").click(function() {
		location.reload();
	});

	//加载数据
	function onloadInfo(){
		//ajax 参数带上urlParam
		$.ajax({
			type:"Post",
			url:"WorksServlet?method=queryWorksReviewInfo",
			dataType:"Json",
			success:function(data){
				var i = 0;
				var length = data.length;
				$("span.reportNum").html(length);
				if(length >= 10){
					length = 10;
				}
				//success里返回举报信息 循环写入html
				for( i; i < length; i++){
					var html = "<tr>"
						+"<th class=\"tWorksID\">"+data[i].worksID+"</th>"
						+"<th class=\"tWorksName\">"+data[i].worksName+"</th>"
						+"<th class=\"tCount\">"+data[i].reportNum+"</th>"
						+"<th>"
						+"<button class=\"btnDetail btn btn-success\">详情</button>"
						+"</th>"
						+"</tr>"
						$("table.table-hover").children("tbody").append(html);
				}
				//给按钮绑定事件
				//解绑
				$("table.table-hover").off("click");
				//再绑定
				$("table.table-hover").on("click",".btnDetail",function(event){
					var tWorksName = $(this).parents("tr").children("th.tWorksName").html();
					var tWorksID = $(this).parents("tr").children("th.tWorksID").html();
					var tCount = $(this).parents("tr").children("th.tCount").html();
					window.location.href="worksReviewDetailsForm.jsp?worksID="+tWorksID+" ";
					event.stopPropagation();
				});
			},
			error:function(error){
				alert("加载失败！");
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