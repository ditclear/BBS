package bbs.vienan.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import org.springframework.aop.ThrowsAdvice;

public class ErrorLogger implements ThrowsAdvice {
	private static final Logger log = Logger.getLogger(ErrorLogger.class);
	/*public void afterThrowing(Method method, Object[] args, Object target,
			RuntimeException e) {
		log.error(method.getName() + "方法发生异常：" + e);
	}
	public void afterThrowing(Method method, Object[] args, Object target,
			SQLException ex) {
		log.error(method.getName() + "方法发生异常：" + ex);
	}*/
	//@AfterThrowing(pointcut = "execution(* bbs.vienan.biz.UserBiz.*(..))", throwing = "e")
	public void afterThrowing(JoinPoint jp, RuntimeException e) {
		log.error(jp.getSignature().getName() + " 方法发生异常：" + e);
	}

}
