package com.bestcode.algorithm.ready.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/1/18 4:15 PM
 **/
public class MessageServiceHandler implements InvocationHandler {

    private final Object target;

    public MessageServiceHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("进行安全校验中...");
        System.out.println("校验通过，开始发送信息");

        Object result = method.invoke(target, args);

        System.out.println("发送成功");
        return result;
    }
}
