package task.Task.data;

import task.Task.OldClasses.Shop;
import task.Task.dao.ClientDao;

import java.util.*;


public class Client {
    private Long id;
    private String name;
    private double balance;
    private Shop shop;
    private Map<Product, Integer> basket = new HashMap<>();

    public Client(Long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;

    }

    private boolean isReadyToPay(double amount) {
        return (amount <= balance);
    }
    public boolean payForProducts(double priceToPay) {
        if (isReadyToPay(priceToPay)) {
            balance -= priceToPay;
            basket.clear();
        } else {
            return false;
        }
        return true;
    }


    public boolean addProductToBasket(Product product, int count) {
        if (basket.containsKey(product)) {
            basket.put(product, basket.get(product) + count);
        } else {
            basket.put(product, count);
        }
        if (basket.containsKey(product) && basket.get(product) >= count) {
            shop.getWarehouse().removeProduct(product, count);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeProductFromBasket(Product product, int count) {
        if (basket.containsKey(product)) {
            basket.remove(product, basket.get(product) + count);
        } else {
            basket.remove(product, count);
        }
        if (basket.containsKey(product) && basket.get(product) >= count) {
            shop.getWarehouse().addProduct(product, count);
            return true;
        } else {
            return false;
        }
    }

    public static Product findProductByName(String name, Client client) {
        for (Product product : client.getShop().getWarehouse().getProductMap().keySet()) {
            String fullName = product.getName();
            int spaceIndex = fullName.indexOf(" ");
            if (spaceIndex != -1) {
                String namePrefix = fullName.substring(0, spaceIndex).trim();
                if (namePrefix.equalsIgnoreCase(name)) {
                    return product;
                }
            }
        }
        return null;
    }


    public  Map<Product, Integer> getBasket() {
        return basket;
    }

    public double getBalance() {
        return balance;
    }

    public Shop getShop() {
        return shop;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", shop=" + shop +
                ", basket=" + basket +
                '}';
    }
}
