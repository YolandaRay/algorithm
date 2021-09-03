package org.design.behavioral.strategy;

import java.util.Arrays;

/*
对象实现Comparable 接口中的compareTo方法，>返回正数，<返回负数，=返回0，在排序函数中，使用对象成员方法来比较大小。


Sorter类
（1）对int排序，对double排序，对Student、Cat、Dog排序怎么办？即支持多种对象排序
方式一、在sort中，针对每一种对象类型，每一种比较方式，都写一种排序方式，调用的时候根据对象类型，调用相应的排序方法。
方式二、传入对象设置成Object，但是Object中没有compareTo方法。解决方案：传入对象参数设置成Comparable<T>，需要排序的对象实现Comparable接口中compareTo接口。
加入泛型，让调用者自己指定类型。泛型在编译的时候替换成真实的对象，擦除。
（2）对Student中weight、height排序怎么办？即支持一个对象多种属性排序
开闭原则，对修改关闭，对扩展开放。
    Sorter类中sort函数受两方面影响：（1）传入对象（2）对象大小比较方式


 */
public class CompareTest {
    public static void main(String[] args) {
        Student[] students = {new Student(180, 60), new Student(170, 90), new Student(160, 80)};
        Worker[] workers = {new Worker(190, 60), new Worker(170, 90), new Worker(160, 80)};
        Sorter<Student> sorter = new Sorter<>();
        Sorter<Worker> sorterWork = new Sorter<>();
        //可以使用lambda
//        sorter.sort(students, (o1, o2) -> {
//            if (o1.weight < o2.weight) return -1;
//            else if (o1.weight > o2.weight) return 1;
//            else return 0;
//        });
//        System.out.println(Arrays.toString(students));
//        sorter.sortStudent(students);
//        System.out.println(Arrays.toString(students));

        sorterWork.sort(workers, new WorkWeightComparator());
        System.out.println(Arrays.toString(workers));

//        sorterWork.sortComparable(workers);
//        sorter.sortComparable(workers);
//        System.out.println(Arrays.toString(workers));
    }
}
