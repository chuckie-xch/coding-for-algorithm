package com.bestcode.algorithm.ready.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/1/18 4:41 PM
 **/
public class ProxyFactory {

    public static Object getProxy(Class<?> clazz, MethodInterceptor interceptor) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(interceptor);
        return enhancer.create();
    }
}
