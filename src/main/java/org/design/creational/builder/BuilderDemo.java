package org.design.creational.builder;
/*
建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
    构建复杂对象
    分离复杂对象的构建和表示
    同样的构建过程可以创建不同的表示
    建造者模式无需记忆，自然使用。
简单对象不需要Builder模式，适合复杂的对象构建。
与模版方法非常像，模版方法强调的是执行，建造者强调的是构造对象。
当复杂对象有几十个参数，每次创建都要传这么多参数，有值的传值，没值的传null很麻烦。

 */
public class BuilderDemo {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine().buildWall().build();
        //new Terrain(Wall w, Fort f, Mine m)
        //Effective Java

        Person person = new Person.PersonBuilder()
                .basicInfo(1,"Ray",32)
                .score(100)
                .location(new Location("bj","999"))
                .weight(100.00D).build();
        System.out.println(person.toString());
    }
}
