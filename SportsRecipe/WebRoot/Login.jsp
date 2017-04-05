<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String root=request.getContextPath();%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>登录页面</title>
<link href="style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords"
	content="Signer Register Form Responsive,Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

</head>
<body>
<h1>登录页面</h1>
<div class="signup">
	<div class="signup-main">
		<form action="login.action" method="post">
		    <h2 style="color:white">用户名</h2>
		    <br/>
			<input type="text" name="username"  id="txtUserName" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'UserName';}"/>
			<h2 style="color:white">密码</h2>
			<br/>
			<input type="password" name="password" class="phone" id="txtPassword" />
			<div class="send-button">
				<button id="login" type="submit" style="font-size: 15px;padding: 10px 20px;background-color:#97CBFF">登录</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>
