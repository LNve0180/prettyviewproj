<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<link rel="stylesheet" href="css/login.css" />
		<script src="assets/vendor/jquery/jquery.min.js"></script>
		<script src="js/login.js"></script>
</head>
<body>
<div class="login_main_body">
			<div class="login_nav">
				<div class="login_logo"><img src="assets/img/logo-dark3.png" /></div>
				<div class="login_nav_text"><a href="userRegiestForm.html">新用户注册</a>  | <a href="#">客户端收发</a> | <a href="#">English</a> | <a href="#">繁体版</a></div>
			</div>
			<div id="user_login_form" class="login_form">
				<div class="login_title">
				<h2>用户登录</h2>
				</div>
				<div class="login_content">
					<input id="userID" class="input_text" type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" placeholder="请输入用户账号" />
					<input id="userPassword" class="input_text" type="password" onKeyUp="value=value.replace(/[\W]/g,'')" placeholder="请输入用户密码">
					<input id="userLoginButton" class="input_button" type="button" value="登录" />
				</div>
				<div class="login_other">
					<a href="userRegiestForm.html">用户注册</a>
				</div>
			</div>
		</div>
		<div class="login_footer">
			<a href="#">关于XX</a> | <a href="#">用户协议</a> | <a href="#">帮助中心</a> | <a href="#">用户手册</a><br /> 
			©1998 - 2019 Tencent Inc. All Rights Reserved
		</div>
</body>
</html>