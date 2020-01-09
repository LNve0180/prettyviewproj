$(function(){
	var userLoginInfo;
	
	//通过session获取Login信息
	getLoginInfo();
	
	//点击作品查询按钮事件
	$("#worksSearch").on("click",function(){
		searchWorks();
	});
	
	//点击作者查询按钮事件
	$("#worksSearch").on("click",function(){
		searchUser();
	});
	
	//查询作品
	function searchWorks(){
		var searchWorks = $("#searchContent").val();
		document.searchForm.action="WorksServlet?method=queryWorksInfoBySearchContent";
		document.searchForm.submit();
	}
	
	//查询作者
	function searchUser(){
		var searchUser = $("#searchContent").val();
		document.searchForm.action="UserServlet?method=queryUserInfoBySearchContent";
		document.searchForm.submit();
	}
	
	//通过session获取Login信息
	function getLoginInfo(){
		//ajax获取
		$.ajax({
			type:"Post",
			url:"UserServlet?method=getUserLoginInfo",
			dataType:"Json",
			success:function(data){
				userLoginInfo = data;
				onloadLoginInfo(userLoginInfo);
			},
			error:function(error){
				
			}
		});
	}
	
	//加载用户信息
	function onloadLoginInfo(userLoginInfo){
		$("div.head-img").children("img").attr("src",""+userLoginInfo.userHeadPhoto+"");
	}
});