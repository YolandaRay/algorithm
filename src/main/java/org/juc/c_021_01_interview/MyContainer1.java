package org.juc.c_021_01_interview;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/*
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll来实现
 */
public class MyContainer1<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int max = 10;//最多10个元素
    private int count = 0;

    public synchronized void put(T t) {
        while (list.size() == max) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        list.add(t);
        //通知消费者消费
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        //通知生产者生产
        this.notifyAll();
        return t;
    }

    public void getCount(T t) {
        list.size();
    }

    public static void main(String[] args) {
        MyContainer1 c = new MyContainer1();
        //启动消费者
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            }, "c" + i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动生产者
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) c.put(Thread.currentThread().getName() + " " + j);
            }, "p" + i).start();
        }
    }
}
