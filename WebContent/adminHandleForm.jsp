<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminHandleForm</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<!-- VENDOR CSS -->
		<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
		<link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">
		<!-- MAIN CSS -->
		<link rel="stylesheet" href="assets/css/main.css">
		<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
		<link rel="stylesheet" href="assets/css/demo.css">
		<!-- GOOGLE FONTS -->
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
		<!-- ICONS -->
		<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
		<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
		<link rel="stylesheet" href="css/iconfontFree.css">
		
		<!-- Javascript -->
		<script src="assets/vendor/jquery/jquery.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
		<script src="assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
		<script src="assets/vendor/chartist/js/chartist.min.js"></script>
		<script src="assets/scripts/klorofil-common.js"></script>
		<script src="js/adminHandle.js"></script>
</head>
<body>
<!-- WRAPPER -->
		<div id="wrapper">
			<!-- NAVBAR -->
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="brand">
					<a href="index.html"><img src="assets/img/logo-dark3.png" alt="Klorofil Logo" class="img-responsive logo"></a>
				</div>
				<div class="container-fluid">
					<div class="navbar-btn">
						<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
					</div>
					<div id="navbar-menu">
						<ul class="nav navbar-nav navbar-right">

							<li class="dropdown">
								<a href="#" class="dropdown-toggle admin" ><img src="assets/img/user.png" class="img-circle" > <span>Samuel</span> <i class=""></i></a>
<!-- 								<ul class="dropdown-menu">
									<li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
									<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
									<li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
									<li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
								</ul> -->
							</li>
							<!-- <li>
								<a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
							</li> -->
						</ul>
					</div>
				</div>
			</nav>
			<!-- END NAVBAR -->
			<!-- LEFT SIDEBAR -->
			<div id="sidebar-nav" class="sidebar">
				<div class="sidebar-scroll">
					<nav>
						<ul class="nav">
							<li><a href="adminHandleForm.jsp" class="active"><i class="lnr lnr-home"></i><span>管理员首页</span></a></li>
							<li><a href="adminAddForm.html" class=""><i class="lnr lnr-code"></i> <span>添加管理员</span></a></li>
							<li><a href="creatorApplicationReview.html" class=""><i class="lnr lnr-chart-bars"></i> <span>审核创作者申请</span></a></li>
							<li><a href="newWorksReviewForm.jsp" class=""><i class="lnr lnr-cog"></i> <span>审核新作品</span></a></li>
							<li><a href="worksReportReviewForm.jsp" class=""><i class="lnr lnr-alarm"></i> <span>审核被举报作品</span></a></li>
							<li><a href="commentReviewForm.html" class=""><i class="lnr lnr-alarm"></i> <span>审核被举报评论</span></a></li>
							<li><a href="adminAnnouncementForm.jsp" class=""><i class="lnr lnr-dice"></i> <span></span>管理员查看公告</a></li>
							<li><a href="publishAnnouncementForm.jsp" class=""><i class="lnr lnr-text-format"></i> <span>发布公告</span></a></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- END LEFT SIDEBAR -->
			<!-- MAIN -->
			<div class="main">
				<!-- MAIN CONTENT -->
				<div class="main-content">
					<div class="container-fluid">
						<!-- OVERVIEW -->
						<div class="panel panel-headline">
							<div class="panel-heading">
								<h3 class="panel-title">数据面板</h3>
								<!-- <p class="panel-subtitle"></p> -->
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-3">
										<div class="metric">
											<span class="icon"><i class="lnr lnr-users"></i></span>
											<p>
												<span class="number usernum">0</span>
												<span class="title">用户总数</span>
											</p>
										</div>
									</div>
									<div class="col-md-3">
										<div class="metric">
											<span class="icon"><i class="lnr lnr-user"></i></span>
											<p>
												<span class="number creatornum">0</span>
												<span class="title">创作者总数</span>
											</p>
										</div>
									</div>
									<div class="col-md-3">
										<div class="metric">
											<span class="icon"><i class="lnr lnr-picture"></i></span>
											<p>
												<span class="number worksnum">0</span>
												<span class="title">作品总数</span>
											</p>
										</div>
									</div>
									<div class="col-md-3">
										<!-- <div class="metric">
											<span class="icon"><i class="fa fa-bar-chart"></i></span>
											<p>
												<span class="number">35%</span>
												<span class="title">Conversions</span>
											</p>
										</div> -->
									</div>
								</div>
								<div class="panel-heading">
									<h3 class="panel-title">上个月作品上传量</h3>
									<p class="panel-subtitle"></p>
								</div>
								<div class="row">
									<div class="col-md-9">
										<div id="headline-chart" class="ct-chart"></div>
									</div>
									<div class="col-md-3">
										<div class="weekly-summary text-right">
											<!-- <span class="number">2,315</span> <span class="percentage"><i class="fa fa-caret-up text-success"></i> 12%</span>
											<span class="info-label">Total Sales</span> -->
										</div>
										<div class="weekly-summary text-right">
											<!-- <span class="number">$5,758</span> <span class="percentage"><i class="fa fa-caret-up text-success"></i> 23%</span>
											<span class="info-label">Monthly Income</span> -->
										</div>
										<div class="weekly-summary text-right">
											<!-- <span class="number">$65,938</span> <span class="percentage"><i class="fa fa-caret-down text-danger"></i> 8%</span>
											<span class="info-label">Total Income</span> -->
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- END OVERVIEW -->
		                <div class="copyrights"> <a href="http://www.cssmoban.com/" ></a></div>
						<div class="row">
							<div class="col-md-6">
								<!-- MULTI CHARTS -->
								<div class="panel">
									<div class="panel-heading">
										<h3 class="panel-title">上月用户上传量折线图</h3>
										<div class="right">
											<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
											<button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
										</div>
									</div>
									<div class="panel-body">
										<div id="visits-trends-chart" class="ct-chart"></div>
									</div>
								</div>
								<!-- END MULTI CHARTS -->
							</div>
						</div>
					</div>
				</div>
				<!-- END MAIN CONTENT -->
			</div>
			<!-- END MAIN -->
			<div class="clearfix"></div>
			<footer>
				<div class="container-fluid">
					<!-- <p class="copyright">&copy; 2017 <a href="#" target="_blank">Theme I Need</a>. All Rights Reserved. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p> -->
				</div>
			</footer>
		</div>
		<!-- END WRAPPER -->
</body>
</html>