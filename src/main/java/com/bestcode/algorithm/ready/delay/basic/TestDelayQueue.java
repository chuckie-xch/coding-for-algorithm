package com.bestcode.algorithm.ready.delay.basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/6/24 19:42
 **/
public class TestDelayQueue {

    public static void main(String[] args) {
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        queue.add(new DelayTask("order1", new Date(System.currentTimeMillis())));
        queue.add(new DelayTask("order2-5s", new Date(System.currentTimeMillis() + 5000)));
        queue.add(new DelayTask("order3-10s", new Date(System.currentTimeMillis() + 10000)));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (!queue.isEmpty()) {
            DelayTask task;
            try {
                task = queue.take();
                System.out.println(task.getTaskTime() + ":" + sdf.format(task.getTaskTime()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
