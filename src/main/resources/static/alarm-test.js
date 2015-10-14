$(document).ready(function(){  
    $("#myAlarm").click(function(){  
    	jQuery.support.cors = true; 
    	
        var url = 'http://120.25.239.73:5000/api?method=set_alarm';
    	//var data = {'alarmcfg': {'week': [1, 2, 3, 4, 5], 'blank_time': 30, 'repeat': 5, 'continue_time': 30, 'call_at': '15:05'}, 'user_id': 4, 'res_id': 2, 'dev_id': 7, 'id': 14, 'state': 1};
        
    	var data = {
                'id':14,                                 
                'user_id':4,                          
                'dev_id':7,                             
                'res_id':2,                             
                'alarmcfg':{                           
                    'call_at':'15:05',      
                    'week':[1,2,3,4,5],         
                    'repeat':5,            
                    'continue_time':30,     
                    'blank_time':30         
                },
                'state':1                         
            };  
    	
        $.ajax({  
            type : "POST",  
            async : false,    
            url : url,  
            data : data,  
            //dataType : "text", //跨域请求需要使用jsonp  
            //contentType: "application/x-www-form-urlencoded; charset=utf-8",   
            timeout:10000,   
            success:function(response){  
                console.log("success: " + response);   
            },  
            error: function(XMLHttpRequest, error, errorObj) {   
            	console.log("error: " + errorObj);  
             },
             complete: function(XHR, TS){
            	 console.log("complete: " + TS); 
             }
        });  
          
    })
});  