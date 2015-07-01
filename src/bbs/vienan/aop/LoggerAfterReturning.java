package bbs.vienan.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LoggerAfterReturning implements AfterReturningAdvice {
	private static final Logger log = Logger.getLogger(LoggerAfterReturning.class);
	public void afterReturning(Object returnValue, Method method,
			Object[] arguments, Object target) throws Throwable {
		log.info("���� " + target + " �� " + method.getName() + " ������"
                           + "��������ֵ��" + returnValue);
	}
}

