package org.design.creational.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSingleton {
    private static LockSingleton instance = null;
    private static Lock lock = new ReentrantLock();

    private LockSingleton() {
    }

    public static LockSingleton getInstance() {
        if (null == instance) {
            lock.lock();//显示调用，手动加锁
            if (instance == null) {
                instance = new LockSingleton();
            }
            lock.unlock();//显示调用，手动加锁
        }
        return instance;
    }
}
