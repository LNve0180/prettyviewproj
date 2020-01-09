$(function() {
	var adminInfo;
	var labelsData = [];//表格X轴
	var seriesData;//表格数据
	//数据加载初始化
	onLoadDate();
	
	//数量数据加载初始化
	onLoadNumData();
	
	//加载管理员信息
	onloadAdminInfo();
	
	//HeadlineCharts初始化
	onLoadHeadlineCharts(labelsData,seriesData);
	
	//数据加载初始化
	function onLoadDate(){
		
		$.ajax({
			type:"Post",
			url:"AdminServlet?method=queryWorksData",
			dataType:"Json",
			success:function(data){
				$("p.panel-subtitle").html("作品上传时间区间："+data.timeBegin+" - "+data.timeEnd);
				//将data内容添加到
				seriesData = data.series.split(",");
				var i;
				for(i = 1; i <= data.maxDay; i++){
					labelsData .push(i);
				}
				//创建HeadlineCharts
				onLoadHeadlineCharts(labelsData,seriesData);
				
				//创建VisitsTrendCharts
				onLoadVisitsTrendCharts(labelsData,seriesData);
			},
			error:function(error){
				alert("表格:数据初始化失败");
			}
		});

	}
	
	//数量数据加载初始化
	function onLoadNumData(){
		$.ajax({
			type:"Post",
			url:"AdminServlet?method=queryCountData",
			dataType:"Json",
			success:function(data){
				$("span.usernum").html(data.userNum);
				$("span.creatornum").html(data.creatorNum);
				$("span.worksnum").html(data.worksNum);
			},
			error:function(error){
				alert("数据初始化失败");
			}
		});
	}
	
	//创建HeadlineCharts
	function onLoadHeadlineCharts(labelsData,seriesData){
		var data, options;
		// headline charts
		data = {
			labels: labelsData,
			series: [
				seriesData,
			]
		};

		options = {
			height: 300,
			showArea: true,
			showLine: false,
			showPoint: false,
			fullWidth: true,
			axisX: {
				showGrid: false
			},
			lineSmooth: false,
		};

		new Chartist.Line('#headline-chart', data, options);
	}
	
	//创建VisitsTrendCharts
	function onLoadVisitsTrendCharts(labelsData,seriesData){

		// visits trend charts
		data = {
			labels: labelsData,
			series: [{
				name: 'series-real',
				data: seriesData,
			}]
		};
	
		options = {
			fullWidth: true,
			lineSmooth: false,
			height: "270px",
			low: 0,
			high: 'auto',
			series: {
				'series-projection': {
					showArea: true,
					showPoint: false,
					showLine: false
				},
			},
			axisX: {
				showGrid: false,
	
			},
			axisY: {
				showGrid: false,
				onlyInteger: true,
				offset: 0,
			},
			chartPadding: {
				left: 20,
				right: 20
			}
		};
	
		new Chartist.Line('#visits-trends-chart', data, options);
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