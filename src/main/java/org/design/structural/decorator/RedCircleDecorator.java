package org.design.structural.decorator;
/*
与被装饰着实现同一个接口或者抽象类
 */
public class RedCircleDecorator extends Shape{
    //将被装饰着设置成成员变量
    protected Circle circle;

    public RedCircleDecorator(Shape circle) {
        this.circle = (Circle) circle;
    }

    @Override
    void draw() {
//        decoratorShape.draw();
        setRedBorder(circle);
    }
    /**
     * 实现自己需要装饰的业务逻辑
     */
    private void setRedBorder(Shape circle){
        System.out.println("Circle draw red line 。。。");
    }
}
