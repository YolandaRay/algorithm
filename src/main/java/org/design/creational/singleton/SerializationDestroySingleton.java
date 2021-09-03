package org.design.creational.singleton;

import java.io.*;
public class SerializationDestroySingleton {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
        DclSingleton dclSingleton = DclSingleton.getInstance();
        System.out.println(dclSingleton);

        try {
            //实例序列化到磁盘
            FileOutputStream fileOutputStream = new FileOutputStream("hungrySingleton");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(hungrySingleton);
            objectOutputStream.writeObject(dclSingleton);
            objectOutputStream.flush();
            objectOutputStream.close();

            //从磁盘反序列化
            FileInputStream fileInputStream = new FileInputStream("hungrySingleton");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            HungrySingleton object = (HungrySingleton) objectInputStream.readObject();
            DclSingleton object = (DclSingleton) objectInputStream.readObject();

            System.out.println(object);
            System.out.println(object == dclSingleton);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}
