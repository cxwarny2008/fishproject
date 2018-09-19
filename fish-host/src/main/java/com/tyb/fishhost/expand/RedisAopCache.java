package com.tyb.fishhost.expand;

import java.lang.annotation.*;

/**
 *aop-redis缓存
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RedisAopCache {
    Class<?> type();//被代理类的全类名，在之后会做为redis hash 的key
}


