package org.laiszig.improved;

public class Program {
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
        IShipping carShipping = new CarShipping();
        carShipping.ship();

        IShipping trainShipping = new TrainShipping();
        trainShipping.ship();

        IShipping airplaneShipping = new AirplaneShipping();
        airplaneShipping.ship();
    }
}


