<%@ page language="java" import="bbs.vienan.bean.User" pageEncoding="utf-8"%>

<%
	User u=(User)session.getAttribute("loginuser");
	if (session.getAttribute("loginuser") == null || (u.getPopedom() != 1 && u.getPopedom() != 2)) {
		response.sendRedirect("../login.jsp");
	}
%>
