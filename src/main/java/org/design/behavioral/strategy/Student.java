package org.design.behavioral.strategy;

public class Student implements Comparable<Student> {
    int height, weight;

    public Student(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.height > o.height) return 1;
        else if (this.height < o.height) return -1;
        else return 0;
    }
}
