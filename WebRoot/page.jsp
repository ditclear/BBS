<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <script language="JavaScript">
    function Jumping(){
       document.pageForm.submit();         
    }    
    function gotoPage(pagenum){
       document.pageForm.curPage.value = pagenum;
       document.pageForm.submit();       
    }
  </script>    
		<table style="color:#577DFF;">  
		  <tr>
		    <td>总共${pageBean.totalPage}页</td>
		    <td>&nbsp;当前第${pageBean.currentPage }页</td>
		    <td>
		    	&nbsp;
		      <a href="javascript:gotoPage(1)">首页</a>
		      <c:if test="${pageBean.currentPage>1}">
		      		&nbsp;<a href="javascript:gotoPage(${pageBean.currentPage-1})">上一页</a>
		      </c:if>
		      <c:if test="${pageBean.currentPage < pageBean.totalPage}">  
		       		&nbsp;<a href="javascript:gotoPage(${pageBean.currentPage+1})">下一页</a>
		       </c:if>
		       &nbsp;
		       <a href="javascript:gotoPage(${pageBean.totalPage})">尾页</a>
		      
		    </td>
	
		     <td>
		   		    	
				    &nbsp;转到第<select name="curPage" onchange="Jumping()">
				     		<c:forEach var="index" begin="1" end="${pageBean.totalPage}">
				     			<option value="${index}" <c:if test="${index==pageBean.currentPage}">selected</c:if>>${index}</option>
				     		</c:forEach>	      
				       </select>页
				
		      </td>
	       </tr>
		</table>
      
        