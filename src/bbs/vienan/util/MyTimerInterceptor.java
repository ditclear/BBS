package bbs.vienan.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyTimerInterceptor extends MethodFilterInterceptor{	

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
			//Ԥ���?��
			long startTime = System.currentTimeMillis();
			      //ִ�к�����������Action
			String result = invocation.invoke();
			      //�����?��
			   long execTime = System.currentTimeMillis() - startTime;
			     System.out.println("The interval time is "+execTime+" ms");
			//���ؽ���ַ�
			      return result;
	}
}
