package com.bestcode.algorithm.ready.proxy;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/1/18 4:20 PM
 **/
public class MessageServiceImpl implements MessageService {


    @Override
    public boolean sendMessage(String message) {

        System.out.println("发送内容:" + message);

        return true;
    }
}
