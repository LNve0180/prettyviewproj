$(function(){
	
	$(".searchSimilar").on("click",function(){
		location.href="searchSimilarWorksForm.jsp";
	});
	$(".searchWorks").on("click",function(){
		var searchContent = $("#searchContent").val();
		if(searchContent != null && searchContent != "" ){
			//跳转查询结果界面
			location.href= encodeURI("worksSearchResultForm.html?searchContent="+searchContent);
		}else{
			
		}
	});
	$(".searchUser").on("click",function(){
		var searchContent = $("#searchContent").val();
		if(searchContent != null && searchContent != "" ){
			//跳转查询结果界面
			location.href= encodeURI("userSearchResultForm.html?searchContent="+searchContent);
		}else{
			
		}
	});
	
});