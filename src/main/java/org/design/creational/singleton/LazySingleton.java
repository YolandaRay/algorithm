package org.design.creational.singleton;

/**
 * 线程不安全
 */
public class LazySingleton {
    private static LazySingleton INSTANCE;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->
                    System.out.println(LazySingleton.getInstance())
            ).start();
        }
    }
}
