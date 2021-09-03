package org.design.creational.singleton;

/**
 * 解决懒加载、线程同步，还可以防止反射、反序列化。
 * Effective Java 作者 Josh Bloch推荐的写法。
 */
public enum EnumSingleton {
    INSTANCE;

    public void method() {
        System.out.println("I am a function");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(EnumSingleton.INSTANCE.hashCode());
                EnumSingleton.INSTANCE.method();
            }).start();
        }
    }
}
