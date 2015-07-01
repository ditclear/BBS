package bbs.vienan.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.vienan.bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AuthInterceptor extends MethodFilterInterceptor implements Filter{
	private String name;
    public void setName(String name)
   {
        this.name = name;
    }
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ�û��Ự��Ϣ
				Map session= invocation.getInvocationContext().getSession();
				User user = (User)session.get("loginuser");
				if (user == null) {
					//��ִֹ�У����ص�¼ҳ��
					return Action.LOGIN;
				} else {
					//����ִ��ʣ�����������Action
					return invocation.invoke();
				}
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;  
			        HttpServletResponse response = (HttpServletResponse) resp;  
			        HttpSession session = request.getSession(true);  
			        String url = request.getRequestURI();  
			        User user = (User)session.getAttribute("loginuser");
			        if(url.indexOf("register.jsp")!=-1){
			        	chain.doFilter(request, response);  
			        }else if (user == null && url.indexOf("login.jsp") == -1) {  
			            String location = "/login.jsp";  
			            request.getRequestDispatcher(location).forward(request, response);  
			            System.out.println("�ɹ����ص���������ͼ������վ��̨   :  " + url);  
			            response.setHeader("Cache-Control", "no-store");  
			            response.setDateHeader("Expires", 0);  
			            response.setHeader("Pragma", "no-cache");  
			        } else {  
			        	chain.doFilter(request, response);  
			        }
			 }


	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

	
}
