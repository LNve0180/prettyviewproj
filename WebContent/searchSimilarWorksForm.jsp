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
		<!-- ICONS -->
		<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
		<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
		<link rel="stylesheet" href="css/iconfont.css" />
		<!--page-->
		<link rel="stylesheet" href="css/paging.css" />
		<!-- ICHECK CSS -->
		<link rel="stylesheet" href="assets/css/icheck/minimal/minimal.css">
		<link rel="stylesheet" href="css/icheckStyle.css">
		<!-- DRAP CSS -->
		<link rel="stylesheet" href="assets/css/dropify/dropify.min.css">

		<link rel="stylesheet" href="css/simpleAlert.css" />
		<link rel="stylesheet" href="css/navStyle.css" />
		<link rel="stylesheet" href="css/searchSimilarWorksStyle.css" />
		<!-- MLOADING -->
		 <link rel="stylesheet" href="css/jquery.mloading.css">
		 
		<!-- Javascript -->
		<script src="assets/vendor/jquery/jquery.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
		<script src="assets/scripts/klorofil-common.js"></script>
		<script src="assets/vendor/icheck/icheck.min.js"></script>
		<script src="assets/vendor/jquery-magnify/jquery.magnify.js" type="text/javascript"></script>
		<script src="js/jquery.mloading.js"></script>
		<script src="js/nav.js"></script>
		<script src="js/paging.js"></script>
		<script src="js/timeago_ch_CN.js"></script>
		<script src="js/simpleAlert.js"></script>
		<script src="assets/vendor/dropify/dropify.min.js"></script>
		<script  src="js/navSearchBtn.js"></script>

		<script src="js/jquery.form.js"></script>
		<script src="js/searchSimilarWorksForm.js"></script>
	</head>
	<body>
