<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chinese Mobile</title>
<link type="text/css" href="../../../css/styles.css" rel="stylesheet">
<script src="../../../script/jquery 1.11.3.js" type="text/javascript"></script>
<script src="../../../script/script.js" type="text/javascript"></script>
</head>

<body>
 <!-- header -->
<header class="alerm_header alerm_header_edit">
	<article class="alerm_content">
    	<div class="alerm_text">
        <a href="#">闹钟</a>
        <a href="/editalarm.html" class="edit_alerm">编辑</a>
        <a href="/addalarm.html" class="add_alerm">add</a>
        </div>
    </article>
</header>
<!-- /header -->
<!-- section -->
<section class="section_edit_alerm">
	<article>
		<div class="edit_list set_alarm">
        	<ul>
	        	<c:forEach var="device" items="${allAlarm }">
	        		<c:forEach var="alarm" items="${device }" varStatus="alarmNum">
				        <li>
				        	<a href="#">
				        		<span class="edit_one">闹钟:</span>
				        		<span class="edit_time">${alarm.alarmcfg.call_at }</span>
				        		<span class="edit_three">上午</span>
				        	</a>
				            <div class="on_off on_off_${alarmNum.count }">
				            	<div class="on on_${alarmNum.count } off_active">
				            		
				                </div>
				            </div>
			            </li>
	        		</c:forEach>
	        	</c:forEach>
            </ul>
        </div>
	</article>
</section>
<!-- /section -->
<!-- footer -->
<footer>
	<article>
    	<ul>
		<li><a href="#"><img src="../../../images/Home.png" alt="home">首页</a></li>
        <li><a href="#"><img src="../../../images/Profile.png" alt="home">我的</a></li>
        </ul>
    </article>
</footer>
    <!-- /footer -->
</body>
</html>