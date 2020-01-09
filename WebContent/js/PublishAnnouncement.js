$(function(){
	var data = localStorage.getItem("loginAdminInfo");
	var adminLoginInfo = JSON.parse(data);
	//写入导航头
	$("img.img-circle").attr("src",adminLoginInfo.adminHeadPhoto);
	$(".admin").children("span").html(adminLoginInfo.adminName);
	var adminID = adminLoginInfo.adminID;//管理员id;
	
	
	$("#themeName").blur(function(){
		checkTheme();
	});
	
	$("textarea.form-control").blur(function(){
		checkContent();
	});
	//清除按钮
	$("button.btn-success").click(function(){
		clearMsg();
	});
	//发布按钮
	$("button.btn-primary").click(function(){
		saveMsg();
	});
	//重置按钮
	$("button.btn-danger").click(function(){
		resetMsg();
	});
	
	//检查主题
	function checkTheme(){
		
		var theme = $("#themeName").val();
		if(theme==null || theme==""){
			//提示错误信息
			$("#themeName").parent("div").removeClass("has-success");
			$("#themeName").parent("div").addClass("has-error");
			$("#showThemeMsg").css("color","red");
			$("#showThemeMsg").html("please input the theme.");
			return false;
		}else{
			$("#showThemeMsg").html("");
			$("#themeName").parent("div").removeClass("has-error");
			$("#themeName").parent("div").addClass("has-success");
			
			return true;
		}
		
		return false;
			
	}
	//检查输入内容
	function checkContent(){
		var content = $("textarea.form-control").val();
		if(content==null || content==""){
			$("textarea.form-control").parent("div").removeClass("has-success");
			$("textarea.form-control").parent("div").addClass("has-error");
			$("#showContentMsg").css("color","red");
			$("#showContentMsg").html("please input the content.");
			return false;
		}else{
			$("#showContentMsg").html("");
			$("textarea.form-control").parent("div").removeClass("has-error");
			$("textarea.form-control").parent("div").addClass("has-success");
			return true;
		}
		return false;
	}
	
	//检查类别
	function checkType(){
		var type = $("select.form-control option:selected").val();
		if(type!=null && type!=""){
			return true;
		}else{
			return false
		}
	}
	
	//清除
	function clearMsg(){
		$("#themeName").val("");
		$("textarea.form-control").val("");
		$("#showThemeMsg").html("");
		$("#showContentMsg").html("");
		$("#themeName").parent("div").removeClass();
		$("textarea.form-control").parent("div").removeClass();

	}
	
	//重置
	function resetMsg(){
		$("button.btn-primary").html("发布");
		$("button.btn-primary").prop('disabled', false);
		$("button.btn-success").prop('disabled', false);
		clearMsg();
	}
	
	//save
	function saveMsg(){
		var check_theme = checkTheme();
		var check_content = checkContent();
		var check_type = checkType();
		var theme = $("#themeName").val();
		var type = $("select.form-control option:selected").val();
		var content = $("textarea.form-control").val();
		if(check_theme==true && check_content==true){
			//ajax 调用
			$.ajax({
				type:"Post",
				url:"AnnouncementServlet?method=addAnnouncementByAnnouncementInfo",
				data:{
					//adminID
					"adminID":adminID,
					"announcementTheme":theme,
					"announcementType":type,
					"announcementContent":content
				},
				success:function(data){
					if(data=="true"){
						alert("存入成功。");
						//按钮变成已发布
						$("button.btn-primary").html("已发布");
						//按钮发布按钮不可点击
						$("button.btn-primary").prop('disabled', true);
						//清除按钮不可点击
						$("button.btn-success").prop('disabled', true);
					}else{
						alert("存入失败，请重试。")
					}
				},
				error:function(error){
					alert("存入失败，请重试。");
				}
			});
		}else{
			alert("请输入正确的主题和内容。");
		}
	}
	
});