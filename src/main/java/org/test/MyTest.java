package org.test;

import java.util.Locale;
import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Please input message");
            Scanner scan = new Scanner(System.in);
            // 从键盘接收数据
            // nextLine方式接收字符串
            // 判断是否还有输入
            if (scan.hasNextLine()) {
                String str = scan.nextLine();
                if (str.length() != 6) {
                    System.out.println("Invalid flight code");
                    continue;
                } else {
                    String flight = str.substring(0, 2).toUpperCase(Locale.ROOT);
                    String num = str.substring(2, 6);
                    System.out.println(flight);
                    System.out.println(num);

                    if (flight.matches("[a-zA-Z]+") && num.matches("[0-9]{1,}")) {
                        System.out.println("Flight" + str + "is operated by" + "##" + "flying to" + "##");

                    } else {
                        System.out.println("Invalid flight code");
                        continue;
                    }

                }
            }
        }

    }
}
