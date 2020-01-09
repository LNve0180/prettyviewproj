$(function(){
	
	$("#addWorksInfoButton").click(function(){
		if(!$("#worksName").val()||!$("#worksIntroduction").val()||!$("#worksCategory").val()||!$("#uploadAddress").val())
			{
			alert("格式错误，请重试");
			}
			else{
//				$.ajax({
//					type : "post",
//					url : "WorksServlet?method=addWorksInfoByWorksInfo",
//					async : true,
//					dataType : "json",
//					data : $("#form1").serialize(),
//					success : function(data) {
//						// alert(data);
//						if (data == "true") {
//							alert("添加成功");
//						} else if (data == "false") {
//							alert("添加失败");
//						}
//					}
//				});
				$("#form1").ajaxSubmit({
				      url: "WorksServlet?method=addWorksInfoByWorksInfo",
				      type: "post",
				      enctype: 'multipart/form-data',
				      // iframe: true,
				      dataType:'json',
				      success: function (data)
				      {
				        //var msg = eval(data);
				        if(data=="true"){
				        	alert("添加成功");
				        	$("#worksName").val("");
				        	$("#worksIntroduction").val("");
				        	$("#worksCategory").val("动漫");
				        	$("#uploadAddress").val("");
				        	$("#uploadAddressPreview").attr("src","images/addAdminClickButton.png");
				        }else if(data=="false"){
				        	alert("存入错误请重试");
				        }
				        
				      },
				      error: function (data)
				      {
				        //var msg = eval(data);
				        alert("出错");//msg.errCode
				      }
				    })
			}
	});
	
	$("#uploadAddress").change(function(e){
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
			$("#uploadAddressPreview").attr("src",imgSrc);
		}
	});
	$("#uploadAddressPreview").click(function(){
		$("#uploadAddress").trigger("click");
	});

	
})