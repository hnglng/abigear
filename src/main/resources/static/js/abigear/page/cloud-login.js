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
        abigear: 'abigear/abigear',
        wxLogin: 'http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin'
    }, 
    shim: {
    	'jquery.scroll': {
    		deps: ['jquery'],
    		exports: 'jQuery.fn.scroll'
    	}
	}
});

require(['abigear', 'jquery', 'bootstrap', 'wxLogin'], function (abigear, $, bootstrap, wxLogin){
	
	'use strict';
	var cloudLogin = {};
	
	var obj = new WxLogin({
	    id:"login_container", 
	    appid: "wxee1fb0bc92860096",
	    scope: "snsapi_login", 
	    //redirect_uri: 'http://ectouch.v4test.com/oauth2.php',
	    redirect_uri: 'http%3a%2f%2fectouch.v4test.com%2fwechatlogin.php',
	    //redirect_uri: 'http://www.baidu.com',
	    state: "weixin",
	    style: "",
	    href: ""
	  });  
	
	
	abigear.CloudLogin = cloudLogin;
	return cloudLogin;
	

});