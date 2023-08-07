package task.Task.data;
import task.Task.dao.OrderDao;
import task.Task.dao.ShopDao;

import java.util.Map;

public class Shop {
    private Casher cashers;
    private double bank;
    private String shopName;
    private ShopDao shopDao = new ShopDao();

    public Casher getCashers() {
        return cashers;
    }

    public Shop(String name, Double balance) {
        this.shopName = name;
        this.bank = balance;
        this.cashers = new Casher("Cashier", 10);
    }

    public ShopDao getShopDao() {
        return shopDao;
    }

    public double performSale(Client client) {
        double price = 0.0;
        for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
            price += entry.getKey().getPrice()* entry.getValue().intValue();
        }
        double scannedPrice = client.getShop().cashers.scanProduct(client);
        if (price == scannedPrice) {
            return price;
        } else {
            throw new RuntimeException("Price mismatch. Expected: " + price + ", Scanned: " + scannedPrice);
       }
    }

    public boolean processPayment(Client client, double totalPrice) {
        if(client.payForProducts(totalPrice) == true) {
            bank += totalPrice;
            client.getShop().getShopDao().getMoney(totalPrice);
            createOrder(client);
            return true;
        } if(client.payForProducts(totalPrice) == false) {
            return false;
        }
        return false;
    }

    public void createOrder(Client client){
        OrderDao orderDao = new OrderDao();
        orderDao.writeBasketToFile(client.getBasket());
    }



}
