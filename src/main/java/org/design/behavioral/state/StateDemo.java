package org.design.behavioral.state;
/*
根究状态决定行为
如果一个类的很多operation、行为、操作，跟state有关，根据不同的state去实现，
不如把操作抽象出来，提取到state中，在state中实现。

在《设计模式：可复用面向对象软件的基础》
Erich Gamma
Richard Helm
Ralph Johnson
John Vlissides

在这本书中举的例子：TCP Connection
open()
close()
Acknowledge()
operation不扩展，可以使用state模式。

有限状态机（FSM），状态之间如何迁移变化。
线程迁移态

 */
public class StateDemo {
}
