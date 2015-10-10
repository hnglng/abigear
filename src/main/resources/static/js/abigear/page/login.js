requirejs.config({
	baseUrl : '../../../js',
	paths : {
		// the left side is the module ID,
		// the right side is the path to
		// the jQuery file, relative to baseUrl.
		// Also, the path should NOT include
		// the '.js' file extension. This example
		// is using jQuery 1.9.0 located at
		// js/lib/jquery-1.9.0.js, relative to
		// the HTML page.
		jquery : 'lib/jquery-1.11.3.min',
		bootstrap : "lib/bootstrap-3.3.5.min",
		abigear : 'abigear/abigear'
	},
	shim : {
		'jquery.scroll' : {
			deps : [ 'jquery' ],
			exports : 'jQuery.fn.scroll'
		}
	}
});

require([ 'abigear', 'jquery' ], function(abigear, $) {

	'use strict';
	var login = {};

	login.Controller = {
		echo : function(message) {
			alert(message);
		}
	}

	login.View = {
		show : function(message) {
			alert(message);
		}
	}

	abigear.Login = login;
	return login;

});