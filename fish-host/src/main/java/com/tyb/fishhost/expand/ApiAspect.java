package com.tyb.fishhost.expand;

import com.alibaba.druid.support.json.JSONUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 请求Aop拦截器
 */
@Aspect
@Configuration
public class ApiAspect {

    private static final Logger logger = LoggerFactory.getLogger(ApiAspect.class);
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    /**
     * 定义切点表达式
     */
    @Pointcut("execution(* com.tyb.fishhost.controller.AopController.*(..))")
    @Order(2)
    public void controllerPoint() {

    }

    /**
     * 定义注解类型的切点，只要方法上有该注解，都会匹配
     */
    @Pointcut("@annotation(com.tyb.fishhost.expand.RedisAopCache)")
    @Order(1)
    public void annotationPoint() {

    }

    /**
     * 定义前置通知
     *
     * @param joinPoint
     */
    @Before("annotationPoint()")
    public void before(JoinPoint joinPoint) {
        System.out.println("方法执行前执行.....before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("<====================================================================");
        logger.info("请求来源:  => " + request.getRemoteAddr());
        logger.info("请求URL: " + request.getRequestURL().toString());
        logger.info("请求方式: " + request.getMethod());
        logger.info("响应方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求参数 : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("---------------------------------------------------------------------");
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 需要匹配切点表达式，同时需要匹配参数
     *
     * @param pjp
     * @param arg
     * @return
     */
    @Around("controllerPoint() && args(arg)")
    public String around(ProceedingJoinPoint pjp, String arg) throws Throwable {
        System.out.println("name:" + arg);
        System.out.println("方法环绕start....around.");
        String result = null;

            result = (String) pjp.proceed() + " aop String";

        System.out.println("方法环绕end.....around");
        return result;
    }

    /**
     *
     */
    @After("within(com.tyb.fishhost.controller.AopController)")
    public void after() {
        System.out.println("方法之后执行....after.");
    }

    /**
     * @param joinPoint
     * @param rst
     */
    @AfterReturning(pointcut = "controllerPoint()", returning = "rst")
    public void afterReturning(JoinPoint joinPoint, Object rst) {
        System.out.println("方法执行完执行.....afterReturning");
        logger.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
        logger.info("返回数据: {}", JSONUtils.toJSONString(rst));
        logger.info("====================================================================>");
    }

    /**
     *
     */
    @AfterThrowing("within(com.tyb.fishhost.controller.AopController)")
    public void afterThrowing() {
        System.out.println("异常出现之后.....afterThrowing");
    }

}
