package org.design.structural.proxy.v8;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/*
5、如何实现代理多个方法？毕竟日志记录、时间计算是很多方法都需要的功能。
如何实现代理多个类？想让LogProxy、AuthProxy可以重用，不仅可以代理A，也可以代理其它可以代理的类型Object。
怎么实现代理的任意组合？
解决办法：
    分离代理行为与被代理对象
    jdk动态代理

6、如果不知道被代理类的接口呢？ 想代理任意对象怎么办？
使用jdk动态代理，利用反射实现，在运行过程中分析字节码文件，找出方法，并调用。
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Tank tank = new Tank();
        //reflection 通过二进制字节码分析类的属性和方法
        //匿名内部类可以写成外部类。InvocationHandler可以写出来，LogHandler
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method " + method.getName() + " start..");
                        Object o = method.invoke(tank, args);
                        System.out.println("method " + method.getName() + " end!");
                        return o;
                    }
                }
        );
        /*
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class}, //tank.class.getInterfaces()
                new LogHandler(tank)
        );
        */
        m.move();
    }
}

interface Movable {
    void move();
}

class Tank implements Movable {
    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LogHandler implements InvocationHandler {
    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    //自己指定要代理的对象、方法、参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + " start..");
        Object o = method.invoke(tank, args);
        System.out.println("method " + method.getName() + " end!");
        return o;
    }
}



