<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login success</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>

<div class="container" style="margin-top: 200px;margin-left: 400px;">
	<a href="goIndex">回到首页</a>
	本站访问次数:${applicationScope.counter}<br/>
	${loginuser.username },您已经登录了!<br/>
	${requestScope.tip }
	
	<button type="button" >兴趣爱好
   </button>
   <div id="show"></div>
	 
   </div>
   
<script>
$("button").click(function(){

	$("#show").hide();
	// 指定向JSONExample发送请求，将id为form1的表单所包含的表单控件转换为请求参数
	$.get("userHobby" , 
	// 指定回调函数
	function(data , statusText){
		$("#show") .height(80)
		.width(240)
		.css("border" , "1px solid black")
		.css("border-radius" , "15px")
		.css("background-color" , "#efef99")
		.css("color" , "#ff0000")
		.css("padding" , "20px") 
		.empty(); 
	// 遍历JavaScript对象的各属性
	for(var propName in data){
		$("#show").append(propName + "-->"+ data[propName] + "<br />");
	}
	$("#show").show(600);
	},
	// 指定服务器响应为JSON数据
	"json");

	} );
	
</script>
</body>
</html>