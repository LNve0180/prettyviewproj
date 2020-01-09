$(document).ready(function(){
	
	var $realName = $("#realNameInput");
	
	var  $IDNum = $("#idNum");
	
	var $uploadimgFace = $("#uploadimg-face");
	
	var $uploadimgBack = $("#uploadimg-back");
	
	
	$realName.blur(function(){
		
		checkRealName();

	});
	
	$IDNum.blur(function(){
		
		checkIDNum();

	});
	
	
	$uploadimgFace.onclick(function(){
		
		checkUpLoadFace();
		
	});
	
	$uploadimgBack.onclick(function(){
		
		checkUpLoadBack();
		
	});
	
	
	
	function checkRealName(){
		
		var result = false;
		
		var realName = $realName.val();
		
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
	
	
	function checkIDNum(){
		
		var result = false;
		
		var idNum = $IDNum.val();
		
		var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		
		if(reg.test(idNum) && idNum!=null && idNum!=""){
			
			return true;
			
			
		}else{
			
			alert("身份证号输入的信息不符合格式，请重新输入！");
			
		}
		
		return result;
		
		
	}
	
	
	
	function checkUpLoadFace(){
		
		var result = false;
		
		if($uploadimgFace.val() == "" || $uploadimgFace.val()==null){
			
			alert("请选择上传文件！");
			
		}else{
			
			result = true;
		}
		return result;
		
	}
	
	
	function checkUpLoadFace(){
		
		var result = false;
		
		if($uploadimgBack.val() == "" || $uploadimgBack.val()==null){
			
			alert("请选择上传文件！");
			
		}else{
			
			result = true;
		}
		return result;
		
	}
	
	
	
	$("#applyForm").submit(function(e){
		
		var nameInput = checkRealName();
		
		var IDInput = checkIDNum();
		
		var uploadFace = checkUpLoadFace();
		
		var uploadBack = checkUpLoadBack();
		
		
		if(nameInput && IDInput && uploadFace && uploadBack && uploadFace){
			
		}else{
			
			
			e.preventDefault();
		}
		
		
	});
	
});


