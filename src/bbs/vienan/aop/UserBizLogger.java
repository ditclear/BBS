package bbs.vienan.aop;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

//@Aspect
public class UserBizLogger{
	private static final Logger log=Logger.getLogger(UserBizLogger.class);
	//定义前置增强
	//@Before("execution(* bbs.vienan.biz.UserBiz.*(..))")
	public void before(JoinPoint jPoint) {
		// TODO Auto-generated method stub
		log.info("调用 " + jPoint.getTarget() + " 的 " + jPoint.getSignature().getName()+ " 方法。方法入参：" 
				+ Arrays.toString(jPoint.getArgs()));
	}
	//定义后置增强
	//@AfterReturning(pointcut="execution(* bbs.vienan.biz.UserBiz.*(..))",returning="returnValue")
	public void afterReturning(JoinPoint jPoint,Object returnValue) { 
		log.info("调用 " + jPoint.getTarget() + " 的 " + jPoint.getSignature().getName() + " 方法。 "
				+ "方法返回值：" + returnValue);
	}
}
