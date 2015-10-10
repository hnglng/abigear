requirejs.config({
    baseUrl: '../../../js',
    paths: {
        // the left side is the module ID,
        // the right side is the path to
        // the jQuery file, relative to baseUrl.
        // Also, the path should NOT include
        // the '.js' file extension. This example
        // is using jQuery 1.9.0 located at
        // js/lib/jquery-1.9.0.js, relative to
        // the HTML page.
        jquery: 'lib/jquery-1.11.3.min',
        bootstrap: "lib/bootstrap-3.3.5.min",
        fileUpload: 'abigear/module/file-upload'
    }, 
    shim: {
    	'jquery.scroll': {
    		deps: ['jquery'],
    		exports: 'jQuery.fn.scroll'
    	}
	}
});

require(['jquery', 'bootstrap'], function ($, bootstrap){
	
	alert("personal-center.js");

});