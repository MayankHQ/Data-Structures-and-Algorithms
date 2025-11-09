package Classwork;

public class lec1 {
    public static void main(String[] args) {
        Vehicle v1 = new Car(4, 1500, "Diesel");
        v1.getInfo();
        Vehicle v2 = new Bike(2, 650, "Petrol");
        v2.getInfo();
    }
}
// Parent class
class Vehicle {
    int wheels;
    int engine;
    String fuelType;

    Vehicle(int wheels, int engine, String fuelType) {
        this.wheels = wheels;
        this.engine = engine;
        this.fuelType = fuelType;
    }

    void getInfo() {
        System.out.println("No. of wheels : " + wheels);
        System.out.println("Engine Capacity: " + engine + "cc");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Child class

class Car extends Vehicle {

    Car(int wheels, int engine, String fuelType) {

        super(wheels, engine, fuelType);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("This is a car.");
    }
}

class Bike extends Vehicle {

    Bike(int wheels, int engine, String fuelType) {
        super(wheels, engine, fuelType);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("This is a bike.");
    }
}

