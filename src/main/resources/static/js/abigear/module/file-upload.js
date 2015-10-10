define([ 'jquery', 'bootstrap' ], function($, bootstrap){
	'use strict';
	
	var fileUpload = {};
	
	// private function
	function myPrivateFunction(){
		
	}
	
	// public function
	fileUpload.foo = function(){
		alert("This is file-upload.js.");
	}
	
	return fileUpload;
});