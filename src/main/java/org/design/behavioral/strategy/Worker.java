package org.design.behavioral.strategy;

public class Worker implements Comparable<Worker> {
    int height, weight;

    public Worker(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
    @Override
    public int compareTo(Worker o1) {
        if (this.height > o1.height) return 1;
        else if (this.height < o1.height) return -1;
        else return 0;
    }
}
