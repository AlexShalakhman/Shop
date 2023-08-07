package task.Task.data;
import task.Task.dao.ShopDao;

import java.util.*;


public class Client {
    private Long id;
    private String name;
    private ShopDao shopDao = new ShopDao();
    private double balance;
    private Shop shop;
    private Map<Product, Integer> basket = new HashMap<>();

    public Client(Long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.shop = shopDao.initializeShop();

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


    public Shop getShop() {
        return shop;
    }

    public boolean addProductToBasket(Product product, int count) {
        if (basket.containsKey(product)) {
            basket.put(product, basket.get(product) + count);
        } else {
            basket.put(product, count);
        }
        if (basket.containsKey(product) && basket.get(product) >= count) {

            return true;
        } else {
            return false;
        }
    }

    public boolean removeProductToBasket(Product product, int count) {
        if (basket.containsKey(product)) {
            basket.remove(product, basket.get(product) + count);
        } else {
            basket.remove(product, count);
        }
        if (basket.containsKey(product) && basket.get(product) >= count) {

            return true;
        } else {
            return false;
        }
    }




    public  Map<Product, Integer> getBasket() {
        return basket;
    }

    public double getBalance() {
        return balance;
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
                ", basket=" + basket +
                '}';
    }

    public void placeOrder(){

    }
}
