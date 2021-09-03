package org.design.creational.singleton;

/**
 * 饿汉式变种
 */
public class StaticHungrySingleton {
    private static final StaticHungrySingleton INSTANCE;

    static {
        INSTANCE = new StaticHungrySingleton();
    }

    private StaticHungrySingleton() {
    }

    public static StaticHungrySingleton getInstance() {
        return INSTANCE;
    }

}
