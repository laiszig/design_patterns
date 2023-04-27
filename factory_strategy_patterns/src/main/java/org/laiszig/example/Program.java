package org.laiszig.example;

public class Program {
}

class Shipping {
    public void shipByCar() {
        System.out.println("Shipping by Car");
    }

    public void shipByTrain() {
        System.out.println("Shipping by Train");
    }

    public void shipByAirplane() {
        System.out.println("Shipping by Airplane");
    }
}

class Main {
    public static void main(String[] args) {
        Shipping shipping = new Shipping();
        shipping.shipByCar();
        shipping.shipByTrain();
        shipping.shipByAirplane();
    }
}

