$(function(){
	//localStorage
	onloadUserInfo();
	//身份证正面
	$("div.front-img").click(function(){
		$("#uploadimg-face").trigger("click");
	});
	//身份证背面
	$("div.back-img").click(function(){
		$("#uploadimg-back").trigger("click");
	});
	//判断格式
	//判断名字
	$("#realNameInput").blur(function(){
		checkRealName();
	});
	//判断IDCard格式
	$("#idNum").blur(function(){
		checkIDNum();
	});
	//身份证正面点击事件
	$("#uploadimg-face").click(function(){
		checkUpLoadFace();
	});
	//身份证背面点击事件
	$("#uploadimg-back").click(function(){
		checkUpLoadBack();
	});
	//提交按钮绑定事件
	$("#submitApply").on("click",function(){
		//判断格式
		var isCheck = checkSubmit();
		if(isCheck){
			//提交表单
			$("#applyForm").ajaxSubmit({
				url: "UserServlet?method=addApplicationInfoByAppInfo",
				type: "post",
				enctype: 'multipart/form-data',
				dataType:'json',
				success: function (data){
					alert(data);
				},
				error: function (data){

				}
			});
		}else{
			alert("您输入的信息不符合格式，请重新输入！");
		}
	});
	//判断名字
	function checkRealName(){
		var result = false;
		var realName = $("#realNameInput").val();
		var reg = /^[\u4E00-\u9FA5]+$/;
		if(realName.length>0 && realName.length<=5 && realName!=null && realName!="" ){
			if(reg.test(realName)){
				result= true;
			}else{
				alert("您输入的信息不符合格式，请重新输入！");
			}
		}else{
			alert("您输入的信息不符合格式，请重新输入！");
		}
		return result;
	}
	//判断IDCard格式
	function checkIDNum(){
		var result = false;
		var idNum = $("#idNum").val();
		var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(reg.test(idNum) && idNum!=null && idNum!=""){
			return true;
		}else{
			alert("身份证号输入的信息不符合格式，请重新输入！");
		}
		return result;
	}
	//判断身份证正面图片
	function checkUpLoadFace(){
		var result = false;
		if($("#uploadimg-face").val() == "" || $("#uploadimg-face").val() == null){
		}else{
			result = true;
		}
		return result;
	}
	//判断身份证背面图片
	function checkUpLoadBack(){
		var result = false;
		if($("#uploadimg-back").val() == "" || $("#uploadimg-back").val()==null){
		}else{
			result = true;
		}
		return result;
	}
	//判断提交格式
	function checkSubmit(){
		var nameInput = $("#realNameInput").val();
		var IDInput = $("#realNameInput").val();
		var uploadFace = $("#uploadimg-face").val();
		var uploadBack = $("#uploadimg-back");
		if((nameInput != null && nameInput != "") && (IDInput != null && IDInput != "") && (uploadFace != null && uploadFace != "") && (uploadBack != null && uploadBack != "") && (uploadFace != null && uploadFace != "")){
			return true;
		}else{
			return false;
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
});