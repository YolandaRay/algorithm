package org.design.behavioral.template;

/*
钩子函数、回调函数、模版方法
ASM ClassVisitor
凡是自己实现一个方法，系统帮我们自动调用。
 */
public class TemplateDemo {
    public static void main(String[] args) {
        F f = new C1();
        f.m();
    }

}

abstract class F {
    public void m() {
        op1();
        op2();
    }

    abstract void op1();

    abstract void op2();
}

class C1 extends F {

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}

