<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><s:property value="subItemName" />
</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">

<style type="text/css">
<!--
.STYLE1 {
	color: #069
}
-->
</style>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style_1_viewthread.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style_1_editor.css"
	type="text/css">
</link>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style_1_common.css"
	type="text/css"></link>
</HEAD>
<BODY>
	<DIV class="wrap">
		<DIV id="header">
			<div id="logo">
				<img src="<%=request.getContextPath()%>/image/logo.png"></img>
			</div>
		</DIV>
	</DIV>
	<DIV id="menu">
		<SPAN class="avataonline"> <s:if
				test="#session.loginuser != null">
			${loginuser.username}欢迎你!
			<s:if
					test="2==#session.loginuser.popedom || 1==#session.loginuser.popedom">
					<a href="admin/index.jsp">系统设置</a>
				</s:if>
			</s:if> <s:else>
				<A href="login.jsp">登录</A>
			</s:else>
		</SPAN>
	</DIV>
	<DIV id="nav">
		<A href="goIndex.action">BBS论坛</A> &raquo;${subItemName } <SPAN
			class="postbtn" id="newspecial"><a
			href="newTopic.jsp?subItemID=${param.subItemID}&subItemName=${subItemName}"><IMG
				src="<%=request.getContextPath()%>/image/newtopic.gif" alt=发表新帖
				width="84" height="29">
		</a>
		</SPAN>
	</DIV>
	<DIV id="headfilter"></DIV>
	<DIV class="mainbox threadlist">
		<H1>
			<!-- 输出子栏目标题 -->
			<s:property value="subitemname" />
		</H1>
		<TABLE cellSpacing="0" cellPadding="0" summary="forum_38">
			<THEAD class="category">
				<TR>
					<TD width="40" class="folder">&nbsp;</TD>
					<TD width="16" class="icon">&nbsp;</TD>
					<TH width="584">标题</TH>
					<TD width="149" class=author>作者</TD>
					<TD width="90" class=nums>回复/查看</TD>
				</TR>
			</THEAD>

			<!-- 对查询出的某个子栏目下的所有帖子进行遍历输出 -->
			<s:iterator value="topicList" var="topic">
				<TBODY>
					<TR>
						<TD class="folder"><IMG
							src="<%=request.getContextPath()%>/image/folder_hot.gif"
							width="19" height="22">
						</TD>
						<TD class="icon">&nbsp;</TD>
						<TH class="hot"><LABEL>&nbsp;</LABEL> <SPAN id=thread_60140><A
								style="FONT-WEIGHT: bold;"
								href="showTopic.action?subItemID=${subItemID}&subItemName=${subItemName}&topicID=${topic.topicid}&curPage=1"><s:property
										value="#topic.title" />
									<!-- 输出帖子标题 -->
							</A>
						</SPAN>
						</TH>
						<TD class="author"><CITE><A href=""><s:property
										value="#topic.users.username" />
									<!-- 输出发帖人 -->
							</A> </CITE><EM><s:property value="#topic.topicdate" />
								<!-- 输出帖子发表日期 -->
						</EM></TD>
						<s:set var="replys" value="#attr.topic.replys"></s:set>
						<TD class="nums"><STRONG><s:property
									value="#topic.replies.size()" />
								<!-- 输出回复量 -->
						</STRONG> / <EM><s:property value="#topic.hasread" />
								<!-- 输出查看量 -->
						</EM>
						</TD>
					</TR>
				</TBODY>
			</s:iterator>
			<!--遍历结束 -->
		</TABLE>
	</DIV>
	<SPAN class="postbtn" id="newspecialtmp"> <a
		href="newTopic.jsp?subItemID=${param.subItemID}"><IMG
			src="<%=request.getContextPath()%>/image/newtopic.gif" alt=发表新帖
			width="84" height="29">
	</a>
	</SPAN>
	<div id="footer">
		<div align="center">博爱论坛系统 &copy; VIENAN ICP证1000001号</div>
		<div align="center">关于我们 · 联系方式 · 意见反馈 · 帮助中心</div>
	</div>
</BODY>
</HTML>
