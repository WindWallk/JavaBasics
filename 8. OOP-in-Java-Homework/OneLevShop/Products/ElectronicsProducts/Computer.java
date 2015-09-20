package org.windwallk.OneLevShop.Products.ElectronicsProducts;

import org.windwallk.OneLevShop.Enums.AgeRestriction;

public class Computer extends ElectronicsProduct{
    private static final int APPLIANCE_GUARANTEE_PERIOD = 12;
    private static final int MIN_PROMOTIONAL_QUANTITY = 50;

    public Computer(String name, double price, double quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, APPLIANCE_GUARANTEE_PERIOD);
        this.checkGuaranteePeriod();
    }

    private void checkGuaranteePeriod() {
        if (super.getQuantity() > MIN_PROMOTIONAL_QUANTITY) {
            double newPrice = this.getPrice() * 0.95;
            this.setPrice(newPrice);
        }
    }
}
