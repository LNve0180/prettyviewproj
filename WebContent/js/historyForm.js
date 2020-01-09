$(function(){
	//获取用户登录信息
	onloadUserInfo();
	
	//加载历史纪录
	onloadHistory();
	
	//加载历史纪录
	function onloadHistory(){
		var userID = $("span.userID").html();
		$.ajax({
			type:"Post",
			url:"HistoryServlet?method=queryAllHistoryByUserID",
			data:{
				"userID":userID
			},
			dataType:"Json",
			success:function(data){
				var i = 0;
				for(i; i < data.length; i++){
					var dataTime = getTime(data[i].historyTime);
					var html= "<!--BEGIN 循环内容-->"
						+"<li><time class=\"cbp_tmtime\" datetime=\""+data[i].historyTime+"\"><span>"+dataTime.thatdate+"</span><span>"+dataTime.time+"</span></time>"
						+"<div class=\"cbp_tmicon cbp_tmicon-phone\"></div>"
						+"<div class=\"cbp_tmlabel\">"
						+"<div class=\"history-panel\"><div class=\"history-img\"><a class=\"a-img\" href=\"worksDisplayForm.html?worksID="+data[i].worksID+"\"><img src=\""+data[i].uploadAddress+"\" /></a></div>"
						+"<div class=\"history-msg\"><P class=\"p-worksName\"><a class=\"a-worksName\" href=\"worksDisplayForm.html?worksID="+data[i].worksID+"\">"+data[i].worksName+"</a></P>"
						+"<span class=\"p-introduction\"><a class=\"a-introduction\">"+data[i].worksIntroduction+"</a></span>"
						+"<div class=\"h-user-msg \"><div class=\"h-headimg h-left\"><img src=\""+data[i].userheadPhoto+"\" /></div>"
						+"<div class=\"h-user-info h-left\"><span class=\"h-userName\">"+data[i].userName+"</span><span >|</span>"
						+"<span >"+data[i].worksCatrgory+"</span></div></div></div>"
						+"<div class=\"delete-box\"><span class=\"p-delete\">"
						+"<span class=\"btnDelet lnr lnr-trash\"></span></span></div>"
						+"<span class=\"historyTime\" style=\"display: none;\">"+data[i].historyTime+"</span>"
						+"<span class=\"worksID\" style=\"display: none;\">"+data[i].worksID+"</span></div></div></li>"
						+"<!--END 循环内容-->";
						$("ul.cbp_tmtimeline").append(html);
				}
				//给按钮绑定事件
				//解绑
				$("div.history-panel").off("click");
				//再绑定
				$("div.history-panel").on("click",".btnDelet",function(event){
					//从localStorage取出id
/*					var data = localStorage.getItem("loginUserinfo");
					var userLoginInfo = JSON.parse(data);
					if(data !=null && data != "" && data.length > 0){
						var userID = userLoginInfo.userID;
					}*/
					var userID = $("span.userID").html();
					var worksID = $(this).parents("div.history-panel").children("span.worksID").html();
					var historyTime = $(this).parents("div.history-panel").children("span.historyTime").html();
					$.ajax({
						type:"Post",
						url:"HistoryServlet?method=cutoffHistoryByHistoryInfo",
						data:{
							"userID":userID,
							"worksID":worksID,
							"historyTime":historyTime
						},
						dataType:"Json",
						success:function(data){
							if(data != null && data != ""){
					                var onlyChoseAlert = simpleAlert({
					                    "content":data,
					                    "buttons":{
					                        "确定":function () {
					                            onlyChoseAlert.close();
					                            //刷新界面
					                            location.reload();
					                        }
					                    }
					                });
							}
						},
						error:function(error){
							
						}
					});
				});
			},
			error:function(error){
				
			}
		});
	}
	
	//获取指定时间
	function getTime(historyTime){
		historyTime = historyTime.replace(/-/g,"/");
		var date = new Date(historyTime);
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var hour = date.getHours();
		var min = date.getMinutes();
		if (month < 10) {
			month = "0" + month;
		}
		if (day < 10) {
			day = "0" + day;
		}
		var thatdate = year + "-" + month + "-" + day;
		if (hour < 10) {
			hour = "0" + hour;
		}
		if (min < 10) {
			min = "0" + min;
		}
		var time = hour + ":" + min ;
		var timeData = {
				"thatdate":thatdate,
				"time":time
		}
		return timeData;
	}
	//获取用户登录信息
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
});