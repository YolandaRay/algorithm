package org.design.structural.decorator;

import java.io.*;

public class Example {
    public static void main(String[] args) throws IOException {
        /*
        OutputStream
        OutputStreamWriter
        BufferedWriter
         */
//        File f = new File("/Users/apple/idea_workspace/algorithm/src/main/resources/temp/decorator.txt");
//        FileOutputStream fos = new FileOutputStream(f);
//        OutputStreamWriter osw = new OutputStreamWriter(fos);
//        BufferedWriter bw = new BufferedWriter(osw);
//        bw.write("decorator");
//        bw.flush();
//        bw.close();

        /**
         * 需求：想要circle画出红线、绿线，常规做法是创建RedCircle、GreenCircle，这样会类爆炸。
         * 用聚合方式代替继承。
         * （1）装饰者继承或者实现与被装饰者同样的接口或者抽象类
         * （2）在装饰者类中，把被装饰者设置成员变量。即把被装饰者传进来。
         * （3）在调用被装饰者的函数时，增加其它其它操作。
         */
        Shape circle = new Circle();
        RedCircleDecorator redCircle = new RedCircleDecorator(circle);
        circle.draw();
        redCircle.draw();

    }
}
