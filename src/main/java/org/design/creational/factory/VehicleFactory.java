package org.design.creational.factory;

public class VehicleFactory {
    public Car createCar() {
        return new Car();
    }

    public Bus createBus() {
        return new Bus();
    }
}
