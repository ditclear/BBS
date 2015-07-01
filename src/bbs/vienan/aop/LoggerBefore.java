package bbs.vienan.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggerBefore implements MethodBeforeAdvice {
	private static final Logger log = Logger.getLogger(LoggerBefore.class);

	public void before(Method method, Object[] arguments, Object target)
			throws Throwable {
		log.info("���� " + target + " �� " + method.getName() + " ������" + "������Σ�"
				+ Arrays.toString(arguments));
	}
}

