package org.design.structural.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
java中字符串常量池，使用的是享元模式。享元模式即共享元数据，本质是池化技术。
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s3 == s4);//false
        System.out.println(s3.intern() == s1);//true
        System.out.println(s3.intern() == s4.intern());//true
    }
}

class ConnectPool {
    List<Connect> connects = new ArrayList<>();

    {
        for (int i = 0; i < 20; i++) {
            connects.add(new Connect());
        }
    }

    public Connect getConnect() {
        for (int i = 0; i < connects.size(); i++) {
            Connect connect = connects.get(i);
            if (connect.state == 0) return connect;
        }
        return new Connect();
    }
}

class Connect {
    public UUID id = UUID.randomUUID();
    int state = 0;

    @Override
    public String toString() {
        return "Connect{" +
                "id=" + id +
                ", state=" + state +
                '}';
    }
}