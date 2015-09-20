package org.windwallk.OneLevShop;

import org.windwallk.OneLevShop.Enums.AgeRestriction;
import org.windwallk.OneLevShop.Exceptions.NoPermissionException;
import org.windwallk.OneLevShop.Exceptions.NotEnoughMoneyException;
import org.windwallk.OneLevShop.Exceptions.ProductExpiredException;
import org.windwallk.OneLevShop.Exceptions.ProductOutOfStockException;
import org.windwallk.OneLevShop.Interfaces.Expirable;
import org.windwallk.OneLevShop.Products.Customer;
import org.windwallk.OneLevShop.Products.FoodProduct;
import org.windwallk.OneLevShop.Products.Product;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PurchaseManager {
    static {

    }

    public static void processPurchase(Product product, Customer customer)
            throws NoPermissionException, NotEnoughMoneyException, ProductExpiredException, ProductOutOfStockException {
        productOutOfStockCheck(product);
        if (product instanceof Expirable && ((Expirable) product).getExpirationDate() != null) {
            productExpiredCheck((FoodProduct) product);
        }
        enoughBalanceCheck(customer.getBalance(), product.getPrice());
        if (product.getAgeRestriction() != AgeRestriction.None) {
            permissionCheck(product.getAgeRestriction(), customer.getAge());
        }

        double reducedBalance = customer.getBalance() - product.getPrice();
        customer.setBalance(reducedBalance);

        double reducedQuantity = product.getQuantity() - 1;
        product.setQuantity(reducedQuantity);
    }

    private static void productOutOfStockCheck(Product product) throws ProductOutOfStockException {
        if (product.getQuantity() == 0) {
            throw new ProductOutOfStockException("The product is out of stock!");
        }
    }

    private static void enoughBalanceCheck(double balance, double price) throws NotEnoughMoneyException {
        if (price > balance) {
            throw new NotEnoughMoneyException("You do not have enough money to buy this product!");
        }
    }

    private static void productExpiredCheck(FoodProduct product) throws ProductExpiredException {
        LocalDate currentDate = LocalDate.now();
        boolean isExpired = ChronoUnit.DAYS.between(currentDate,product.getExpirationDate()) <= 0;
        if (isExpired) {
            throw new ProductExpiredException("The product is expired!");
        }
    }

    private static void permissionCheck(AgeRestriction ageRestriction, int age) throws NoPermissionException {
        boolean isTeenager = age < 18;
        boolean isAdult = age >= 18;
        if ((isTeenager && ageRestriction == AgeRestriction.Adult) || (isAdult && ageRestriction == AgeRestriction.Teenager)) {
            throw new NoPermissionException("You are too young to buy this product!!");
        }
    }
}
