$(function(){
	$(".worksCategoryNav li").click(function(){
		selectedWorksCategory=$(this).children("a").html();
		localStorage.setItem("clickedWorkCategory",selectedWorksCategory);
		window.location.href='viewingWorksByCategoryForm.html';
	});

});
