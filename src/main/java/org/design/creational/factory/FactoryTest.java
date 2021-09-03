package org.design.creational.factory;

/*


 */
public class FactoryTest {
    public static void main(String[] args) {
        //初级的多态应用
//        Vehicle vehicle = new Bus();
//        vehicle.move();
//        vehicle = new Car();
//        vehicle.move();

        VehicleFactory vehicleFactory=new VehicleFactory();
        Car car =vehicleFactory.createCar();
        car.move();
        Bus bus =vehicleFactory.createBus();
        bus.move();
    }
}
