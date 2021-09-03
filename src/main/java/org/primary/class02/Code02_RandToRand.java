package org.primary.class02;

public class Code02_RandToRand {
    /*
    此函数只能用，不能修改
    等概率返回1～5
     */
    public static int f() {
        return (int) Math.random() * 5;
    }

    /*
    等概率返回x～y
    先等概率返回0和1，然后借助位运算。
     */
    public static int a() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /*
    等概率返回0～6
     */
    public static int b() {
        int ans = 0;
        do {
            ans = a() << 2 + a() << 1 + a();
        } while (ans == 7);
        return ans;
    }

    public static void main(String[] args) {

    }
}
