package org.design.structural.proxy.v9;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/*
v09: 横切代码与业务逻辑代码分离 AOP
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

    public void before() {
        System.out.println("method " + " start..");
    }

    public void after() {
        System.out.println("method " + " end!");
    }

    //自己指定要代理的对象、方法、参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(tank, args);
        after();
        return o;
    }
}



