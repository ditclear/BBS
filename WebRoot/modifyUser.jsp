<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>修改用户信息</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8"/>
<link rel="stylesheet" href="css/style_1_common.css" type="text/css"></link><link rel="stylesheet" href="css/style_1_editor.css" type="text/css"></link><link rel="stylesheet" href="css/style_1_viewthread.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery.js"></script>
<s:head theme="xhtml"/>
<sx:head parseContent="true"/>
</HEAD>
<BODY>
<DIV class="wrap">
<DIV id="header">
			<div id="logo">
				<img src="image/logo.png"></img>
			</div>
		</DIV>
</DIV>
<DIV id="nav"><a href="goIndex.action">返回首页</a></DIV>
<DIV class="mainbox viewthread" id="previewtable" style="DISPLAY: none">
<TABLE cellSpacing="0" cellPadding="0" >
  <TBODY>
  <TR>
    <TD class="postauthor"><s:actionmessage></s:actionmessage><TD>
    <TD class="postcontent">
      <DIV class="postmessage" id="previewmessage">
      <H2></H2></DIV></TD></TR></TBODY></TABLE></DIV><BR>
<DIV class="mainbox formbox">
<s:form name="form1" method="post" action="modify" enctype="multipart/form-data" validate="true">
<TABLE id="newpost" cellSpacing="0" cellPadding="0" summary="post">
	<thead>
						<TR>
							<TD colspan="2">修改用户信息<font color="red"><s:actionmessage />
							</font>
							</TD>
						</TR>
					</thead>
  <TR>
  	<s:hidden name="userId" value="%{#session.loginuser.userid}" />
  	<s:hidden name="popedom" value="%{#session.loginuser.popedom}" />
  	<s:hidden name="integral" value="%{#session.loginuser.integral}" />
  	<s:hidden name="images" value="%{#session.loginuser.images}" />
    <Td  class="field">用&nbsp;&nbsp;户&nbsp;&nbsp;名</Td>
    <td align="left"><s:textfield name="username" value ="%{#session.loginuser.username}"/>
	     <span style="color: red;">*</span>用户名长度为6到15之间
	     <span  id="Name" style="color: red;">${errors["users.username"]}</span>
	 </td>
	     
  </TR>
  <TR>
	 <Td  class="field">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;码</Td>
    <TD align="left"><s:password name="password" showPassword="true"
     value="%{#session.loginuser.password}"/>
	    <font color="red">*</font>密码长度为6到15之间</TD>
  </TR>
    <TR>
	 <Td  class="field">确认密码</Td>
    <TD align="left"><s:password name="repassword" showPassword="true"
     value="%{#session.loginuser.password}"/>
          <font color="red">*</font>确认密码长度为6到15之间</TD>
  </TR>
    <TR>
	 <Td  class="field">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</Td>
    <TD align="left"><s:select list="#{'男':'男','女':'女'}" name="sex" 
    value="%{#session.loginuser.sex}"></s:select>
	</TD>
  </TR>
    <TR>
	 <Td  class="field">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</Td>
     <TD align="left"> <s:textfield  name="age" value ="%{#session.loginuser.age}"/></TD>
  </TR>
    <TR>
	 <Td  class="field">出生日期</Td>
    <TD align="left"><sx:datetimepicker name="birthDay" displayFormat="yyyy-MM-dd" value="%{#session.loginuser.birthday}"/></TD>
  </TR>
   <TR class="buttons">
	      <TD colspan="2" align="center"><input type="submit" value="修改">
          <input type="reset"  value="重置"></TD>
  </TR>
</TABLE>
</s:form>
</DIV>
<div id="footer">
		<div align="center">博爱论坛系统 &copy; VIENAN
			ICP证1000001号</div>
		<div align="center">关于我们 · 联系方式 · 意见反馈 · 帮助中心</div>
	</div>
</BODY></HTML>
