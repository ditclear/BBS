<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="checkSession.jsp" %>

<html>
<head>
<link rel="stylesheet" href="inc/css.css" type="text/css" />
</head>
<body>
<form name="form1" method="post" action="subItemAdd.action">
  <table width="600" border="0" align="center" cellpadding="5" cellspacing="0">
    <tbody>
      <tr>
        <th align="center" colspan="16" style="height: 23px">新增子栏目</th>
      </tr>
      
      <tr bgcolor="#DEE5FA">
        <td colspan="16" align="center" class=txlrow>
        	<font color="red"><s:actionmessage/></font><!--显示是否添加成功-->
        </td>
      </tr>
      
      <tr align="center" bgcolor="#DEE5FA">
      	<td colspan="2"><font color="red"><s:fielderror></s:fielderror></font></td>
      </tr>

      <tr align="center" bgcolor="#DEE5FA">
        <td align="center" class="txlrow"  width="150"><div align="right">子栏目名称：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <input type="text" name="subItemName">
        </div></td>
      </tr>
      <tr align="center" bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">所属栏目：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <select name="itemID">
          	<s:iterator value="items" var="item">
            	<option value="${item.itemid}">${item.itemname}</option>
             </s:iterator>
          </select>
          </div></td>
      </tr>
   
      <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">子栏目介绍：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <input name="itemDescription" type="text" size="50">
        </div></td>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow"><div align="right">子栏目版主：</div></td>
        <td align="center" class="txlrow"><div align="left">
          <select name="manager">
          	<s:iterator value="allUser" var="user">
            	<option value="${user.userid}">${user.username}</option>
             </s:iterator>  
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
        <td colspan="16" align="center" bgcolor="#DEE5FA" class="txlrow">&nbsp;</td>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td colspan="16" align="center" class="txlrow"></td>
      </tr>
     </tbody></table>
</FORM>
</BODY>
  </HTML>