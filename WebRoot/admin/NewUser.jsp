<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="checkSession.jsp" %>

<html>
<head>
<link rel="stylesheet" href="inc/css.css" type="text/css" />
</head>
<body>
<form name="form1" method="post" action="addUser.action">
  <table width="600" border=0 align=center cellpadding=5 cellspacing=0 >
    <tbody>
      <tr>
        <th align=center colspan=16 style="height: 23px">新增用户</th>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td colspan="16" align="center" class=txlrow>
        	<font color="red"><s:actionmessage/></font><!-- 显示是否添加成功 -->
        </td>
      </tr>
      
      <tr align="center" bgcolor="#DEE5FA">
      	<td colspan="3"><font color="red"><s:fielderror></s:fielderror></font></td>
      </tr>
      
      <tr align="center" bgcolor="#DEE5FA">
        <td align="center" class="txlrow" width="150"><div align="right">用户名：</div></td>
        <td align="center" class="txlrow">
	        <div align="left">
	          	<input type="text" name="username" value="${request.username}">
	          	<font color="red">*</font>用户名长度为6到15之间
	        </div>
        </td>
      </tr>
      <tr align="center" bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">密码：</div></td>
        <td align="center" class="txlrow">
        <div align="left">
         	<input type="password" name="password">
	        <font color="red">*</font>密码长度为6到15之间
	     </div>
        </td>
      </tr>
   
      <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">确认密码：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <input type="password">
          <font color="red">*</font>确认密码长度为6到15之间
        </div></td>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">性别：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <select name="sex">
            <option value="男">男</option>
            <option value="女">女</option>
          </select>
          </div></td>
      </tr>
      <%-- <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">年龄：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <input name="age" type="text" size="10" value="${request.age}">
        </div></td>
      </tr> --%>
      <tr>
       <s:hidden name="images" value="%{#session.loginuser.images}" />
       </tr>
      <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">出生日期：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <input type="text" name="birthDay">
        </div></td>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">权限：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <select name="popedom">
            <option selected value="1">管理员</option>
            <option value="2">栏目版主</option>
            <option value="3">子栏目版主</option>
            <option value="4">普通用户</option>
          </select>
        </div></td>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right"></div></td>
        <td align="center" class="txlrow"><div align="left">
          <input type="submit" value="提交">
          <input type="reset" value="重置">
        </div></td>
      </tr>
    
      <tr bgcolor="#DEE5FA">
        <td colspan="16" align=center bgcolor="#DEE5FA" class=txlrow>&nbsp;</td>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td colspan=16 align=center class=txlrow></td>
      </tr>
 </tbody></table>
</FORM>
</BODY>
  </HTML>