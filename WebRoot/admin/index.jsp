<%@ page language="java" pageEncoding="utf-8" isErrorPage="false"
	errorPage="../error.jsp"%>

<%@ include file="checkSession.jsp" %>
<html>
	<head>
		<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
		<title>管理首页</title>
	</head>

	<script>
function mfk()
{
   if(shang.style.display=='none')
    {
     shang.style.display='';
    }
   else
   {
     shang.style.display='none';
   }
}
</script>
	<body scroll=no topmargin="0" leftmargin="0" style="background-color:#ddeeff">
		<table width="100%" height="100%" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td id='shang' width="162" height="100%">
					<iframe frameBorder="0" id="left" name="left" src="left.jsp"
						height="100%" width="162" target="main">
					</iframe>
				</td>
				<td align="center" class="unnamed1" onClick="mfk();" height="100%">
					<table width="100%" height="100%" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td bgcolor="#ddeeff " >
								<font color="#FFFFFF">点此切换</font>
							</td>
						</tr>
					</table>
				</td>
				<td width="100%" height="100%">
					<iframe frameBorder="0" id="mainFrame" name="mainFrame" scrolling="yes"
						 height="100%" width="100%"></iframe>
				</td>
			</tr>
		</table>
	</body>
</html>


