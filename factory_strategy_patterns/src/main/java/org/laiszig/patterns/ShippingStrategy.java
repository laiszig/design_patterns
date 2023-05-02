package org.laiszig.patterns;

public class ShippingStrategy {
    private IShipping shipping;

    public ShippingStrategy(IShipping shipping) {
        this.shipping = shipping;
    }

    public void ship() {
        this.shipping.ship();
    }
}

class Main2 {
    public static void main(String[] args) {
        ShippingStrategy carShipping = new ShippingStrategy(new CarShipping());
        carShipping.ship();

        ShippingStrategy trainShipping = new ShippingStrategy(new TrainShipping());
        trainShipping.ship();

        ShippingStrategy airplaneShipping = new ShippingStrategy(new AirplaneShipping());
        airplaneShipping.ship();
    }

}

