package bbs.vienan.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//@Aspect
public class AroundLogger{
	private static final Logger log = Logger.getLogger(AroundLogger.class);
	/*public Object invoke(MethodInvocation arg0) throws Throwable {
		Object target = arg0.getThis(); // 获取被代理对象
		Method method = arg0.getMethod(); // 获取被代理方法
		Object[] args = arg0.getArguments(); // 获取方法参数
		log.info("调用 " + target + " 的 " + method.getName() + " 方法。方法入参：" 
				+ Arrays.toString(args));
		try {	Object result = arg0.proceed();// 调用目标方法，获取目标方法返回值
			log.info("调用 " + target + " 的 " + method.getName() + " 方法。 "
				+ "方法返回值：" + result);
			return result;
		} catch (Throwable e) {
			log.error(method.getName() + " 方法发生异常：" + e);        throw e;
		}

	}	*/
	//@Around("execution(* bbs.vienan.biz.UserBiz.*(..))")
    public Object aroundLogger(ProceedingJoinPoint jp) throws Throwable {
        log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() 
				+ " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
        try {	Object result = jp.proceed();
            log.info("调用 " + jp.getTarget() + " 的 " 
			+ jp.getSignature().getName() + " 方法。方法返回值：" + result);
            return result;
        } catch (Throwable e) {
    log.error(jp.getSignature().getName() + " 方法发生异常：" + e);
    throw e; }
    }	
	
}


