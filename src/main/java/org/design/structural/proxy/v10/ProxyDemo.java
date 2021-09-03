package org.design.structural.proxy.v10;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/*
v10 通过反射观察生成的代理对象。jdk反射生成代理必须面向接口，这是由Proxy的内部实现决定的。
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Tank tank = new Tank();
        //reflection 通过二进制字节码分析类的属性和方法
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class}, //tank.class.getInterfaces()
                new LogHandler(tank)
        );
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
        Arrays.stream(proxy.getClass().getMethods()).map(Method::getName).forEach(System.out::println);

        before();
        Object o = method.invoke(tank, args);
        after();
        return o;
    }
}



