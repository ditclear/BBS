<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<s:i18n name="info">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_common.css" type="text/css"></link><link
	rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_editor.css" type="text/css"></link><link
	rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_viewthread.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery.js"></script>
	<title>BBS论坛</title>
	<script>
	function toggle_collapse(oDiv){
	  var vDiv = document.getElementById(oDiv);
      vDiv.style.display = (vDiv.style.display == 'none')?'block':'none';
    }	
</script>
</head>
<body>
	<DIV class="wrap">
		<DIV id="header">
			<div id="logo">
				<img src="<%=request.getContextPath()%>/image/logo.png" >
				<a href="download.action?filename=<s:property value="#session.loginuser.images"/>">
				<img height="70" width="200" src="<%=request.getContextPath()%>/<s:property value="'upload/'+#session.loginuser.images"/>"/></a>
				<button type="button" >兴趣爱好</button>
				<div id="show"></div>
			</div>
		</DIV>
	</DIV>
	<DIV id="menu">
		<SPAN class="avataonline"> 
		<s:if test="#session.loginuser != null">
			${sessionScope.tip }
			<a href="<%=request.getContextPath()%>/modifyUser.jsp"><s:text name="modify"/></a> 
			<a href="<%=request.getContextPath()%>/logout.action"> 注销</a>
			<s:if test="2==#session.loginuser.popedom|| 1==#session.loginuser.popedom">
					<a href="<%=request.getContextPath()%>/admin/index.jsp"><s:text name="setting"/></a>
			</s:if><s:property value="extra"/>
		</s:if> 
		<s:else>
			<A href="login.jsp"><s:text name="login"/></A>
		</s:else>
		
	    </SPAN>
	</DIV>
	<DIV class="ad_text" id="ad_text"></DIV>
	<s:iterator value="map" var="oneItem">
		<!--栏目-->
		<div class="mainbox forumlist">
			<span class="headactions"> <img src="<%=request.getContextPath()%>/image/collapsed_no.gif"
				alt="收起/展开" name="category_1_img" width="8" height="9"
				id="category_1_img" title="收起/展开"
				onclick="toggle_collapse('category_1');" /> </span>
			<h3 align="left">
				<s:property value="#attr.oneItem.key.itemname" />
			</h3>
			<!--栏目标题-->
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="10%">&nbsp;</td>
					<td width="79%"><s:property
							value="#attr.oneItem.key.itemdescription" />
					</td>
					<!--栏目-->
					<!--栏目介绍-->
					<td width="11%"><span class="moderators"><s:text name="itemmanager"/>: <s:property
								value="#attr.oneItem.key.username" />
					</span>
					</td>
					<!--栏目版主-->
				</tr>
			</table>

			<table id="category_1" summary="category1" style="" cellpadding="0"
				cellspacing="0">
				<thead class="category">
					<tr>
						<th><s:text name="subitem"/></th>
						<td class="nums"><s:text name="count"/></td>
					</tr>
				</thead>

				<s:iterator value="#attr.oneItem.value" var="ontItems">
					<!--子栏目-->
					<tbody id="forum38">
						<tr>
							<th class="new">
								<h2>
									<a
										href="showAllTopic.action?subItemID=
										<s:property value='#attr.ontItems.subitemid'/>
										&currentPage=1&subItemName=<s:property value='#ontItems.subitemname' />">
										<s:property value="#attr.ontItems.subitemname" />
									</a>
								</h2>
								<!--子栏目标题-->
								<p>
									<s:property value="#attr.ontItems.itemdescription" />
								</p>
								<!--子栏目介绍-->
								<p class="moderators">
									<s:text name="manager"/>:
									<s:property value="#attr.ontItems.username" />
								</p> <!--子栏目版主--></th>
							<td class="nums"><s:property
									value="#attr.ontItems.topics.size()" />
							</td>
						</tr>
					</tbody>
				</s:iterator>
			</table>

		</div>
	</s:iterator>
	<!--栏目-->
	</div>
	<s:debug></s:debug>
	<div id="footer">
  <div align="center">博爱论坛系统 &copy; 2015 重庆文理学院 软件工程学院李庆香 版权所有   ICP证1000001号 </div>
  <div align="center">关于我们 · 联系方式 · 意见反馈 · 帮助中心</div>
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
</s:i18n>