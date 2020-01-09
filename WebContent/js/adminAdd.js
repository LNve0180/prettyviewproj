$(function(){
	
	//加载管理员信息
	onloadAdminInfo();
	
	$(".adminHeadPhoto").change(function(e){
		$("#changeAdminHeadPhoto").text("更换管理员头像");
		var imgBox=e.target;
		var file=imgBox.files[0];
		var imgSrc;
		if(!/image\/\w+/.test(file.type)){
			alert("请选择图片，不要选择其他类型的文件");
			return false;
		}
		var reader=new FileReader();
		reader.readAsDataURL(file);
		reader.onload=function(){
			console.log(this.result);
			imgSrc=this.result;
			$(".adminHeadPhotoPreview img").attr("src",imgSrc);
		}
	});
	$(".adminHeadPhotoPreview img").click(function(){
		$(".adminHeadPhoto").trigger("click");
	});
	$("#changeAdminHeadPhoto").click(function(){
		$(".adminHeadPhoto").trigger("click");
	});
	$("#adminAddButton").click(function(){
		var adminID=$("#adminID").val();
		var isAdminExist=false;
		$.ajax({
			type : "post",
			url : "AdminServlet?method=searchAdminIsExist",
			async : true,
			dataType : "json",
			data : {
				"adminID" : adminID
			},
			success : function(data) {
				if (data == "true") {
					alert("输入信息已存在，请重新输入");
					isAdminExist=true;
				} else{
					$("#form1").ajaxSubmit({
					      url: "AdminServlet?method=addAdminInfoByAdminInfo",
					      type: "post",
					      async : false,
					      enctype: 'multipart/form-data',
					      // iframe: true,
					      dataType:'json',
					      success: function (data)
					      {
					        //var msg = eval(data);
					        if(data=="true"){
					        	alert("添加管理员成功");
					        	location.reload();
					        }else if(data=="false"){
					        	alert("添加管理员失败");
					        }
					        
					      },
					      error: function (data)
					      {
					        //var msg = eval(data);
					        alert("出错");//msg.errCode
					      }
					    });
				}

			}

		});
		
		//return false;
	});
	
	//加载管理员信息
	function onloadAdminInfo(){
		var data = localStorage.getItem("loginAdminInfo");
		var adminLoginInfo = JSON.parse(data);
		//写入导航头
		$("img.img-circle").attr("src",adminLoginInfo.adminHeadPhoto);
		$(".admin").children("span").html(adminLoginInfo.adminName);
	}
})
