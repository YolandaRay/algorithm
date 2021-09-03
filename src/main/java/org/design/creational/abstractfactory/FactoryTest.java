package org.design.creational.abstractfactory;

/*
什么是工厂模式？
    任何可以产生对象的方法或类，都可以称之为工厂模式。其实从一定角度来说单例模式也是工厂模式。不可咬文嚼字，不必纠结概念，真正学好设计模式，会让你达到到手中无剑，心中有剑的境界。
为什么明明可以new对象，还要有工厂？
    灵活控制生产过程；
    加权限、修饰、日志等操作；
    不需要关注复杂对象创建过程；
实际应用场景？
    Hibernate 换数据库只需换方言和驱动就可以。
    Spring
一步步推到，请思考以下需求：
    1、任意定制交通工具（继承Vehicle类）
    2、任意定制生产过程（继承Vehicle类，VehicleFactory.create()）
    3、任意定制产品族（抽象工厂）
实现：
    一个工厂设计模式需求，不用工厂设计模式或者用其它设计模式也能实现，我们要做的是选一种更好的方式实现。这个好的评价标准就是设计模式需要遵守的6大原则。例如其中的开闭原则，在实现需求的时候避免修改原来的类、方法。

简单工厂、静态工厂：
 Car CarFactory
假如扩展公交车，增加 Bus BusFactory
缺点：每次增加一个产品，都要增加一个具体类和生产对象的工厂类。
 工厂
 Car Bus SimpleVehicleFactory
假如扩展飞机，增加Plan、在SimpleVehicleFactory中增加createPlan方法即可
缺点：每次增加一个产品，都要增加一个具体类，在生产对象的工厂类中增加create()方法。
抽象工厂
AbstractFactory
    VehicleFactory
        Vehicle
            Car、Bus、Plan、Broom
    FoodFactory
        Food
            Bread、Mushroom
    MagicFactory
        Weapon
            AK47、MagicStick
假如扩展魔法族产品，增加weapon和MagicFactory即可
缺点：要增加一个系列的某一产品，既要在AbstractFactory加create()，又要在具体实现的Factory中加create()。

问：为什么工厂模式用的是接口interface，而抽象工厂模式用的是抽象类abstract class？
答：语法上，接口和抽象类均可以。从语义上理解，概念真实存在用抽象类，强调属性用接口，名词用抽象类，形容词用接口。

问：Factory Pattern 和 Abstract Factory Pattern的区别？
答：
工厂方法适合产品扩展，想增加新产品，就创建新的工厂即可。
抽象工厂适合产品族扩展，不适合产品扩展，扩展需要加方法，改代码。

 */
public class FactoryTest {
    public static void main(String[] args) {
        AbstractFactory f = new VehicleFactory();
        Vehicle c = f.createVehicle();
        c.move();
        Food b = f.createFood();
        b.printName();
    }
}
