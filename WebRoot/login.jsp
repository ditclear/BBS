<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<s:i18n name="info">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><s:text name="userLogin"/></TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_viewthread.css" type="text/css"></link><link
	rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_common.css" type="text/css"></link><link
	rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_editor.css" type="text/css"></link>
</HEAD>
<BODY>
	<DIV class="wrap">
		<DIV id="header">
			<div id="logo">
				<img src="<%=request.getContextPath()%>/image/logo.png"></img>
			</div>
		</DIV>
		<DIV id="nav">
			<a href="goIndex.action"><s:text name="backHome"/></a>
		</DIV>
		<DIV class="mainbox viewthread" id="previewtable"
			style="DISPLAY: none">
			<TABLE cellSpacing="0" cellPadding="0">
				<TBODY>
					<TR>
						<TD class="postauthor">
						<TD>
						<TD class="postcontent">
							<DIV class="postmessage" id="previewmessage">
								<H2></H2>
							</DIV>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</DIV>
		<BR>
		<DIV class="mainbox formbox" >
			<form name="form1" method="post" action="login.action">
				<TABLE id="newpost" cellSpacing="0" cellPadding="0" summary="post">
					<thead>
						<TR>
							<TD colspan="2"><s:text name="userLogin"/>
							</TD>
						</TR>
					</thead>
					<TR>
						<Td  class="field"><s:text name="username"/></Td>
						<TD><input type="text" name="username"
							value="${request.username}">
						</TD>
					</TR>
					<TR>
						<Td class="field"><s:text name="password"/></Td>
						<TD><input type="password" name="password">
						</TD>
					</TR>
					<tr>
					<td class="buttons" colspan="2">
						<input type="submit" value="<s:text name="login"/>" id="login" />
						<input type='button' value="<s:text name="signup"/>"
						onclick='document.location="<%=request.getContextPath()%>/register.jsp"' /></td>
					</tr>
				</TABLE>
			</form>
		</DIV>
	</DIV>
	<div id="footer">
		<div align="center">博爱论坛系统 &copy; 2015 重庆文理学院 软件工程学院李庆香 版权所有
			ICP证1000001号</div>
		<div align="center">关于我们 · 联系方式 · 意见反馈 · 帮助中心</div>
	</div>
</BODY>
</HTML>
</s:i18n>