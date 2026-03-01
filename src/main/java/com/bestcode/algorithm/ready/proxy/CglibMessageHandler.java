package com.bestcode.algorithm.ready.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/1/18 4:29 PM
 **/
public class CglibMessageHandler implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("check telephone....");

        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println("finish send");

        return result;
    }
}
