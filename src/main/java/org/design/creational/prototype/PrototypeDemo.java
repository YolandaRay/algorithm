package org.design.creational.prototype;

import java.util.Hashtable;

/*
原型模式
Object.clone()
自带
实现原型模式需要实现标记原型接口Cloneable
一般会重写clone()方法，如果只是重写clone()方法，而没有实现接口，调用时会报异常。
一般会用于一个对象的属性已经确定，需要产生很多相同对象的时候
需要区分深克隆与浅克隆：浅copy，只copy基本类型成员变量和函数，如果有对象类型成员变量，clone和原来的指向同一个对象，copy的是地址。
深克隆是把对象类型实现Cloneable，重写clone方法。手动clone并赋值。
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        ConnectCache.loadCache();
        AbstractConnect oracle = ConnectCache.getConnect("oracle");
        oracle.connectDatabase();
        AbstractConnect mysql = ConnectCache.getConnect("mysql");
        mysql.connectDatabase();
    }
}

class ConnectCache {
    private static Hashtable<String, AbstractConnect> connectMap = new Hashtable<String, AbstractConnect>();

    public static AbstractConnect getConnect(String type) {
        AbstractConnect cache = connectMap.get(type);
        return (AbstractConnect) cache.clone();
    }

    public static void loadCache() {
        OracleConnect oracle = new OracleConnect();
        oracle.setType("oracle");
        connectMap.put(oracle.getType(), oracle);
        MysqlConnect mysql = new MysqlConnect();
        mysql.setType("mysql");
        connectMap.put(mysql.getType(), mysql);
    }
}

class OracleConnect extends AbstractConnect {

    @Override
    void connectDatabase() {
        System.out.println("Oracle connect!");
    }
}

class MysqlConnect extends AbstractConnect {

    @Override
    void connectDatabase() {
        System.out.println("MySQL connect!");
    }
}

abstract class AbstractConnect implements Cloneable {
    private String ip;
    private String port;
    private String type;

    abstract void connectDatabase();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}