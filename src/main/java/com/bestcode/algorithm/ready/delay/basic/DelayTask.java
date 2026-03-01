package com.bestcode.algorithm.ready.delay.basic;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/6/24 19:46
 **/
public class DelayTask implements Delayed {


    private String name;

    private Date taskTime;

    public DelayTask(String name, Date taskTime) {
        this.name = name;
        this.taskTime = taskTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(taskTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof DelayTask) {
            DelayTask other = (DelayTask) o;
            long diff = taskTime.getTime() - other.getTaskTime().getTime();
            if (diff > 0) {
                return 1;
            } else if (diff == 0) {
                return 0;
            } else {
                return -1;
            }
        }
        throw new IllegalStateException("not supposed to be implemented");
    }

    public String getName() {
        return name;
    }

    public Date getTaskTime() {
        return taskTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }
}
