<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>注册新用户</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_common.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_editor.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_1_viewthread.css" type="text/css"></link>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>

</HEAD>
<BODY>
<DIV class="wrap">
<DIV id="header">
			<div id="logo">
				<img src="<%=request.getContextPath()%>/image/logo.png"></img>
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
<s:form name="form1" method="post" action="register" enctype="multipart/form-data" validate="true">
<TABLE id="newpost" cellSpacing="0" cellPadding="0" summary="post">
	<thead>
						<TR>
							<TD colspan="2">用户注册<font color="red"><s:actionmessage />
							</font>
							</TD>
						</TR>
					</thead>
  <TR>
    <Td  class="field">用&nbsp;&nbsp;户&nbsp;&nbsp;名</Td>
    <td align="left"><input id="username" type="text" name="username" value="${request.username}">
	     <span style="color: red;">*</span>用户名长度为6到15之间
	     <span  id="Name" style="color: red;">${errors["username"][0]}</span>
	 </td>
	     
  </TR>
  <TR>
	 <Td  class="field">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;码</Td>
    <TD align="left"><input type="password" id ="password" name="password">
	    <font color="red">*</font>密码长度为6到15之间
	    <span  style="color: red;">${errors["password"][0]}</span></TD>
  </TR>
    <TR>
	 <Td  class="field">确认密码</Td>
    <TD align="left"><input type="password" name="repassword">
          <font color="red">*</font>确认密码长度为6到15之间
          <span  style="color: red;">${errors["repassword"][0]}</span></TD>
  </TR>
    <TR>
	 <Td  class="field">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</Td>
    <TD align="left"><select name="sex">
            <option value="男">男</option>
            <option value="女">女</option>
          </select></TD>
  </TR>
    <%-- <TR>
	 <Td  class="field">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</Td>
     <TD align="left"> <input name="age" type="text" size="10" value="${request.age}">
     <span  style="color: red;">${errors["age"][0]}</span></TD>
  </TR> --%>
    <TR>
	 <Td  class="field">出生日期</Td>
    <TD align="left"><input type="text" name="birthDay" />
    <span  style="color: red;">${errors["birthDay"][0]} </span> </TD>
  </TR>
  <TR>
	 <Td  class="field">请选择头像</Td>
    <TD align="left"><s:file name="uploadFile"></s:file>
     <span  style="color: red;">${errors["upload"][0]} </span>
    </TD>
  </TR>
   <TR class="buttons">
	      <TD colspan="2" align="center"><input type="submit" value="注册">
          <input type="reset" value="重置"></TD>
  </TR>
</TABLE>
</s:form>
</DIV>
<div id="footer">
  <div align="center">博爱论坛系统 &copy; 2015 重庆文理学院 软件工程学院李庆香 版权所有   ICP证1000001号 </div>
  <div align="center">关于我们 · 联系方式 · 意见反馈 · 帮助中心</div>
</div>
<script type="text/javascript">
 $(document).ready(function(){
 $("#username").on("blur",function(){
 $("#Name").html("");
 var name = $(this).val();
 if(name!=null&&name!=""){
  	 $.ajax({
		         type : "post",
 		         url:"userNameOnly.action", 	
         		 dataType : "html",
        		 data : {
     		     name : name
      			 },
		success : function(strValue){	
    	 if(strValue=="true"){
       		 $("#Name").html("用户已注册,请勿重复注册");
    	 }else{
    	 	$("#Name").html("此用户可以注册！");
    	 }
},
error : function(data) {} } )}}); });
</script>
</BODY></HTML>
