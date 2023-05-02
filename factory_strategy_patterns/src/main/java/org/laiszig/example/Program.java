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

/*
This implementation is valid, but it is not ideal because the class can become huge if we add more different types of shipping,
and the same class will be changed every time we need to adjust or change any existing shipping way.

It definitely can become a bottleneck in the future.

In order to improve the code, we can start breaking the class into multiple other classes, and since they basically
are only used to ship a product in different ways, we can create an interface, create a class for every kind of shipping,
and ensure those classes implement the interface and implement the method to Ship the product
 */
