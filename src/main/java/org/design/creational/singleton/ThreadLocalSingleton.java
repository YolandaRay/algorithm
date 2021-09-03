package org.design.creational.singleton;

/**
 * 通过thread local
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> tlSingleton = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return tlSingleton.get();
    }
}
