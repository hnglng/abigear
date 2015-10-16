$(document).ready(function(e) {
/*Home*/
			
				
/*Home*/
				
/*NoAlarm*/
	var hei = $(window).height();
	$(".no_alerm_text article").css("height" , hei);
/*NoAlarm*/
/*setAlarm*/
	
	
	$(".on_off_1").click(function(e){
		if ($(".on_1").hasClass('active')) {
		$(".on_1").removeClass('active'); 
		$(".on_1").animate({left:"-2px"}, 300);
		
		$(".on_off_1").css("background","#f2f4f5");
		e.preventDefault();
		}
		else {
		$(".on_1").addClass('active');	
		$(".on_1").animate({left:"20px"}, 300);
		$(".on_off_1").css("background","#84d312");
		e.preventDefault();
		}
	});
	$(".on_off_2").click(function(e){
		if ($(".on_2").hasClass('active')) {
		$(".on_2").removeClass('active'); 
		$(".on_2").animate({left:"-2px"}, 300);
		$(".on_off_2").css("background","#f2f4f5");
		e.preventDefault();
		}
		else {
		$(".on_2").addClass('active');	
		$(".on_2").animate({left:"20px"}, 300);
		$(".on_off_2").css("background","#84d312");
		e.preventDefault();
		}
	});
	$(".on_off_3").click(function(e){
		if ($(".on_3").hasClass('active')) {
		$(".on_3").removeClass('active'); 
		$(".on_3").animate({left:"-2px"}, 300);
		$(".on_off_3").css("background","#f2f4f5");
		e.preventDefault();
		}
		else {
		$(".on_3").addClass('active');	
		$(".on_3").animate({left:"20px"}, 300);
		$(".on_off_3").css("background","#84d312");
		e.preventDefault();
		}
	});
/*setAlarm*/
/*AddAlarm*/	
	
	$(".on_off_add").click(function(e){
		if ($(".on_add").hasClass('active')) {
		$(".on_add").removeClass('active'); 
		$(".on_add").animate({left:"-2px"}, 300);
		$(".on_off_add").css("background","#f2f4f5");
		e.preventDefault();
		}
		else {
		$(".on_add").addClass('active');	
		$(".on_add").animate({left:"20px"}, 300);
		$(".on_off_add").css("background","#84d312");
		e.preventDefault();
		}
	});
	 setTimeout(function() {
		$(".time").trigger("click");
	 },10);
	 $(document).on('pageinit', function(event){
   $("body,html").swiperight(function() {
        $.mobile.changePage("body,html");
    });
});
/*AddAlran*/	 
				
});	