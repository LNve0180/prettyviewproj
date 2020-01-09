<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>worksReviewDetailsForm</title>
		<!-- VENDOR CSS -->
		<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
		<link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">
		<!-- MAIN CSS -->
		<link rel="stylesheet" href="assets/css/main.css">

		<!-- ICONS -->
		<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
		<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
		<!--Magnify-->
		<link rel="stylesheet" href="assets/css/jquery.magnify.css"/>
		<link rel="stylesheet" href="css/icheckStyle.css">
		<!-- ICHECK CSS -->
		<link rel="stylesheet" href="assets/css/icheck/minimal/minimal.css">
		
		<script src="assets/vendor/jquery/jquery.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
		<script src="assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
		<script src="assets/vendor/chartist/js/chartist.min.js"></script>
		<script src="assets/scripts/klorofil-common.js"></script>
		<script src="assets/vendor/jquery-magnify/jquery.magnify.js" type="text/javascript"></script>
		<script src="assets/vendor/icheck/icheck.min.js"></script>
		<script src="js/worksReviewDetails.js" type="text/javascript"></script>

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
							<li><a href="adminHandleForm.jsp" class=""><i class="lnr lnr-home"></i><span>管理员首页</span></a></li>
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
								<label>举报详情</label>
							</div>
							<div class="panel-body">
								<!-- 信息面板 -->
								<div class="col-md-6" >
									<div class="tWorksID" style="height:35px;">
										<label>作品ID：</label>
										<label class="lblWorksID"></label>
									</div>
									<div class="tWorksName"style="height:35px;">
										<label>作品名：</label>
										<label class="lblWorksName"></label>
									</div>
									<div class="tWorksUpdate"style="height:35px;">
										<label>上传时间：</label>
										<label class="lblWorksUpdate"></label>
									</div>
									<div class="tWorksIntroduction" style="height:100px;">
										<label>作品介绍：</label>
										<label class="lblWorksIntroduction"></label>
									</div>
									<div class="tAuthorID" style="height:35px;">
										<label>作者ID：</label>
										<label class="lblAuthorID"></label>
									</div>
									<div class="tAuthorName" style="height:35px;">
										<label>作者名：</label>
										<label class="lblAuthorName"></label>
									</div>
									<div class="tCollectionNum" style="height:35px;">
										<label>收藏数：</label>
										<label class="lblCollectionNum"></label>
									</div>
									<div class="tLikeNum" style="height:35px;">
										<label>点赞数：</label>
										<label class="lblLikeNum"></label>
									</div>
									<div class="tCommentNum" style="height:35px;">
										<label>评论数：</label>
										<label class="lblCommentNum"></label>
									</div>
								</div>
								<!-- 图片面板 -->
								<div class="img-box col-md-5">
									<label>作品展示：</label>
									<div class="img-area"></div>
									<!-- 
									<img src="assets/img/Snipaste_2019-03-28_12-09-48.png" data-magnify="gallery" data-src="assets/img/Snipaste_2019-03-28_12-09-48.png" src="small-1.jpg"class="worksShow img-responsive center-block"/>
									 -->
								</div>
							</div>
							<div class="col-md-10">
								
							</div>
							<div class="panel-body">
								<button class="btnPass btn btn-info" style="float: right; margin-right: 140px;">通过</button>
								<button class="btnNotPass btn btn-danger" style="float: right; margin-right: 100px;">拒绝</button>
							</div>
						</div>
						<!-- END OVERVIEW -->
						
						<!--OVERVIEW-->
						<div class="panel panel-headline">
							<div class="panel-heading">
								<label class="title">举报详情共<span class="reportNum">0</span>条</label>
							</div>
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<!--<th>举报ID</th> -->
											<th>举报者ID</th>
											<th>举报原因</th>
											<th>举报时间</th>
										</tr>
									</thead>
									<tbody>
										
									</tbody>
								</table>
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
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">请选择拒绝理由</h4>
					</div>
					<div class="modal-body">
						<div class="panel-body">
							<div class="reason-box">
								<div class="reason-title">
									<label>违反法律违规</label>
								</div>
								<div class="reasonCheck">
									<div class="btncheck">
										<label class="checkbox-inline">
										 	<input class="icheck "type="checkbox" value="违法违规"> 违法违规
										</label>
									</div>
									<div class="btncheck">
										 <label class=" checkbox-inline">
										  	<input class="icheck " type="checkbox" value="色情"> 色情
										</label>
									</div>
									<div class="btncheck">
										 <label class=" checkbox-inline">
										 	<input class="icheck "type="checkbox" value="低俗"> 低俗							 
										</label>
									</div>
								</div>
								<div class="reason-title">
									<label>侵犯个人权益</label>
								</div>
								<div class="reasonCheck">
									<div class="btncheck">
										<label class="checkbox-inline">
										 	<input class="icheck "type="checkbox" value="侵犯隐私"> 侵犯隐私
										</label>
									</div>
									<div class="btncheck">
										 <label class=" checkbox-inline">
										  		<input class="icheck " type="checkbox" value="侵权"> 侵权
										</label>
									</div>
								</div>
								<div class="reason-title">
									<label>有害社区环境</label>
								</div>
								<div class="reasonCheck">
									<div class="btncheck">
										<label class="checkbox-inline">
										 		<input class="icheck "type="checkbox" value="青少年不良信息"> 青少年不良信息
										</label>
									</div>
									<div class="btncheck">
										 <label class="checkbox-inline">
										  		<input class="icheck " type="checkbox" value="广告"> 广告
										</label>
									</div>
								</div>
							</div>
							
						</div>
						<div class="panel-body">
							<div class="reason-title">
								<label>其他</label>
							</div>
							<div class="other-reason">
								<textarea class="reasonText form-control" rows="3"></textarea>
							</div>
						</div>
						<div class="showMsg">
							
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btnCancle btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btnOk btn btn-primary">确定</button>
							
					</div>
				</div>
			</div>
		</div>
		<!-- END MODAL -->
</body>
</html>