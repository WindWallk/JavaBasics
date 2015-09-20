package org.windwallk.OneLevShop.Products;

import org.windwallk.OneLevShop.Enums.AgeRestriction;
import org.windwallk.OneLevShop.Interfaces.Expirable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FoodProduct extends Product implements Expirable {
    private LocalDate expirationDate;

    public FoodProduct(String name, double price, double quantity, AgeRestriction ageRestriction, LocalDate expirationDate) {
        super(name, price, quantity, ageRestriction);
        this.setExpirationDate(expirationDate);
        this.checkExpirationDate(this.getPrice());
    }

    @Override
    public LocalDate getExpirationDate() {
        return null;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void checkExpirationDate(double price) {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = this.expirationDate;
        long daysTillExpirationDate = ChronoUnit.DAYS.between(currentDate, expirationDate);
        if (daysTillExpirationDate <= 15) {
            double newPrice = price * 0.7;
            super.setPrice(newPrice);
        } else {
            super.setPrice(price);
        }
    }
}
