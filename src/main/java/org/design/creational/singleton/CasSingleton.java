package org.design.creational.singleton;

import java.util.concurrent.atomic.AtomicReference;

/*
cas是一项乐观锁技术，当多个线程尝试使用cas同时更新一个变量时，只有其中一个线程能更新变量的值，而其它线程都失败，失败的线程并不会被挂起，而是被告知竞争失败，并可以再次尝试。
优点：本质是基于忙等待算法，依赖底层硬件的实现。没有线程切换和阻塞的额外消耗。
缺点：一直执行不成功，对cpu造成较大的开销。
 */
public class CasSingleton {
    private static final AtomicReference<CasSingleton> INSTANCE = new AtomicReference<CasSingleton>();

    private CasSingleton() {
    }

    public static CasSingleton getInstance() {
        for (; ; ) {
            CasSingleton casSingleton = INSTANCE.get();
            if (null != casSingleton) {
                return casSingleton;
            }
            casSingleton = new CasSingleton();
            if (INSTANCE.compareAndSet(null, casSingleton)) {
                return casSingleton;
            }
        }

    }
}
