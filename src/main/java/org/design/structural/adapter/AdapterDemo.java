package org.design.structural.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Adapter Wrapper
 * 电压转接头
 * java.io
 * ASM transformer
 * 误区：
 *  常见的Adapter反而不是适配器模式
 *      java.awt.event.WindowAdapter
 *      java.awt.event.KeyAdapter
 *      如果直接实现接口WindowListener，需要实现的方法太多。
 *      为了方便编程，abstract WindowsAdapter 实现了WindowListener，我们只需要实现自己关心的方法即可。
 *  sql server odbc
 *  Java jdbc
 *  jdbc-odbc-bridge
 */
public class AdapterDemo {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Users/apple/idea_workspace/algorithm/src/main/resources/temp/decorator.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();

    }
}