<!-- WRAPPER -->
		<div id="wrapper">
			<!-- NAVBAR -->
			<nav class="navbar navbar-yellow navbar-fixed-top">
				<div class="brand">
					<a href="handleForm.jsp"><img src="assets/img/logo-dark3.png" alt="Klorofil Logo" class="img-responsive logo"></a>
				</div>
				<div class="container-fluid">
					<div class="navbar-btn">
					</div>
					<div class="navbar-menu">
						<ul class="nav navbar-nav navbar-left">
							<li class="dropdown">
								<a href="announcementShowForm.html" class="dropdown-toggle" ><span>公告</span></a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span>发现</span></a>
								<ul class="dropdown-menu">
									<li>
										<div class="work-categorge-area">
												<ul class="breadcrumb" style="background-color: #fff;">
													<li><a href="#">动漫</a></li>
													<li><a href="#">摄影</a></li>
													<li><a href="#">服装</a></li>
													<li><a href="#">UI</a></li>
													<li><a href="#">网页</a></li>
													<li><a href="#">插画</a></li>
													<li><a href="#">空间</a></li>
													<li><a href="#">三维</a></li>
													<li><a href="#">摄影</a></li>
													<li><a href="#">其它</a></li>
												</ul>
										</div>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span>排行榜</span></a>
								<ul class="dropdown-menu">
									<li><a href="seeListOfWorksFabulousForm.html"><i class="iconfont icon-good"></i> <span>点赞排行榜</span></a></li>
									<li><a href="seeListOfWorksCommentForm.html"><i class="iconfont icon-comments"></i> <span>评论排行榜</span></a></li>
									<li><a href="seeListOfWorksCollectForm.html"><i class="iconfont icon-favorite"></i> <span>收藏排行榜</span></a></li>
								</ul>
							</li>
							<li class="li-search">
								<form name="searchForm" class="am-form-inline " role="form"
									action="" method="post">
									<div class="am-u-lg-6 am-fr">
										<div class="am-input-group">
											<input id="searchContent" name="searchcontent" type="text" class="am-form-field " />
												<span class="am-input-group-btn"> 
													<input id="worksSearch" class="searchWorks btn btn-primary btnStyle" type="button" value="作品查询"></input>
													<input id="searchUser" class="searchUser btn btn-primary btnStyle" type="button" value="作者查询"></input>
													<input id="searchSimilar" class="searchSimilar btn btn-primary btnStyle" type="button" value="识图搜索"></input>
												</span>
										</div>
									</div>
								</form>
							</li>
						</ul>
					</div>
					
					<div id="navbar-menu">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle"
									 alt="Avatar"> <span id="nav-userName">Samuel</span>
									 <span class="userID" style="display: none;"></span>
									 <i class="icon-submenu lnr lnr-chevron-down"></i></a>
								<ul class="dropdown-menu">
									<li><a href="alterUserInfoForm.html"><i class="lnr lnr-user"></i> <span>个人信息</span></a></li>
									<li><a href="myWorksInfoForm.jsp" class="myWorks" style="display: none;"><i class="lnr lnr-envelope"></i> <span>我的作品</span></a></li>
									<li><a href="applyCreatorForm.html" class="applyCreator" style="display: none;"><i class="lnr lnr-cog"></i> <span>创作者申请</span></a></li>
									<li><a href="alterUserPasswordForm.html"><i class="lnr lnr-cog"></i> <span>修改密码</span></a></li>
									<li><a href="alterUserHeadPhotoForm.html"><i class="lnr lnr-exit"></i> <span>修改头像</span></a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span>消息</span></a>
								<ul class="dropdown-menu">
									<li><a href="personalMessageForm.html"><i class="lnr lnr-user"></i> <span>我的私信</span></a></li>
									<li><a href="noticeForm.html"><i class="lnr lnr-envelope"></i> <span>消息</span></a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span>关注</span></a>
								<ul class="dropdown-menu">
									<li><a href="userCareForm.html"><i class="lnr lnr-user"></i> <span>我的关注</span></a></li>
									<li><a href="newWorksDynamicForm.html"><i class="lnr lnr-envelope"></i> <span>关注的新作品</span></a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="collectDisplayForm.html" class="dropdown-toggle"><span>我的收藏</span></a>
							</li>
							<li class="dropdown">
								<a href="queryHistoryForm.jsp" class="dropdown-toggle"><span>历史记录</span></a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- END NAVBAR -->
		</div>
		<!-- END WRAPPER-->
		<div class="mian-body">
			<div class="drap-area" style="margin-top: 80px;">
				<form id="searchform" accept-charset="UTF-8" enctype="multipart/form-data">
					<input type="file" id="uploadAddress" class="dropify" name="uploadAddress" data-height="400" />
				</form>
			</div>
			<div class="center-body">
				<div class="search-title panel-title">
					<p class="p-title">
						为您找到的相似图片&nbsp;&nbsp;共<span class="searchNum">0</span>个
					</p>
				</div>
				<div class="works-show-area clearfix">
					<!-- 作品显示区域-->
					
					<!-- 查询为空的时候显示-->
					<div class="search-null" style="display: block;">
						<div class="show-msg-box" style="height: 250px;width: 300px;margin: 0 auto;">
							<div class="null-img-box" style="width: 300px; height: 200px;">
								<img src="images/nullPagew.png" style="width: 100%;height: 100%;" />
							</div>
							<span class="null-tip" style="width: 300px;height: 50px;">
								<p>没有查询到符合的内容请将图片拖入上方查询区域开始遨游创意海洋吧ヽ(✿ﾟ▽ﾟ)ノ</p>
							</span>
						</div>
					</div>
					<!-- END 查询为空的时候显示-->
				</div>
			</div>
			<!-- 装饰 -->
				<div class="" style="height: 200px;width: 1150px;margin: 0 auto; padding-right: 20px;margin-top: 20px; margin-bottom: 10px;">
					<img src="images/guanggao1.jpg" style="width: 100%;height: 100%;" />
				</div>
			<!-- END 装饰>
			<!-- FOOTER -->
			<div class="footer">
				<div class="footer-wrapper">
					<div class="footer-wrapper-top">
						<div class="footer-msg" style="margin: 0 auto;height: 20px;width: 1130px;">
							此项目由 <a href="#" title="平面设计小组" target="_blank" class="">平面设计小组</a>提供技术支持
							此站仅提供学习使用，无任何商业用途。
							联系QQ群:865735297平面设计攻坚队
						</div>
					</div>
					<div class="footer-wrapper-bottom">

					</div>
				</div>
			</div>
			<!--END FOOTER -->
		</div>


	</body>
</html>