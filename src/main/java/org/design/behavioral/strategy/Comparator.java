package org.design.behavioral.strategy;

/*
java 1.8之后为了lambada表达式，接口里也可以写方法的实现
比较器，如何判断对象之间的大小或者顺序。
比较器是用来写比较策略的。
 */
@FunctionalInterface
public interface Comparator<T> {
    int compareTo(T o1, T o2);

    default void m() {
        System.out.println("m");
    }

}
