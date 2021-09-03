package org.design.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDestroySingleton {
    public static void main(String[] args) {
        try {
            Class clazz = DclSingleton.class;
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object obj1 = constructor.newInstance();
            Object obj2 = constructor.newInstance();
            System.out.println(obj1 == obj2);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
