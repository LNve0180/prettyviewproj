$(function(){

	$('.menu-ul-right li ul').hide();
	
	$('.menu-ul-left li ul').hide();
			
	$('.menu-ul-right li').hover(function(){
		$(this).children('ul').show();
				
	},function(){
		$(this).children('ul').hide();
	});

	$('.menu-ul-left li').hover(function(){
		$(this).children('ul').show();
				
	},function(){
		$(this).children('ul').hide();
	});
});
