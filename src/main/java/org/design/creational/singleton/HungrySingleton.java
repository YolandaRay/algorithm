package org.design.creational.singleton;

import java.io.Serializable;

/*
 * 饿汉式，类加载到内存后，就实例化一个单例，JVM保证线程安全。
 * 优点：简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化，Class.forName("")。
 */
public class HungrySingleton implements Serializable {
    //static final  INSTANCE大写
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
