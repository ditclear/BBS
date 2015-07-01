<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>${topic.title}</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<style type="text/css">
<!--
.STYLE1 {color: #069}
-->
</style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_common.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_editor.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_viewthread.css" type="text/css"></link></HEAD>
<BODY>
<DIV class="wrap">
<DIV id="header">
			<div id="logo">
				<img src="<%=request.getContextPath()%>/image/logo.png"></img>
			</div>
		</DIV>
</DIV>
<DIV id="menu"> <SPAN class="avataonline">
	   <s:if test="#session.loginuser != null">
			${loginuser.username}欢迎你!
			<s:if test="2==#session.loginuser.popedom || 1==#session.loginuser.popedom">
				 <a href="admin/index.jsp">系统设置</a>
			</s:if>
		</s:if>
		<s:else>
			<A href="login.jsp">登录</A> 
		</s:else>
	</SPAN> 
</DIV>
<DIV id="nav" align="left"><A href="goIndex.action">BBS论坛</A> &raquo;<a href="showAllTopic.action?subItemID=${topic.subitem.subitemid}&subItemName=${topic.subitem.subitemname}">${topic.subitem.subitemname}</a>&raquo;${topic.title}
<SPAN class="replybtn"><a href="#replays"><img src="<%=request.getContextPath()%>/image/reply.gif" alt="" width="75" height="29" border=0/></a></SPAN></DIV>
<FORM name="modactions" method="post">
  <DIV class="mainbox viewthread">
    <H1>${topic.title}</H1>
<TABLE id="pid256809" cellSpacing="0" cellPadding="0" summary="pid256809">
  <TBODY>
  <TR>
    <TD class="postauthor"><P>${topic.users.username}</P>
      <P><EM>
          	<s:if test="#attr.topic.users.popedom == 1"> 管理员</s:if>
          	<s:if test="#attr.topic.users.popedom == 2">栏目版主</s:if>
          	<s:if test="#attr.topic.users.popedom == 3">子栏目版主</s:if>
          	<s:if test="#attr.topic.users.popedom == 4">普通用户</s:if>
          </EM>
      <DL class="profile">
        <DT>ID</DT>
        <DD>${topic.users.userid}</DD>
        <DT>积分</DT>
        <DD>${topic.users.integral}</DD>
       </DL> 
      </TD>
    <TD class="postcontent">
      <DIV class="postinfo">
      发表于 
      ${topic.topicdate}&nbsp;</DIV>
      <DIV class="postmessage defaultpost">
      <H2>${topic.title}</H2>
      <DIV class="t_msgfont" id="postmessage_256809">
      	${topic.content}
      </DIV>
 </DIV>
      </TD>
  </TR>
  <TR>
    <TD class="postauthor">
      <DIV class="popupmenu_popup userinfopanel" id="userinfo256809_menu" 
      style="DISPLAY: none">
      <DIV class="imicons"></DIV>
      <DL></DL>
     </DIV></TD>
    <TD class="postcontent">
      <DIV class="postactions">
      <P><STRONG title="顶部" onclick="scroll(0,0)">TOP</STRONG> </P>
      <DIV id="ad_thread1_0"></DIV></DIV></TD></TR></TBODY></TABLE></DIV>
<DIV id="ad_interthread"></DIV>

<s:iterator value="replys" var="reply">
<DIV class="mainbox viewthread">
<TABLE id="pid256812" cellSpacing="0" cellPadding="0" summary="pid256812">
  <TBODY>
  <TR>
    <TD class="postauthor"><CITE></CITE> 
      <P>${reply.users.username}</P>
      <P><EM>
      		<s:if test="#attr.reply.users.popedom == 1"> 管理员</s:if>
          	<s:if test="#attr.reply.users.popedom == 2">栏目版主</s:if>
          	<s:if test="#attr.reply.users.popedom == 3">子栏目版主</s:if>
          	<s:if test="#attr.reply.users.popedom == 4">普通用户</s:if>
         </EM></P>
      <DL class="profile">
        <DT>ID</DT>
        <DD>${reply.users.userid}</DD>
        <DT>积分</DT>
        <DD>${reply.users.integral}</DD>
       </DL> 
      </TD>
    <TD class="postcontent">
      <DIV class="postinfo">回复于${reply.replydate}</DIV>
      <DIV class="postmessage defaultpost">
      <DIV class="t_msgfont" id="postmessage_256812">${reply.content}</DIV>
      <DIV id="post_rate_div_256812"></DIV></DIV>
      </TD>
  </TR>
  <TR>
    <TD class="postauthor">
      <DIV class="popupmenu_popup userinfopanel" id="userinfo256812_menu" 
      style="DISPLAY: none">
      <DL></DL>
      <P></P></DIV></TD>
    <TD class="postcontent">
      <DIV class="postactions">
      <P><STRONG title="顶部"  onclick=scroll(0,0)>TOP</STRONG> </P>
      <DIV id=ad_thread1_1></DIV></DIV>
      </TD>
   </TR>
   </TBODY>
  </TABLE>
</DIV>
</s:iterator>
<SPAN 
class="replybtn"><a href="#replays"><IMG src="<%=request.getContextPath()%>/image/reply.gif" alt="" width="75" height="29" border=0></a></SPAN>
</FORM>
<div>
 <table width="600" border="0" align="center" cellpadding="2" cellspacing="1" bordercolor="#799AE1" class="tableBorder">
	 <tr align="right" bgcolor="#F9FCEF">
				<td height="28" colspan="8" align="center">
					<center>
						<form action="showTopic.action?subItemID=${subitemid}&subItemName=${subitemname}&topicID=${topic.topicid}" method="post" id="pageForm"
							name="pageForm">
							<%@include file="../page.jsp"%>
						</form>
					</center></td>
			</tr>
  </TABLE>
</div>
<DIV class="ad_footerbanner">
<form action="replyAdd.action" method="post" name="replys">
	<s:if test="#session.loginuser != null">
	<input type="hidden" name="userId" value="${loginuser.userid}"/></s:if>
    <input type="hidden" name="topicID" value="${topic.topicid}"/>
	<textarea cols="80" id="content" name="content" rows="10"></textarea>
	<BUTTON id="postsubmit" tabIndex="300" name="topicsubmit" type="submit" value="true">发表回复</BUTTON>
</form>  
<ckeditor:replace replace="content" basePath="ckeditor/" />
</DIV>
<div id="footer">
  <div align="center">博爱论坛系统 &copy; 2015 重庆文理学院 软件工程学院李庆香 版权所有   ICP证1000001号 </div>
  <div align="center">关于我们 · 联系方式 · 意见反馈 · 帮助中心</div>
</div>
</BODY></HTML>

