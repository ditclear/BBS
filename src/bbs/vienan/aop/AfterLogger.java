package bbs.vienan.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

//@Aspect
public class AfterLogger {
	private static final Logger log = Logger.getLogger(AfterLogger.class);
	//@After("execution(* bbs.vienan.biz.UserBiz.*(..))")
	public void afterLogger(JoinPoint jp) {
		log.info(jp.getSignature().getName() + " 方法结束执行。");
	}
}
