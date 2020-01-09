$(function(){
	
	//加载界面的时候从localStorage获取修改作品的信息
	getStorage();
	
	$("#alterWorksInfoButton").click(function(){
		var worksName=$("#worksName").val();
		var worksID=$("#worksID").val();
		var worksIntroduction=$("#worksIntroduction").val();
		var worksCategory=$("#worksCategory").val()
		if(!worksName||!worksID||!worksIntroduction||!worksCategory)
		{
			alert("格式错误");
		}
		else
		{
			$.ajax({
				type : "post",
				url : "WorksServlet?method=modifyWorksInfoByWorksInfo",
				async : true,
				dataType : "json",
				data : {
					"worksName" : worksName,
					"worksID" : worksID,
					"worksIntroduction" : worksIntroduction,
					"worksCategory" : worksCategory
				},
				success : function(data) {
					// alert(data);
					if (data == "true") {
						var onlyChoseAlert = simpleAlert({
		                    "content":"修改成功！",
		                    "buttons":{
		                        "确定":function () {
		                            onlyChoseAlert.close();
		                        }
		                    }
		                });
					} else if (data == "false") {
						var onlyChoseAlert = simpleAlert({
		                    "content":"修改失败！",
		                    "buttons":{
		                        "确定":function () {
		                            onlyChoseAlert.close();
		                        }
		                    }
		                });
					}
					location.reload();
				}

			});
		}
	
	});
	
	
	//加载界面的时候从localStorage获取修改作品的信息
	function getStorage(){
		var data = localStorage.getItem("worksInfo");
		var worksInfo = JSON.parse(data);
		if(worksInfo != null && worksInfo != ""){
			$("#worksID").val(worksInfo.worksID);
			$("#worksName").val(worksInfo.worksName);
			$("#worksIntroduction").val(worksInfo.worksIntroduction);
			$("#worksCategory").val(worksInfo.worksCategory);
			$("#uploadAddressPreview").attr("src",worksInfo.uploadAddress);
		}
		//清除localStorage
		localStorage.removeItem("worksInfo");
			
	}
})