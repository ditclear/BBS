<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>发表新帖</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gbk">
<link rel="stylesheet" href="css/style_1_common.css" type="text/css"></link>
<link rel="stylesheet" href="css/style_1_editor.css" type="text/css"></link>
<link rel="stylesheet" href="css/style_1_viewthread.css" type="text/css"></link></HEAD>
<BODY>
	<DIV class="wrap">
		<DIV id="header"></DIV>
		<DIV id="menu">
			<SPAN class="avataonline"> </SPAN>
		</DIV>
		<DIV id="nav">
			<a href="showAllTopic.action?subItemID=${param.subItemID}">返回帖子列表页面</a>
		</DIV>

		<DIV class="mainbox viewthread" id="previewtable"
			style="DISPLAY: none">
			<TABLE cellSpacing="0" cellPadding="0">
				<TBODY>
					<TR>
						<TD class="postauthor"><s:actionmessage></s:actionmessage>
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
		<FORM id="postform" action="topicAdd.action" method="post">
			<DIV class="mainbox formbox">
				<TABLE id="newpost" cellSpacing="0" cellPadding="0" summary="post">
					<THEAD>
						<TR>
							<TH>用户名</TH>
							<TD>${loginuser.username}</TD>
							<input type="hidden" name="userId" value="${loginuser.userid}" />
							<input type="hidden" name="subItemID" value="${param.subItemID}" />
							<input type="hidden" name="subItemName" value="${param.subItemName}" />
							
						</TR>
					</THEAD>
					<TR>
						<TH style="BORDER-BOTTOM-WIDTH: 0px"><LABEL for=subject>标题</LABEL>
						</TH>
						<TD style="BORDER-BOTTOM-WIDTH: 0px"><INPUT id="subject"
							tabIndex="3" size="45" name="title"></TD>
					</TR>
					<TBODY id="threadtypes"></TBODY>
					<TBODY>
						<TR>
							<TH vAlign="top"><LABEL for="posteditor_textarea">内容
							</LABEL>
							</TH>
							<TD vAlign="top"><TABLE class="editor_text"
									style="TABLE-LAYOUT: fixed" cellSpacing="0 " cellPadding="0"
									summary="Message Textarea">
									<TBODY>
										<TR>
											<TD> <textarea cols="80" id="content" name="content" rows="10"></textarea> 
											</TD>
										</TR>
									</TBODY>
								</TABLE>
					<DIV id="posteditor_bottom">
						<DIV id="img_hidden"
							style="FILTER: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image'); WIDTH: 902px; POSITION: absolute; TOP: -100000px; HEIGHT: 20000px"
							alt="1">
						</DIV>
					</DIV>
					</DIV>
					</TD>
					</TR>
					<THEAD>
						<TR>
							<TH>&nbsp;</TH>
							<TD><LABEL></LABEL>
							</TD>
						</TR>
					</THEAD>
					<TBODY id="adv" style="DISPLAY: none"></TBODY>
					<TBODY>
						<TR class="btns">
							<TH>&nbsp;</TH>
							<TD><BUTTON id="postsubmit" tabIndex="300"
									name="topicsubmit" type="submit" value="true">发表新帖</BUTTON></TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
			<BR>
		</FORM>
		<ckeditor:replace replace="content" basePath="ckeditor/" />
		<div id="footer">
			<div align="center">博爱论坛系统 &copy; 2015 重庆文理学院 软件工程学院李庆香 版权所有
				ICP证1000001号</div>
			<div align="center">关于我们 · 联系方式 · 意见反馈 · 帮助中心</div>
		</div>
</BODY>
</HTML>
