package org.design.creational.abstractfactory;

public class FoodFactory extends AbstractFactory {

    @Override
    Vehicle createVehicle() {
        return new Bus();
    }

    @Override
    Food createFood() {
        return new Mushroom();
    }
}
