<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<link rel="stylesheet" href="css/adminAnnouncementStyle.css" />
		
		<script src="assets/vendor/jquery/jquery.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
		<script src="assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
		<script src="assets/vendor/chartist/js/chartist.min.js"></script>
		<script src="assets/scripts/klorofil-common.js"></script>
		<script src="js/AdminAnnouncement.js"></script>
</head>
<body>
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
							<li><a href="adminHandleForm.jsp" class=""><i class="lnr lnr-home"></i><span>管理员首页</span></a></li>
							<li><a href="adminAddForm.html" class=""><i class="lnr lnr-code"></i> <span>添加管理员</span></a></li>
							<li><a href="creatorApplicationReview.html" class=""><i class="lnr lnr-chart-bars"></i> <span>审核创作者申请</span></a></li>
							<li><a href="newWorksReviewForm.jsp" class=""><i class="lnr lnr-cog"></i> <span>审核新作品</span></a></li>
							<li><a href="worksReportReviewForm.jsp" class=""><i class="lnr lnr-alarm"></i> <span>审核被举报作品</span></a></li>
							<li><a href="commentReviewForm.html" class=""><i class="lnr lnr-alarm"></i> <span>审核被举报评论</span></a></li>
							<li><a href="adminAnnouncementForm.jsp" class="active"><i class="lnr lnr-dice"></i> <span></span>管理员查看公告</a></li>
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
								<label >公告面板</label>
							</div>
						</div>
						<!-- END OVERVIEW -->

				</div>
				<!-- END MAIN CONTENT -->
			</div>
			<!-- END MAIN -->
			<div class="clearfix"></div>
			<footer>
				<div class="container-fluid">
					
				</div>
			</footer>
		</div>
		<!-- END WRAPPER -->
	</body>
</body>
</html>