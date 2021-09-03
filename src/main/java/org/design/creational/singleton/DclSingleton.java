package org.design.creational.singleton;

//DoubleCheckLock 双重检查锁 懒汉式

import java.io.Serializable;

public class DclSingleton implements Serializable {
    //加上volatile关键字，禁止指令重拍，防止多线程的情况下，返回为初始化完成的对象。
    //transient是Java语言的关键字，用来表示一个域不是该对象串行化的一部分。当一个对象被串行化的时候，
    //transient型变量的值不包括在串行化的表示中，然而非transient型的变量是被包括进去的。
    private static volatile DclSingleton INSTANCE;

    private DclSingleton() {
    }

    public static DclSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DclSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DclSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
