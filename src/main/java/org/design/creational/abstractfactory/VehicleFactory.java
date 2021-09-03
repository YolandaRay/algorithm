package org.design.creational.abstractfactory;

public class VehicleFactory extends AbstractFactory{

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Food createFood() {
        return new Bread();
    }
}
