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

/*
Now, for every new type of shipping we just need to create a new class, implement the interface,
and implement the Ship method, not having to change any other existing shipping class.

If we need to change an existing shipping way we do not need to change the same big class anymore, which is great.

But anyway, it still can be improved, imagine we want to avoid having to think about which class we should use,
and instead of that we would prefer to have a component that handles all this creation process for us, in this case, we can use a factory.
 */


