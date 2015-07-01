<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="checkSession.jsp" %>

<html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/admin/inc/css.css" type="text/css" />
	<script type="text/javascript">
		function submitForm(){
			var frm=document.userForm;
			frm.submit();
		}
	</script>
</head>
<body>
  <table width="600" border=0 align=center cellpadding=2 cellspacing=1 bordercolor="#799AE1" class=tableBorder>
    <tbody>
      <tr>
        <th align=center colspan=22 style="height: 23px">浏览用户</th>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td colspan="22" align="center" class=txlrow><div align="right">
          <form name="userForm" action="findAllUser" method="post">
          请选择权限：<select name="popedom" onchange="submitForm()">
            <option value="1" 
            	<s:if test="popedom == 1">selected</s:if>
            >管理员</option>
            <option value="2"
            	<s:if test="popedom == 2">selected</s:if>
            >栏目版主</option>
            <option value="3"
            	<s:if test="popedom == 3">selected</s:if>
            >子栏目版主</option>
            <option value="4"
            	<s:if test="popedom == 4">selected</s:if>
            >普通用户</option>
          </select>
          </form>
          </div></td>
      </tr>
      <tr align="center" bgcolor="#799AE1">
        <td align="center" class="txlHeaderBackgroundAlternate">用户ID</td>
        <td align="center" class="txlHeaderBackgroundAlternate">用户名</td>
        <td align="center" class="txlHeaderBackgroundAlternate">密码</td>
        <td align="center" class="txlHeaderBackgroundAlternate">性别</td>
        <td align="center" class="txlHeaderBackgroundAlternate">年龄</td>
        <td align="center" class="txlHeaderBackgroundAlternate">出生日期</td>
        <td align="center" class="txlHeaderBackgroundAlternate">积分</td>
        <td align="center" class="txlHeaderBackgroundAlternate">删除用户</td>
      </tr>
      
	<s:if test="allUser.isEmpty()">
		<tr bgcolor="#DEE5FA"><td colspan="8">暂无任何用户记录!</td></tr>
	</s:if>
	<s:else>      
	<s:iterator value="allUser" var="user">
		<tr bgcolor="#DEE5FA">
	       <td align="center" class="txlrow">${user.userid}</td>
	       <td align="center" class="txlrow">${user.username}</td>
	       <td align="center" class="txlrow">${user.password}</td>
	       <td align="center" class="txlrow">${user.sex =='男' ? '男':'女'}</td>
	       <td align="center" class="txlrow">${user.age}</td>
	       <td align="center" class="txlrow"><s:date name="#attr.user.birthday" format="yyyy年MM月dd日"/></td>
	       <td align="center" class="txlrow">${user.integral}</td>
	       <td align="center" class="txlrow"><a href="userDelete.action?userid=${user.userid}">删除</a></td>
		</tr>
	</s:iterator>
    </s:else>
      <tr bgcolor="#DEE5FA">
        <td colspan="22" align=center bgcolor="#DEE5FA" class=txlrow>&nbsp;</td>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td colspan=22 align=center class=txlrow></td>
      </tr>
	</tbody></table>
</BODY>
  </HTML>