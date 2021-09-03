package org.design.behavioral.strategy;

public class WorkWeightComparator implements Comparator<Worker> {

    @Override
    public int compareTo(Worker o1, Worker o2) {
        if (o1.weight > o2.weight) return 1;
        else if (o1.weight < o2.weight) return -1;
        else return 0;
    }
}
