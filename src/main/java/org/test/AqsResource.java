package org.test;

import java.util.concurrent.locks.ReentrantLock;

public class AqsResource {
    private static volatile int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        i++;
        lock.unlock();

    }
}
