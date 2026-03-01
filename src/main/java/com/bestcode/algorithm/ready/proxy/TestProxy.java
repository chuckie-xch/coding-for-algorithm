package com.bestcode.algorithm.ready.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/1/18 4:15 PM
 **/
public class TestProxy {

//    public static void main(String[] args) {
//        MessageService target = new MessageServiceImpl();
//        MessageService proxy = (MessageService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MessageServiceHandler(target));
//        proxy.sendMessage("hello world");
//    }

//    public static void main(String[] args) {
//        AliSmsService service = (AliSmsService) Enhancer.create(AliSmsService.class, new CglibMessageHandler());
//        service.sendMessage("hello world");
//    }

    public static void main(String[] args) {
        AliSmsService service = (AliSmsService) ProxyFactory.getProxy(AliSmsService.class, new CglibMessageHandler());
        service.sendMessage("hello world");
    }
}
