package task.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
    private String name;
    private double balance;
    private Shop shop;
    private Map<Product, Integer> basket = new HashMap<>();

    public Client(String name, double balance, Shop shop) {
        this.name = name;
        this.balance = balance;
        this.shop = shop;
    }


    public void buyProduct( Product product, Integer count){
        // положенные продукты в корзине передать кассиру и снять деньги с баланса
        if(product.getPrice() < balance)
        basket.put(product, count);
        else
            System.out.println("Sorry, you don't have enough money right now.");
    }

    public void findProductByName(Product value){
        // найти продукт в мапе по имени
        shop.getWarehouse().getProductMap().containsValue(value);
    }

    public void addProductToBucket(Product productName, int quantity){
        // положить выбранные продукты в корзину

        basket.put( productName, quantity);
    }

    public void deleteProductFromBucket(Product productName, int quantity){
        // убрать выбранные продукты и вернуть в вархауз
        int currentAmount = basket.getOrDefault(productName, 0);
        if ( currentAmount > quantity)
        basket.put(productName, currentAmount - quantity);
        else
            basket.remove(productName);
    }

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public double getBalance() {
        return balance;
    }

    public Shop getShop() {
        return shop;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
}
