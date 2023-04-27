package org.laiszig.patterns;

enum ShippingType {
    Car, Train, Airplane
}

public class ShippingFactory {
    public IShipping getShipping(ShippingType shippingType) {
        switch (shippingType) {
            case Train:
                return new TrainShipping();
            case Airplane:
                return new AirplaneShipping();
            default:
                return new CarShipping();
        }
    }
}

interface IShipping {
    void ship();
}

class CarShipping implements IShipping {
    public void ship() {
        System.out.println("Shipping by Car");
    }
}

class TrainShipping implements IShipping {
    public void ship() {
        System.out.println("Shipping by Train");
    }
}

class AirplaneShipping implements IShipping {
    public void ship() {
        System.out.println("Shipping by Airplane");
    }
}

class Main {
    public static void main(String[] args) {
        ShippingFactory factory = new ShippingFactory();

        IShipping carShipping = factory.getShipping(ShippingType.Car);
        carShipping.ship();

        IShipping trainShipping = factory.getShipping(ShippingType.Train);
        trainShipping.ship();

        IShipping airplaneShipping = factory.getShipping(ShippingType.Airplane);
        airplaneShipping.ship();
    }
}