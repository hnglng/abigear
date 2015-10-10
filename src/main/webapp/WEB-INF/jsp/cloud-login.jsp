<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<h1>cloud-login.jsp</h1>
	<div id="login_container" align="center"></div>
</body>
</html>
<!--
<script src="../../js/lib/requirejs-2.1.20.js" data-main="../../js/abigear/page/cloud-login" defer async="true" ></script>
-->


<script src="http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>

<script>

var obj = new WxLogin({

                              id:"login_container", 

                              appid: "wx6908534db14f5bb5", 

                              redirect_uri: encodeURIComponent("http://www.baidu.com"), 

                              scope: "snsapi_login",

                              state: "123",

                              style: "",

                              href: ""

                            });

</script>

