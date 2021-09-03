package org.primary.class01;

public class Code01_PrintBinary {
    public static void main(String[] args) {
        /*
        byte 数据类型是8位、有符号的，以二进制补码表示的整数；
        short 数据类型是 16 位、有符号的以二进制补码表示的整数
        int 数据类型是32位、有符号的以二进制补码表示的整数；
        long 数据类型是 64 位、有符号的以二进制补码表示的整数；
        float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
        double 数据类型是双精度、64 位、符合 IEEE 754 标准的浮点数；
        boolean boolean数据类型表示一位的信息
        char 类型是一个单一的 16 位 Unicode 字符；
         */
//        int num = 83928328;
//        print(num);
        int test = 1;
        print(test);
        print(test << 1);
        print(test << 2);
        print(test << 8);
        //左移，右边用0补，任何一个数字，左移一位=原来的数字*2
        /*
        int 32位
            无符号整型最大2^32
            有符号：-2^31到2^31-1
            正数，第一位是0，值是后面的用2的次方加起来。
            负数，第一位是1，值是后面的状态取反加1。
            0 划分到正数里面
        反码
        补码
         */
        int b = 133435;
        int c = ~b;//~取反
        print(b);
        print(c);
        /*
        位运算翻译加减乘除
        不管正负，底层可以用一套逻辑运算实现
         */
        //右移，新出现的左侧用符号位补
        int e = Integer.MIN_VALUE;
        print(e);
        print(e >> 1);//带符号右移，左位原来是0，就用0位补。
        print(e >>> 1);//不带符号右移，用0来补
        //一个数的相反数怎么求？取反+1
        int f = 5;
        int g = -5;
        int h = ~f + 1;
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        //先给小例子，再抽象化
    }

    public static void print(int num) {
        /*
            左移，没有带符号左移，只有带符号右移。
            & 按位与，
         */
        for (int i = 31; i > 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
