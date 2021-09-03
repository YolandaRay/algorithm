package org.design.creational.singleton;

/*
静态内部类方式，JVM保证单例，加载外部类时不会加载内部类，可以实现懒加载。
内部类扩展：百度搜Java内部类作用
难懂但有必要搞懂，内部类让外部类更丰富多彩，好像一个人的心里还可以住着另一个人。
什么是内部类？
    把类定义在另一个类的内部，该类就被称为内部类。
    类比JavaScript闭包
为什么要有内部类？
    封装性，不愿意别人看到操作细节，不想轻易被任何人访问。
    实现多继承。
    用匿名内部类实现回调功能。
    解决继承及实现接口出现同名方法的问题
内部类访问规则：
    可以直接访问外部类的成员，包括私有。
    外部类想要访问内部类成员，必须创建对象。
内部类的分类：
    成员内部类（位于外部类成员变量位置，可以使用外部类中所有成员变量和成员方法）
    局部内部类（定义在一个方法或者一个作用域里面的类）
    静态内部类（）
    匿名内部类（一个没有名字的类，是内部类的简化写法，本质是继承该类或者实现接口的子类匿名对象）

创建对象方式：
//成员内部类不是静态的：
外部类名.内部类名 对象名 = new 外部类名.new 内部类名();
//成员内部类是静态的：
外部类名.内部类名 对象名 = new 外部类名.内部类名();


 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private static class StaticInnerClassSingletonHolder {
        private final static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClassSingletonHolder.INSTANCE;
    }
}
