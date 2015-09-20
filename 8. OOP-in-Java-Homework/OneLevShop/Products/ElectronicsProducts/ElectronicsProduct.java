package org.windwallk.OneLevShop.Products.ElectronicsProducts;

import org.windwallk.OneLevShop.Enums.AgeRestriction;
import org.windwallk.OneLevShop.Products.Product;

public abstract class ElectronicsProduct extends Product{
    private int guaranteePeriod;

    protected ElectronicsProduct(
            String name, double price, double quantity, AgeRestriction ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.setGuaranteePeriod(guaranteePeriod);
    }

    public int getGuaranteePeriod() {
        return this.guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        if (guaranteePeriod < 0) {
            throw new IllegalArgumentException("Guarantee period cannot be negative");
        }
        this.guaranteePeriod = guaranteePeriod;
    }
}
