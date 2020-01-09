$(function(){
	$(".menu-list-default a:eq(0)").click(function(){
		window.location.href="seeListOfWorksFabulousForm.html";
	});
	$(".menu-list-default a:eq(1)").click(function(){
		window.location.href="seeListOfWorksCollectForm.html";
	});
	$(".menu-list-default a:eq(2)").click(function(){
		window.location.href="seeListOfWorksCommentForm.html";
	});
	$(".menu-list-default a:eq(3)").click(function(){
		$("body").scrollTop(0);
	});
});
